package me.Prem.DTC.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.meta.ItemMeta;

import me.Prem.DTC.manager.GameManager;
import me.Prem.DTC.manager.GameState;

public class CorePlaceListener implements Listener{

	private GameManager gameManager;
	
	public CorePlaceListener(GameManager gameManager) { 
		this.gameManager = gameManager;
	}

	//This event listens for the placement of the core
	//This event also starts the DTC event once the core is placed
	@EventHandler
    public void onBlockPlace(BlockPlaceEvent event)
	{
		if (gameManager.isListening()) 
		{
			Player player = event.getPlayer();
			ItemMeta itemMeta = player.getInventory().getItemInMainHand().getItemMeta();
			
			if (itemMeta.getDisplayName().contains("Core") && itemMeta.hasCustomModelData()) 
			{
				gameManager.setCoreLocation(event.getBlock().getLocation());
				player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1f, 1f);
				gameManager.setGameState(GameState.STARTING, player);
			
			}
		}    
    }
}
