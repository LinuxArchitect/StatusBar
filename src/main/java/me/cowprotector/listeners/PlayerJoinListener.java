package me.cowprotector.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
  @EventHandler
  private void onJoin(PlayerJoinEvent event) {
    Bukkit.broadcastMessage("Welcome to the server, " + event.getPlayer().getDisplayName() + "!");
  }
}
