package br.victor.savessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

import net.md_5.bungee.api.ChatColor;

public class KillCommand extends Command {

	public KillCommand() {
		super("kill");
		this.setDescription("Comando usado para suícidio ou para matar outro jogador");
		this.setUsage("/kill (jogador)");
		this.setPermission("savessentials.command.suicide");
		this.setAliases(Arrays.asList("s", "suicide"));
		this.setPermissionMessage(ChatColor.RED + "Você não tem permissão para usar esse comando!");
	}

	@Override
	public boolean execute(CommandSender s, String arg, String[] args) {
		if (!(s instanceof Player)) {
			s.sendMessage("Você precisa ser um jogador para executar este comando.");
			return true;
		}

		Player player = (Player) s;
		if (!(player.hasPermission(this.getPermission()))) {
			player.sendMessage(this.getPermissionMessage());
			return true;
		}
		if (args.length >= 1)
			player.sendMessage(ChatColor.RED + "Use: " + this.getUsage());

	    
		if (args.length == 0) {
			player.setHealth(0);
		} else if (!(Bukkit.getPlayer(args[0]) == null)) {
			Player target = Bukkit.getPlayer(args[0]);
			target.setHealth(0.0D);

		} else {
			player.sendMessage(ChatColor.RED + "O jogador não está online.");
		}
		return false;

	}

}
