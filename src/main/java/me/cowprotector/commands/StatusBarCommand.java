package me.cowprotector.commands;

import me.cowprotector.bar.Bar;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Locale;

import static me.cowprotector.util.Util.getCardinalDirection;
import static me.cowprotector.util.Util.getLocation;

@CommandInfo(name = "statusbar", requiresPlayer = true)
public class StatusBarCommand extends PluginCommand {

    private Bar bar;

    @Override
    public void execute(Player p, String[] args) {

        World w = p.getWorld();
        String name = p.getName();
        String biome = p.getLocation().getBlock().getBiome().toString().toLowerCase(Locale.ROOT);
        String direction = getCardinalDirection(p);
        String location = getLocation(p);

        long time = w.getTime();
        long hours = (time / 1000) + 6;
        long minutes = ((time % 1000) * 60 / 1000);
        String hh = "0" + hours;
        hh = hh.substring(hh.length() - 2, hh.length());
        String mm = "0" + minutes;
        mm = mm.substring(mm.length() - 2, mm.length());
        long gameTime = w.getGameTime();
        long day = (gameTime / (20*60*60*24)) + 1;
        String date = "Day " + day + " " + hh + ":" + mm;

        String title = name + " in " + biome +
                "; Looking " + direction + " at " + location +
                "; On " + date;

        bar = new Bar();
        bar.createBar(title);

        // /statusbar [[time] ["all" | player...]]

        int hideTime = 10;
        if (args.length > 0) {
            // first arg is the time to display the bar
            try {
                hideTime = Integer.parseInt(args[0]);
            }
            catch (Exception e) {
                p.sendMessage("invalid arg, expecting integer for time to display status bar");
                return;
            }
        }
        bar.hideBar(hideTime);

        bar.addPlayer(p); // we always show the bar to ourself

        if (args.length > 1) {
            // might be "all" or a list of players...
            if (args[1].equalsIgnoreCase("all")) {
                List<Player> players = w.getPlayers();
                for (Player player : players) {
                    bar.addPlayer(player);
                }
                return;
            } else {
                for (int i = 1; i < args.length; ++i) {
                    Player player = Bukkit.getPlayer(args[i]);
                    if (player != null) {
                        bar.addPlayer(player);
                    } else {
                        p.sendMessage("Player " + args[i] + " is not online");
                    }
                }
            }
        }

    }
}
