package me.Prem.DTC;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import me.Prem.DTC.listeners.CoreBreakListener;
import me.Prem.DTC.manager.GameManager;

public class Main extends JavaPlugin  
{
	
	private GameManager gameManager;
	
	@Override
	public void onEnable() 
	{
		super.onEnable();
		
		this.gameManager = new GameManager(this);
		
		getServer().getPluginManager().registerEvents(new CoreBreakListener(gameManager), this);
		
		
	}

	@Override
	public void onDisable() 
	{
		super.onDisable();
		
		gameManager.cleanup();
	}

	
	public static WorldEditPlugin getWorldEdit()
	{
		return (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
	}


}
