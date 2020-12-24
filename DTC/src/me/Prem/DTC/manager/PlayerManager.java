package me.Prem.DTC.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.Prem.DTC.utils.Utils;

public class PlayerManager 
{
	private GameManager gameManager;
	
	
	int  points;
	private Map<UUID, Integer> playerPoints = new HashMap<UUID, Integer>();
	
	public PlayerManager(GameManager gameManager)
	{
		this.gameManager = gameManager;
	}
	
	
	public void addPointToPlayer(UUID playerID)
	{
		if (playerPoints.containsKey(playerID))
		{
			playerPoints.put(playerID, playerPoints.get(playerID) + 1);
		}
		else
		{
			playerPoints.put(playerID, 1);
		}
	}
	
	public Integer getPlayerPoints(UUID playerID)
	{
		return playerPoints.get(playerID);
	}
	
	
	public void resetPlayerPoints()
	{
		playerPoints.clear();
		
	}
	
	@SuppressWarnings("deprecation")
	public void displayScore(Player player, boolean removeScoreboard)
	{
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective obj = board.registerNewObjective("DtcScoreboard", "dummy", Utils.chat("&6DTC LEADERBOARD"));
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		Score score[]= null;
		int setScoreTo = 0;
		
		Score warpDisplay = obj.getScore(Utils.chat("&aEvent is active @ &3/warp DTC"));
		warpDisplay.setScore(gameManager.getConfigClass().getMaxCoreHealth());
		score = new Score[Bukkit.getOnlinePlayers().size()];
		
		int i = 0;
		
		for(Player online : Bukkit.getOnlinePlayers())
		{
			//add a player to score board
			score[i] = obj.getScore(online);
			//score[i] = obj.getScore(online.getDisplayName());
			
			if (getPlayerPoints(online.getUniqueId()) == null)
			{
				//If player doesn't have points sets score to 0 to avoid null error
				setScoreTo = 0;
			}
			else
			{
				//gets the current players points
				setScoreTo = getPlayerPoints(online.getUniqueId());
			}
			
			score[i].setScore(setScoreTo); //sets score of current player
			
			i++; 
		}	
			
		for(Player online : Bukkit.getOnlinePlayers())
		{
			//display score board to every player online
			online.setScoreboard(board);
		}
		
		if (removeScoreboard == true)
		{
			for(Player online : Bukkit.getOnlinePlayers())
			{
				//remove score board from online player's screens
				online.setScoreboard(manager.getNewScoreboard());
			}
		}
	}
	
	public void removeScoreboard(Player player) //removes scoreboard for one player
	{
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		player.setScoreboard(manager.getNewScoreboard());
	}
	

	
}
