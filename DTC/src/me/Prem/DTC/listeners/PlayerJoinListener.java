package me.Prem.DTC.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.Prem.DTC.manager.GameManager;


public class PlayerJoinListener implements Listener
{
	private GameManager gameManager;
	//when a player joins, display scoreboard if dtc event is running.
	public PlayerJoinListener(GameManager gameManager)
	{
		this.gameManager= gameManager;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		if (gameManager.gameStarted())
		{  
			Player player = event.getPlayer();
			gameManager.getPlayerManager().displayScore(player, false);
		}
	}
}
