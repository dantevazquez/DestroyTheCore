package me.Prem.DTC.tasks;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import me.Prem.DTC.Main;

public class Bar 
{
	private int taskID = -1;
	private final Main plugin;
	private BossBar bar;
	
	public Bar(Main plugin)
	{
		this.plugin = plugin;
	}
	
	public void addPlayer(Player player) 
	{
		bar.addPlayer(player);
	}
	
	public BossBar getBar()
	{
		return bar;
	}
	
	public void createBar()
	{
		bar=Bukkit.createBossBar("DTC Progress", BarColor.BLUE, BarStyle.SOLID);
		bar.setVisible(true);
	}
	
	
}
