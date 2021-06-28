package me.cowprotector.util;

import org.bukkit.entity.Player;

public class Util {

    public static String getCardinalDirection(Player player) {
        double yaw = player.getLocation().getYaw(); // range is -180 to 180, south is 0, east is -45, west is 45, north is +/-180
        int rotation = (int) (yaw + 180);
        if (0 <= rotation && rotation < 45) {
            return "North (neg Z)";
        } else if (45 <= rotation && rotation < 135) {
            return "East (pos X)";
        } else if (135 <= rotation && rotation < 225) {
            return "South (pos Z)";
        } else if (225 <= rotation && rotation < 315) {
            return "West (neg X)";
        } else {
            return "North (neg Z)";
        }
    }

    public static String getLocation(Player p) {
        String x = String.valueOf((int) p.getLocation().getX());
        String y = String.valueOf((int) p.getLocation().getY());
        String z = String.valueOf((int) p.getLocation().getZ());

        return x + " / " + y + " / " + z;
    }
}
