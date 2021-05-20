package me.prime.ZeusServer;

import org.bukkit.plugin.java.JavaPlugin;

import me.prime.ZeusServer.commands.Smite;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		new Smite(this);
	}

}
