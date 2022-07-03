package de.celinadev.celib.command;

import org.bukkit.command.CommandSender;

import java.util.List;

public interface ICommand {

    String getName();

    String[] getNeededPermissions();

    String getNoPermissionMessage(List<String> missingPermissions);

    void run(CommandSender sender, String[] args);
}
