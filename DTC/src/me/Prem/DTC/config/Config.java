package me.Prem.DTC.config;

import me.Prem.DTC.Main;

public class Config {

	private Main plugin;
	
	public Config (Main plugin) 
	{
		this.plugin = plugin;
	}
	
	public int getMaxCoreHealth() {return plugin.getConfig().getInt("MaxCoreHealth");}
	
	public String getCoreMaterial() {return plugin.getConfig().getString("CoreMaterial");}
	
	public String getCustomCoreId() {return plugin.getConfig().getString("CustomCoreId");}
			
	public String getReward1() {return plugin.getConfig().getString("Reward 1");}
	public String getReward2() {return plugin.getConfig().getString("Reward 2");}
	public String getReward3() {return plugin.getConfig().getString("Reward 3");}
	public String getReward4() {return plugin.getConfig().getString("Reward 4");}
	public String getReward5() {return plugin.getConfig().getString("Reward 5");}
	public String getReward6() {return plugin.getConfig().getString("Reward 6");}
	public String getReward7() {return plugin.getConfig().getString("Reward 7");}
	public String getReward8() {return plugin.getConfig().getString("Reward 8");}
	public String getReward9() {return plugin.getConfig().getString("Reward 9");}
	
	public int getAmount1() {return plugin.getConfig().getInt("Amount 1");}
	public int getAmount2() {return plugin.getConfig().getInt("Amount 2");}
	public int getAmount3() {return plugin.getConfig().getInt("Amount 3");}
	public int getAmount4() {return plugin.getConfig().getInt("Amount 4");}
	public int getAmount5() {return plugin.getConfig().getInt("Amount 5");}
	public int getAmount6() {return plugin.getConfig().getInt("Amount 6");}
	public int getAmount7() {return plugin.getConfig().getInt("Amount 7");}
	public int getAmount8() {return plugin.getConfig().getInt("Amount 8");}
	public int getAmount9() {return plugin.getConfig().getInt("Amount 9");}

}
