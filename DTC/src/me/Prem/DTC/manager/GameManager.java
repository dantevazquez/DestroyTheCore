package me.Prem.DTC.manager;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.Prem.DTC.Main;
import me.Prem.DTC.config.Config;

public class GameManager {
	
	private final Main plugin;
	
	
	private final CoreManager coreManager;
	private final PlayerManager playerManager;
	private Location coreLocation;
	
	private boolean isListening = false;
	
	public GameManager(Main plugin)
	{
		this.plugin = plugin;
		
		this.coreManager = new CoreManager (this);
		this.playerManager = new PlayerManager(this);
	}
	
	public void setGameState(GameState gameState, Player player)
	{
		//check if game is already active
		if (isListening && gameState == GameState.INITIALIZE) return;
		
		switch(gameState)
		{
		case INITIALIZE:
			// give player special core block
			player.getInventory().addItem(coreManager.getCoreItemStack());
			isListening = true;
			break;
			
		case STARTING:
			//do stuff to start game
			
			
			break;	
			
		case INACTIVE:
			// remove any special core blocks in a players inventory,
			//and remove the game world block, stop keeping track of player breaking progress.
			
			break;
			
		case SETLOOT:
			break;
						
		case WON:
			//announce the winner
			//give rewards using playerManager
			break;
				
		default:
			break;
		}
	}
	
	public void cleanup()
	{
		
	}
	
	public void setCoreLocation(Location coreLocation) {
		this.coreLocation = coreLocation;
	}
	
	public Config getConfigClass() {
		return plugin.getConfigClass();
	}
	
	public CoreManager getCoreManager()
	{
		return coreManager;
	}
	
	public PlayerManager getPlayerManager()
	{
		return playerManager;
	}
	
	public void setListening(boolean value) {
		isListening = value;
	}
	
	public boolean isListening() {
		return isListening;
	}

}
