package me.Prem.DTC.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.Prem.DTC.manager.GameManager;

public class CoreBreakListener implements Listener
{
	private GameManager gameManager;
	
	public CoreBreakListener(GameManager gameManager)
	{
		this.gameManager = gameManager;
	}
	
	@EventHandler
	private void onBlockBreak(BlockBreakEvent event)
	{
		//Handle when a player breaks the core
	}
}
