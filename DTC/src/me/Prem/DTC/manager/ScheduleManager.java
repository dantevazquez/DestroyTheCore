package me.Prem.DTC.manager;

import org.bukkit.entity.Player;

import me.Prem.DTC.utils.Utils;

public class ScheduleManager 
{

	private GameManager gameManager;

	public ScheduleManager (GameManager gameManager)
	{
		this.gameManager = gameManager;
		
	}
	
	public void setSchedule(String[] args)
	{
		
	}
	public void displaySchedule(Player player)
	{
		if (gameManager.getConfigClass().setScheduler()==false)
		{
			player.sendMessage(Utils.chat("&7[&6DTC&7] There are no scheduled events"));
			return;
		}
		player.sendMessage(Utils.chat("&7[&6DTC&7] DTC Event everyday at: "));
		
		int hourA = gameManager.getConfigClass().getHourA();
		int minA= gameManager.getConfigClass().getMinA();
		
		int hourB = gameManager.getConfigClass().getHourB();
		int minB= gameManager.getConfigClass().getMinB();
		
		if(hourA != -1 || minA != -1)
		{
			player.sendMessage(Utils.chat("&7[&6DTC&7] " + hourA + ":" + minA));
			
		}
		
		if(hourB != -1 || minB != -1)
		{
			player.sendMessage(Utils.chat("&7[&6DTC&7] " + hourB + ":" + minB));
			
		}
	
	
		
	}
	

	
}
