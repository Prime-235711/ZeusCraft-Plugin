package me.prime.ZeusServer.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.prime.ZeusServer.Main;
import net.md_5.bungee.api.ChatColor;

public class Smite implements CommandExecutor{
	private Main plugin;
	
	public Smite(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("smite").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		//This creates a variable of type Player named player and casts the sender to sender that is input when the command is called. To cast means to change the type
		Player player = (Player) sender;
		
		//This checks that the person who uses this command is OPed
		if(player.isOp()) {
			
			//This makes sure that they actually inputed a player to smite
			if(args.length > 0) {
				
				//This creates a variable of type Player named toSmite by finding the inputed player
				Player target = Bukkit.getPlayer(args[0]); 
				
				//This check to see if the player it just found is null meaning it did not fine it correctly
				if(target == null) {
					//This is send if they did not input a accurate player name
					player.sendMessage(ChatColor.RED + "Input valid player name.");
					return false;
				}
				
				//This creates two variables one for the targets location and the other for the targets world
				Location targetLocation = target.getLocation();
				World targetWorld = target.getWorld();

				//This strikes lighting in targetWorld at the location targetLocation 10 times
				for(int i = 0; i < 10; i ++) {
					targetWorld.strikeLightning(targetLocation);
				}
				
				//This kills the target
				target.setHealth(0.0);
				
			} else {
				//This is send if they do not give any input for name
				player.sendMessage(ChatColor.RED + "Input valid player name.");
				return false;
			}
			
		} else {
			//This is send if they are not OPed
			player.sendMessage(ChatColor.RED + "You must be server operator to use this command.");
			return false;
		}
		
		return false;
	}

}
