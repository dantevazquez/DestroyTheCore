package me.Prem.DTC.manager;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Prem.DTC.Main;

public class GameManager {
	
	private final Main plugin;
	public GameState gameState = GameState.INACTIVE;
	
	private final CoreManager coreManager;
	private final PlayerManager playerManager;
	
	public GameManager(Main plugin)
	{
		this.plugin = plugin;
		
		this.coreManager = new CoreManager (this);
		this.playerManager = new PlayerManager(this);
	}
	
	public void setGameState(GameState gameState)
	{
		//check if game is already active
		if (this.gameState == GameState.ACTIVE && gameState == GameState.STARTING) return;
		
		this.gameState= gameState;
		switch(gameState)
		{
			case INACTIVE:
				//DO NOTHING?
				break;
				
			case CREATE:
				
				break;
				
			case SETLOOT:
				break;
				
			case DELETE:
				break;
				
			case ACTIVE:
				//while game is active do stuff
				break;
			
			case STARTING:
				//do stuff to start game
				break;
				
			case WON:
				//announce the winner
				//give rewards using playerManager
				break;
		}
	}
	
	public void cleanup()
	{
		
	}
	
	public CoreManager getBlockManager()
	{
		return coreManager;
	}
	
	public PlayerManager getPlayerManager()
	{
		return playerManager;
	}

}
