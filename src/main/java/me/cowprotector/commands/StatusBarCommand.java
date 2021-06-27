package me.cowprotector.commands;

import me.cowprotector.bar.Bar;
import org.bukkit.World;
import org.bukkit.entity.Player;

import static me.cowprotector.util.Util.getCardinalDirection;
import static me.cowprotector.util.Util.getLocation;

@CommandInfo(name = "statusbar", requiresPlayer = true)
public class StatusBarCommand extends PluginCommand {

    private Bar bar;

    @Override
    public void execute(Player p, String[] args) {

        World w = p.getWorld();

        String name = p.getName();
        String direction = getCardinalDirection(p);
        String location = getLocation(p);

        long time = w.getTime();
        long hours = (time / 1000);
        long minutes = ((time % 1000) * 60 / 1000);
        long gameTime = w.getGameTime();
        long day = (gameTime / (20*60*60*24)) + 1;
        String date = "Day " + day + " " + hours + ":" + minutes;

        String title = name + " Looking " + direction + " at " + location + " on " + date;

        bar = new Bar();
        bar.createBar(title);
        bar.addPlayer(p);
        bar.hideBar(10);
    }
}
