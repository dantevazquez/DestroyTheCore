package me.Prem.DTC.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.bukkit.BukkitPlayer;
import com.sk89q.worldedit.internal.annotation.Selection;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.world.World;

import me.Prem.DTC.Main;
import me.Prem.DTC.manager.GameManager;
import me.Prem.DTC.manager.GameState;

public class DtcCommands implements CommandExecutor
{
	private GameManager gameManager;
	
	public DtcCommands (GameManager gameManager)
	{
		this.gameManager = gameManager;
	}
	
	public boolean onCommand (CommandSender sender, Command command, String s, String[] args)
	{
		if (s.equalsIgnoreCase("dtc start"))
		{
			gameManager.setGameState(GameState.STARTING);
			return true;
		}
		else if (s.equalsIgnoreCase("dtc stop"))
		{
			gameManager.setGameState(GameState.INACTIVE);
			return true;
		}
		else if (s.equalsIgnoreCase("dtc create"))
		{
			gameManager.setGameState(GameState.CREATE);
		
		}
		else if (s.equalsIgnoreCase("dtc delete"))
		{
			gameManager.setGameState(GameState.DELETE);
			return true;
		}
		else if (s.equalsIgnoreCase("dtc setloot"))
		{
			gameManager.setGameState(GameState.SETLOOT);
			return true;
		}
		return false;
	}

}
