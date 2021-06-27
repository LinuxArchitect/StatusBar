package me.cowprotector.bar;

// credit to CodedRed; https://youtu.be/9apL86E05Bc

import static me.cowprotector.statusbar.StatusBar.plugin;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class Bar {

    private BukkitTask taskID;
    private BossBar bar;
    private Boolean visible;

    public void addPlayer(Player player) {
        bar.addPlayer(player);
    }

    public BossBar getBar() {
        return bar;
    }

    public void createBar(String title) {
        bar = Bukkit.createBossBar(title, BarColor.BLUE, BarStyle.SOLID);
        visible = true;
        bar.setVisible(visible);
    }

    public void hideBar(int seconds) {
        taskID = Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
            @Override
            public void run() {
                bar.setVisible(false);
            }
        }, seconds*20);
    }
}
