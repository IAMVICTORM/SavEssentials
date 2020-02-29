package br.victor.saveessentials.commandmanager;

import java.lang.reflect.Method;

import org.bukkit.command.Command;
import org.bukkit.plugin.Plugin;
public class CommandManager {
	
	public void addCommand(Command cmd, Plugin plugin) throws ReflectiveOperationException {
        Method commandMap = plugin.getServer().getClass().getMethod("getCommandMap");
        Object cmdmap = commandMap.invoke(plugin.getServer());
        Method register = cmdmap.getClass().getMethod("register", String.class, Command.class);
        register.invoke(cmdmap, cmd.getName(), cmd);
    }
	
	
	
}
