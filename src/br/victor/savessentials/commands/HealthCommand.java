package br.victor.savessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class HealthCommand extends BukkitCommand {

	public HealthCommand() {
		super("health", "Cura-se", "/health", Arrays.asList("heal", "hl"));

	}

	@Override
	public boolean execute(CommandSender s, String cmd, String[] args) {
		if (!(s instanceof Player)) {
			s.sendMessage("Você precisa ser um jogador para executar este comando.");
			return true;
		}
		Player player = (Player) s;
		if (!player.hasPermission("savessentials.command.health"))
			return true;
		if (args.length == 0) {
			player.sendMessage(ChatColor.GREEN + "Você se curou!");
			player.setHealth(20.0);
			player.setFoodLevel(20);
		} else if (!(Bukkit.getPlayer(args[0]) == null)) {
			Player target = Bukkit.getPlayer(args[0]);
			target.setHealth(20.0);
			target.setFoodLevel(20);
			target.sendMessage(ChatColor.GREEN + "Você foi curado.");
		} else {
			player.sendMessage(ChatColor.RED + "Esse jogador não está online ou não existe!");
		}
		return false;
	}

}
