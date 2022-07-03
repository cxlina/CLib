package de.celinadev.celib.command;

import de.celinadev.celib.CeLib;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class CommandUtil implements CommandExecutor {

    private static final List<Command> registeredCommands = new ArrayList<>();

    public static void register(Command... commands) {
        for (Command command : commands) {
            if (CeLib.getInstance().getPlugin().getCommand(command.getName()) == null) {
                CeLib.getInstance().getPlugin().getLogger().warning("Couldn't register command '" + command.getName() + "' because it's null. You likely forgot to add it to your plugin.yml");
                continue;
            }
            CeLib.getInstance().getPlugin().getCommand(command.getName()).setExecutor(new CommandUtil());
            registeredCommands.add(command);
        }
    }

    public static List<Command> getRegisteredCommands() {
        return registeredCommands;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        for (Command c : registeredCommands) {
            if (command.getName().equalsIgnoreCase(c.getName())) {
                List<String> missingPermissions = new ArrayList<>();
                for (String permission : c.getNeededPermissions()) {
                    if (!sender.hasPermission(permission)) {
                        missingPermissions.add(permission);
                    }
                }
                if (!missingPermissions.isEmpty()) {
                    sender.sendMessage(c.getNoPermissionMessage(missingPermissions));
                    return false;
                }
                c.run(sender, args);
                return true;
            }
        }
        return false;
    }
}
