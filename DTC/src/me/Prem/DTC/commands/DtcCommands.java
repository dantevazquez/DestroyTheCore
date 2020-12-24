package me.Prem.DTC.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Prem.DTC.manager.GameManager;
import me.Prem.DTC.manager.GameState;
import me.Prem.DTC.utils.Utils;

public class DtcCommands implements CommandExecutor
{
	private GameManager gameManager;
	
	public DtcCommands (GameManager gameManager)
	{
		this.gameManager = gameManager;
		this.gameManager.getMain().getCommand("dtc").setExecutor(this);
	}
	
	
	
	public boolean onCommand (CommandSender sender, Command command, String s, String[] args)
	{
		Player player = (Player) sender;
		
		//Admin Commands
		if (player.isOp()) 
		{
			if (args[0].equalsIgnoreCase("start"))
			{
				if (gameManager.gameStarted() || gameManager.isListening())
				{
					player.sendMessage("A game has already been started!");
					return true;
				}
				//else
				gameManager.setGameState(GameState.INITIALIZE, player);
				player.sendMessage(Utils.chat("&eStarting Game..."));
				return true;
				
			}
			else if (args[0].equalsIgnoreCase("stop"))
			{
				gameManager.setGameState(GameState.INACTIVE, player);
				player.sendMessage(Utils.chat("&eStopping Game..."));
				return true;
			}
			else if (args[0].equalsIgnoreCase("set"))
			{
				if (args[1].equalsIgnoreCase("location"))
				{
					gameManager.setGameState(GameState.SETLOCATION, player);
					player.sendMessage(Utils.chat("&eDTC location set at x:" + player.getLocation().getBlockX() + " y:" + player.getLocation().getBlockY() + " z:" + player.getLocation().getBlockZ()));
					return true;
				}
				
				player.sendMessage(Utils.chat("&eSet what? Ya bot"));
				return true;
				
			}

			player.sendMessage(Utils.chat("&cInvalid Command"));	
		}
		else
		{
			player.sendMessage("You dont have access to this command :(");
			return true;
		}
		
		//Default player commands
		if (args[0].equalsIgnoreCase("schedule"))
		{
			gameManager.getScheduleManager().displaySchedule(player);
		}
		
	
		return false;
	}

}
