package br.victor.savessentials;

import org.bukkit.plugin.java.JavaPlugin;

import br.victor.saveessentials.commandmanager.CommandManager;
import br.victor.savessentials.commands.BroadcastMessageCommand;
import br.victor.savessentials.commands.HealthCommand;
import br.victor.savessentials.commands.KillCommand;

public class Main extends JavaPlugin {
	CommandManager cm = new CommandManager();
	private static Main instance;
	public static Main getMain() {
		return instance;
	}
	
	public void onEnable() {
		
		instance = this;
		registerCommands();
		System.out.println("Plugin carregado com sucesso.");
	}
	
	public void onDisable() {
	System.out.println("Plugin descarregado com sucesso.");
	}
	
	void registerCommands() {
		try {
			cm.addCommand(new HealthCommand(), this);
			cm.addCommand(new KillCommand(), this);
			cm.addCommand(new BroadcastMessageCommand(), this);
			
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}
}
