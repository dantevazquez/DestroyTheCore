package me.Prem.DTC;

import org.bukkit.plugin.java.JavaPlugin;

import me.Prem.DTC.config.Config;
import me.Prem.DTC.listeners.CoreBreakListener;
import me.Prem.DTC.manager.GameManager;

public class Main extends JavaPlugin  
{
	
	private GameManager gameManager;
	private Config config;
	
	@Override
	public void onEnable() 
	{
		//super.onEnable();
		
		this.config = new Config(this);
		this.gameManager = new GameManager(this);
		getServer().getPluginManager().registerEvents(new CoreBreakListener(gameManager), this);
		
		
	}

	@Override
	public void onDisable() 
	{
		super.onDisable();
		
		gameManager.cleanup();
	}
	
	public Config getConfigClass() {
		return config;
	}
}
