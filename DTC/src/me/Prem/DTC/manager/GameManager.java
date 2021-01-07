package me.Prem.DTC.manager;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.Prem.DTC.Main;
import me.Prem.DTC.commands.DtcCommands;
import me.Prem.DTC.config.Config;

public class GameManager {
	
	private final Main plugin;
	
  	
	private final CoreManager coreManager;
	private final PlayerManager playerManager;
	private final ChatManager chatManager;
	private final RewardManager rewardManager;
	private final ScheduleManager scheduleManager;
	
	private Location coreLocation;
	private Location playerSetLocation;
	
	private boolean isListening = false; //Program is or is not listening for admin to place core 
	private boolean isWon = false; //indicates if someone has won the DTC event
	private boolean gameStarted=false; //whether game is active or inactive
	
	
	public GameManager(Main plugin)
	{
		this.plugin = plugin;
		
		this.coreManager = new CoreManager (this);
		this.playerManager = new PlayerManager(this);
		this.chatManager = new ChatManager (this);
		this.rewardManager = new RewardManager(this);
		this.scheduleManager = new ScheduleManager(this);
		new DtcCommands(this);
	}
	
	public void setGameState(GameState gameState, Player player)
	{
		//check if game is already active
		if (isListening && gameState == GameState.INITIALIZE) return;
		
		if (gameStarted && gameState == GameState.STARTING) return;
		
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
			chatManager.displayStart();
			playerManager.displayScore(player, false); 
			gameStarted=true;
			isListening = false;
			
			break;	
			
		case INACTIVE:
			chatManager.displayStop();
			playerManager.resetPlayerPoints(); //Stops keeping track of player event points
			playerManager.displayScore(player, true); //Removes score board from screen
			gameStarted=false; //Game is not active
			isListening=false; //Game is not initialized
			break;
			
						
		case WON:
			//announce the winner
			//give rewards using playerManager
			chatManager.displayWinner(player);
			rewardManager.giveRewards(player);
			playerManager.resetPlayerPoints(); //Stops keeping track of player event points
			playerManager.displayScore(player, true); //Removes score board from screen
			
			isWon= true;
			isListening=false;
			gameStarted=false; //game is inactive
			
			break;
			
		case SETLOCATION:
			playerSetLocation= player.getLocation();
			plugin.data.getConfig().set("PlayerSetLocation", playerSetLocation);
			plugin.data.saveConfig();
			
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
	
	public Location getPlayerSetLocation()
	{
		return playerSetLocation;
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
	
	public ChatManager getChatManager()
	{
		return chatManager;
	}
	
	public ScheduleManager getScheduleManager()
	{
		return scheduleManager;
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
