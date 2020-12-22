package me.Prem.DTC.listeners;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.Prem.DTC.manager.GameManager;
import me.Prem.DTC.manager.GameState;

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
		if (gameManager.gameStarted()) 
		{
			Player player = event.getPlayer();
			Location loc = event.getBlock().getLocation();
			Location coreLoc= gameManager.getCoreLocation();
			boolean removeScoreboard=false;
			
			if (loc.getBlockX() == coreLoc.getBlockX() && loc.getBlockY() == coreLoc.getBlockY()
					&& loc.getBlockZ() == coreLoc.getBlockZ() && gameManager.isWon() == false)
			{
				gameManager.getPlayerManager().addPointToPlayer(player.getUniqueId());
				player.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 1f, 1f);
				
				
				if (gameManager.getPlayerManager().getPlayerPoints(player.getUniqueId()) >= gameManager.getConfigClass().getMaxCoreHealth())
				{
					player.playSound(loc, Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 1f, 1f);
					gameManager.setGameState(GameState.WON, player);
					removeScoreboard=true;
				}
				else
				{
					event.setCancelled(true);
			    }	
				
				gameManager.getPlayerManager().displayScore(player, removeScoreboard);
			}
		}
	}
}
