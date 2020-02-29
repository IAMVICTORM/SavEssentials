package br.victor.savessentials.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastMessageCommand extends Command {

	public BroadcastMessageCommand() {
		super("aviso");
		this.setDescription("Comando usado para mandar um aviso para todo o servidor.");
		this.setUsage("/aviso <mensagem>");
		this.setPermission("savessentials.command.broadcast");
		this.setAliases(Arrays.asList("broadcast", "bm", "a"));
		this.setPermissionMessage(ChatColor.RED + "Você não tem permissão para usar esse comando!");
	}

	@Override
	public boolean execute(CommandSender s, String arg, String[] args) {
		if (!(s instanceof Player)) {
			s.sendMessage("Você precisa ser um jogador para executar este comando.");
			return true;
		}
		Player p = (Player) s;
		if (!(p.hasPermission(this.getPermission()))) {
			p.sendMessage(this.getPermissionMessage());
			return true;
		}
		if (args.length == 0) {
			s.sendMessage(ChatColor.RED + "Use: " + this.getUsage() + ".");
			return true;

		}
		StringBuilder message = new StringBuilder();
		message.append(ChatColor.YELLOW + "[" + ChatColor.GREEN + "Aviso" + ChatColor.YELLOW + "] ");
		if (args.length > 0) {
			message.append(args[0]);
			for (int i = 1; i < args.length; i++) {
				message.append(" ").append(args[i]);
			}

		}
		for (Player ponline : Bukkit.getOnlinePlayers()) {
			ponline.sendMessage("");
			ponline.sendMessage(message.toString());
			ponline.sendMessage("");

		}
		return false;
	}
}
