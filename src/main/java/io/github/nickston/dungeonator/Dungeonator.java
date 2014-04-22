package io.github.nickston.dungeonator;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Dungeonator extends JavaPlugin {
	
	ArrayList<String> dungeonList = new ArrayList<String>();

	@Override
	public void onEnable() {
		getLogger().info("onEnable called");
	}

	@Override
	public void onDisable() {
		getLogger().info("onDisable called");

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		
		
		if (cmd.getName().equalsIgnoreCase("dungeon")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage("You need to be a player to use this command.");
			}
			// TODO: Add /dungeon functionality
			
			sender.sendMessage(ChatColor.AQUA + "Available dungeons:");

			for (int i = 0; i < dungeonList.size(); i++){
				sender.sendMessage(dungeonList.get(i));
			}
			return true;
			
		}
		
		return false;
	
	}
}