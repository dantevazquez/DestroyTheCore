package me.Prem.DTC.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
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
	
	public void giveRewards(Player player)
	{
		ItemStack reward[] = {} ;
		reward = new ItemStack[9];
		boolean groundLoot=false;
		
		reward[0]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward1()), gameManager.getConfigClass().getAmount1());
		reward[1]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward2()), gameManager.getConfigClass().getAmount2());
		reward[2]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward3()), gameManager.getConfigClass().getAmount3());
		reward[3]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward4()), gameManager.getConfigClass().getAmount4());
		reward[4]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward5()), gameManager.getConfigClass().getAmount5());
		reward[5]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward6()), gameManager.getConfigClass().getAmount6());
		reward[6]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward7()), gameManager.getConfigClass().getAmount7());
		reward[7]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward8()), gameManager.getConfigClass().getAmount8());
		reward[8]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward9()), gameManager.getConfigClass().getAmount9());
		
		

		for (int i=0; i<9; i++)
		{
			if (player.getInventory().firstEmpty() == -1)
			{
				//If players inventory is full, drop it to them
				Location loc = player.getLocation();
				World world = player.getWorld();
				world.dropItemNaturally(loc,reward[i]);
				groundLoot= true;
				
			}
			else
			{	
				//give loot player via inventory placement
				player.getInventory().addItem(reward[i]);
			}
		}
		
		player.sendMessage("You have received loot for winning the event!");
		
		if (groundLoot == true)
		{
			//if loot was dropped..
			player.sendMessage("some loot was dropped on the ground");
		}
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
		
		score = new Score[Bukkit.getOnlinePlayers().size()];
		
		int i = 0;
		
		for(Player online : Bukkit.getOnlinePlayers())
		{
			//add a player to scoreboard
			score[i] = obj.getScore(online);
			//score[i] = obj.getScore(online.getDisplayName());
			
			if (getPlayerPoints(online.getUniqueId()) == null)
			{
				//If player doesnt have points sets score to 0 to avoid null error
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
	

	
}
