package me.Prem.DTC;

//import java.io.File;
//import java.io.IOException;

//import org.bukkit.configuration.InvalidConfigurationException;
//import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import me.Prem.DTC.Files.DataManager;
import me.Prem.DTC.config.Config;
import me.Prem.DTC.listeners.CoreBreakListener;
import me.Prem.DTC.listeners.CorePlaceListener;
import me.Prem.DTC.listeners.PlayerJoinListener;
import me.Prem.DTC.listeners.PlayerQuitListener;
import me.Prem.DTC.manager.GameManager;
import me.Prem.DTC.tasks.DtcScheduler;

public class Main extends JavaPlugin  
{
	
	private GameManager gameManager;
	private Config config;
	public DataManager data;
    //private File customConfigFile;
    //private FileConfiguration customConfig;
	
	@Override
	public void onEnable() 
	{
		super.onEnable();
		System.out.println("PREM DTC IS RUNNING!");
		
		this.saveDefaultConfig();
		this.config = new Config(this);
		this.data = new DataManager(this);
		
		//createCustomConfig();
		
		this.gameManager = new GameManager(this);
		getServer().getPluginManager().registerEvents(new CoreBreakListener(gameManager), this);
		getServer().getPluginManager().registerEvents(new CorePlaceListener(gameManager), this);
		getServer().getPluginManager().registerEvents(new PlayerJoinListener(gameManager), this);
		getServer().getPluginManager().registerEvents(new PlayerQuitListener(gameManager), this);
		
	
		@SuppressWarnings("unused")
		BukkitTask dtcScheduler = new DtcScheduler (this).runTaskTimer(this, 0L, 120L);
		
		
	}

	@Override
	public void onDisable() 
	{
		super.onDisable();
		gameManager.cleanup();
	}
	
	
	
	public Config getConfigClass() 
	{
		return config;
	}
	
	public GameManager getGameManager()
	{
		return gameManager;
	}
	

}
