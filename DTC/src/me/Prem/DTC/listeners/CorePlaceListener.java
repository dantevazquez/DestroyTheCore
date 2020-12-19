package me.Prem.DTC.listeners;

import org.bukkit.Material;
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

	@EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
		if (gameManager.isListening()) {
			Player player = event.getPlayer();
			ItemMeta itemMeta = player.getInventory().getItemInMainHand().getItemMeta();
			
			if (player.getInventory().getItemInMainHand().getType().equals	// if the block equals that specified in the config.
					(Material.getMaterial(gameManager.getConfigClass().getCoreMaterial())) && itemMeta.hasCustomModelData()) {
				gameManager.setCoreLocation(event.getBlock().getLocation());
				gameManager.setGameState(GameState.STARTING, player);
			}
		}    
    }
}
