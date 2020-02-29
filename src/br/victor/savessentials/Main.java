package br.victor.savessentials;

import org.bukkit.plugin.java.JavaPlugin;

import br.victor.saveessentials.commandmanager.CommandManager;
import br.victor.savessentials.commands.HealthCommand;

public class Main extends JavaPlugin {
	CommandManager cm = new CommandManager();
	private static Main instance;
	public static Main getMain() {
		return instance;
	}
	
	public void onEnable() {
		instance = this;
		try {
			cm.addCommand(new HealthCommand(), this);
			
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
		System.out.println("Plugin carregado com sucesso.");
	}
	
	public void onDisable() {
	System.out.println("Plugin descarregado com sucesso.");
	}
}
