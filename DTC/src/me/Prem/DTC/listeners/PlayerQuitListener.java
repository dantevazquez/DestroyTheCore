package me.Prem.DTC.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerQuitEvent;

import me.Prem.DTC.manager.GameManager;


public class PlayerQuitListener implements Listener
{
	private GameManager gameManager;
	//when a player joins, display score board if DTC event is running.
	public PlayerQuitListener(GameManager gameManager)
	{
		this.gameManager= gameManager;
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		if (gameManager.gameStarted())
		{  
			Player player = event.getPlayer();
			gameManager.getPlayerManager().removeScoreboard(player);
		}
	}
}