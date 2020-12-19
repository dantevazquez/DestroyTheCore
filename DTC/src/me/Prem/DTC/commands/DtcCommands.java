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
	}
	
	public boolean onCommand (CommandSender sender, Command command, String s, String[] args)
	{
		Player player = (Player) sender;
		if (player.isOp()) {
			if (s.equalsIgnoreCase("dtc start"))
			{
				gameManager.setGameState(GameState.INITIALIZE, player);
				player.sendMessage(Utils.chat("&eStarting Game..."));
				return true;
			}
			else if (s.equalsIgnoreCase("dtc stop"))
			{
				gameManager.setGameState(GameState.INACTIVE, player);
				player.sendMessage(Utils.chat("&eStopping Game..."));
				return true;
			}
			else if (s.equalsIgnoreCase("dtc setloot"))
			{	
				// call function and get return value, if true, tell player it succesfully set the loot.
				return true;
			}
			player.sendMessage(Utils.chat("&cInvalid Command"));	
		}
		return false;
	}

}
