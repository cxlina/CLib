package de.celinadev.clib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class TaskUtil {

    private static final JavaPlugin plugin = CLib.getInstance().getPlugin();

    public static BukkitTask runDelayed(int delayedTicks, RunAction action) {
        return Bukkit.getScheduler().runTaskLater(plugin, action::run, delayedTicks);
    }

    public static BukkitTask runTimer(int pauseTicks, RunAction action) {
        return Bukkit.getScheduler().runTaskTimer(plugin, action::run, 0, pauseTicks);
    }

    public static BukkitTask runDelayedTimer(int delayedTicks, int pauseTicks, RunAction action) {
        return Bukkit.getScheduler().runTaskTimer(plugin, action::run, delayedTicks, pauseTicks);
    }

    public static BukkitTask runDelayed_async(int delayedTicks, RunAction action) {
        return Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, action::run, delayedTicks);
    }

    public static BukkitTask runTimer_async(int pauseTicks, RunAction action) {
        return Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, action::run, 0, pauseTicks);
    }

    public static BukkitTask runDelayedTimer_async(int delayedTicks, int pauseTicks, RunAction action) {
        return Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, action::run, delayedTicks, pauseTicks);
    }

    public interface RunAction {
        public void run();
    }
}
