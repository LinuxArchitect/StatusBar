package me.cowprotector.statusbar;

import me.cowprotector.commands.PluginCommand;
import me.cowprotector.commands.StatusBarCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

public final class StatusBar extends JavaPlugin {

    public static StatusBar plugin;

    @Override
    public void onEnable() {
        plugin = this;

        // register all listeners at runtime, credit to Jordan Osterberg https://www.patreon.com/jordanosterberg
// this is broken in JDK 16
//        for (Class<?> clazz : new Reflections(packageName + ".listeners")
//                .getSubTypesOf(Listener.class)
//        ) {
//            System.out.println("Trying to register listener...");
//            try {
//                Listener listener = (Listener) clazz
//                        .getDeclaredConstructor()
//                        .newInstance();
//                getServer().getPluginManager().registerEvents(listener, this);
//                System.out.println("registered: " + listener.getClass().getName());
//            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//                e.printStackTrace();
//            }
//        }

        // register all commands at runtime, credit to Jordan Osterberg https://www.patreon.com/jordanosterberg
// this is broken in JDK 16
//        for (Class<? extends PluginCommand> clazz : new Reflections(packageName + ".commands")
//                .getSubTypesOf(PluginCommand.class)
//        ) {
//            System.out.println("Trying to register command...");
//            try {
//                PluginCommand pluginCommand = clazz.getDeclaredConstructor().newInstance();
//                getCommand(pluginCommand.getCommandInfo().name()).setExecutor(pluginCommand);
//                System.out.println("registered: " + pluginCommand.getCommandInfo().name());
//            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//                e.printStackTrace();
//            }
//        }

        // register commands the old fashioned way...
        StatusBarCommand commands = new StatusBarCommand();
        getCommand("statusbar").setExecutor(commands);
    }
}
