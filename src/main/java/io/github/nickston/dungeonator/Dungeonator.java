package io.github.nickston.dungeonator;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public final class Dungeonator extends JavaPlugin {

	ArrayList<String> dungeonList = new ArrayList<String>();

	@Override
	public void onEnable() {
		getLogger().info("onEnable called");
		boolean success = (new File("./plugins/Dungeonator")).mkdirs();
		if (!success)
			return;
	}

	@Override
	public void onDisable() {
		getLogger().info("onDisable called");

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("dungeon")) {
			if (args.length == 0) {
				// TODO: Add /dungeon functionality
				// TODO: /dungeon lists all commands.

				sender.sendMessage(ChatColor.AQUA + "Available dungeons:");

				// for (int i = 0; i < dungeonList.size(); i++) {
				// sender.sendMessage(dungeonList.get(i));
				// }
			} else if (args.length == 1 && args[0].equalsIgnoreCase("")) {

				// TODO: Add commands that require a single argument
				// TODO: list

			} else if (args.length == 2 && args[0].equalsIgnoreCase("add")) {
				if (!(sender instanceof Player)) {
					sender.sendMessage("You need to be a player to add a dungeon.");
				} else {
					try {
						addDungeon(args[1]);
					} catch (IOException e) {
						sender.sendMessage("IOException catched. Stop doing something wrong.");
						e.printStackTrace();
					}
				}
			}

			return true;

		}

		return false;

	}

	public void addDungeon(String string) throws IOException {
		// Note the "\\" used in the path of the file instead of "\",
		// this is required to read the path in the String format.
		BufferedWriter fw = new BufferedWriter(new FileWriter(
				"./plugins/Dungeonator/Dungeonator.yml", true));
		PrintWriter pw = new PrintWriter(fw);

		// Write to file line by line
		pw.println(string + ",200,64,90");

		// Flush the output to the file
		pw.flush();

		// Close the Print Writer
		pw.close();

		// Close the File Writer
		fw.close();
	}
}