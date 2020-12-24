package me.Prem.DTC.tasks;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.Prem.DTC.Main;
import me.Prem.DTC.manager.GameManager;
import me.Prem.DTC.manager.GameState;

public class DtcScheduler  extends BukkitRunnable
{
	Main plugin;
	private GameManager gameManager;
	
	public DtcScheduler(Main plugin)
	{
		this.plugin = plugin;
		this.gameManager= plugin.getGameManager();
	}
	
	@Override
	public void run ()
	{
		
		if (plugin.getConfigClass().setScheduler() == false) return;
		
		Calendar cal =Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String time = sdf.format(cal.getTime());
		String[] times = time.split(":");
		 
		int hour = Integer.parseInt(times[0]);
		int minute = Integer.parseInt(times[1]);
		
		
		if ((hour == plugin.getConfigClass().getHourA() && minute == plugin.getConfigClass().getMinA()) ||
				(hour == plugin.getConfigClass().getHourB() && minute == plugin.getConfigClass().getMinB())) 
		{
			Location loc = gameManager.getConfigClass().getPlayerSetLocation();
			gameManager.setCoreLocation(loc);
			Player player = null;
			gameManager.setGameState(GameState.STARTING, player);
		}
		

		
	}


}
