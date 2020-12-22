package me.Prem.DTC.manager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import me.Prem.DTC.Main;
import me.Prem.DTC.commands.DtcCommands;
import me.Prem.DTC.config.Config;

public class GameManager {
	
	private final Main plugin;
	
  	
	private final CoreManager coreManager;
	private final PlayerManager playerManager;
	private Location coreLocation;
	
	private boolean isListening = false; //Program is or is not listening for admin to place core 
	private boolean isWon = false; //indicates if someone has won the DTC event
	private boolean gameStarted=false; //whether game is active or inactive
	
	public GameManager(Main plugin)
	{
		this.plugin = plugin;
		
		this.coreManager = new CoreManager (this);
		this.playerManager = new PlayerManager(this);
		new DtcCommands(this);
	}
	
	public void setGameState(GameState gameState, Player player)
	{
		//check if game is already active
		if (isListening && gameState == GameState.INITIALIZE) return;
		
		switch(gameState)
		{
		case INITIALIZE:
			// give player special core block
			isWon=false;
			playerManager.resetPlayerPoints();
			
			String matCompare = getConfigClass().getCoreMaterial();
			if (matCompare.equalsIgnoreCase("custom_core"))
			{
				//give admin custom core
				player.getInventory().addItem(coreManager.getCoreItemStackHead());
			}
			else
			{
				//give admmin normal minecraft core
				player.getInventory().addItem(coreManager.getCoreItemStack());
			}
			
			isListening = true; //program is listening for core placement
			break;
			
		case STARTING:
			//do stuff to start game
			Bukkit.broadcastMessage("DTC EVENT HAS STARTED");
			playerManager.displayScore(player, false); 
			gameStarted=true;
			isListening = false;
			
			break;	
			
		case INACTIVE:
			Bukkit.broadcastMessage("DTC EVENT HAS BEEN HALTED");
			playerManager.resetPlayerPoints(); //Stops keeping track of player event points
			playerManager.displayScore(player, true); //Removes score board from screen
			gameStarted=false; //Game is not active
			isListening=false; //Game is not initialized
			break;
			
						
		case WON:
			//announce the winner
			//give rewards using playerManager
			player.sendMessage("You won!");
			Bukkit.broadcastMessage(player.getDisplayName() + " has won the DTC event!");
			playerManager.giveRewards(player);
			isWon= true;
			isListening=false;
			gameStarted=false; //game is inactive
			
			break;
				
		default:
			break;
		}
	}
	
	public void cleanup()
	{
		
	}
	
	public boolean gameStarted()
	{
		return gameStarted;
	}
	
	public boolean isWon()
	{
		return isWon; //return whether or not someone won the dtc event
	}
	
	public Location getCoreLocation()
	{
		return coreLocation;
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
	
	public Main getMain()
	{
		return plugin;
	}
	public void setListening(boolean value) {
		isListening = value;
	}
	
	public boolean isListening() {
		return isListening; //return if program is listening for admin to place core
	}
	
	

}
