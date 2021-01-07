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
	
	//This event listens for when a player breaks the core
	//It also checks if a player has reached the max core health
	//It also displays the score board every time someone gains points
	@EventHandler
	private void onBlockBreak(BlockBreakEvent event)
	{
		
		if (gameManager.gameStarted()== true) 
		{
			Player player = event.getPlayer();
			Location loc = event.getBlock().getLocation();
			Location coreLoc= gameManager.getCoreLocation();
			boolean removeScoreboard=false;
			
			if (loc.getBlockX() == coreLoc.getBlockX() && loc.getBlockY() == coreLoc.getBlockY()&& loc.getBlockZ() == coreLoc.getBlockZ()) 
			{
				//core was broken, player who broke it gets a point
				gameManager.getPlayerManager().addPointToPlayer(player.getUniqueId());
				player.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 1f, 1f);
				
				
				if (gameManager.getPlayerManager().getPlayerPoints(player.getUniqueId()) >= gameManager.getConfigClass().getMaxCoreHealth())
				{
					//A player has won the event
					player.playSound(loc, Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 1f, 1f);
					gameManager.setGameState(GameState.WON, player);
					removeScoreboard=true;
				}
				else
				{
					//game is not finished re-place the core
					event.setCancelled(true);
			    }	
				
				//display score board
				gameManager.getPlayerManager().displayScore(player, removeScoreboard);
			}

			
		}
	}
}
