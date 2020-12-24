package me.Prem.DTC.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.Prem.DTC.utils.Utils;

public class ChatManager 
{
	@SuppressWarnings("unused")
	private GameManager gameManager;

	public ChatManager (GameManager gameManager)
	{
		this.gameManager = gameManager;
	}
	
	public void displayStart()
	{
		Bukkit.broadcastMessage(Utils.chat("&7[&6DTC&7] &cDTC EVENT HAS STARTED"));
		Bukkit.broadcastMessage(Utils.chat("&7[&6DTC&7] &eDo &a/warp DTC &eto particapate"));
	}
	
	public void displayStop()
	{
		Bukkit.broadcastMessage(Utils.chat("&7[&6DTC&7] &cDTC EVENT HAS BEEN HALTED"));
	}
	
	
	public void displayWinner(Player player)
	{
		player.sendMessage(Utils.chat("&7[&6DTC&7] &eCongrats! You have won the dtc event!"));
		Bukkit.broadcastMessage(Utils.chat("&7[&6DTC&7] " + player.getDisplayName().toUpperCase() + "&c HAS WON THE EVENT AND WAS REWARDED SOME GOODIES"));
	}
	
	
	
	
	
	
}
