package me.Prem.DTC.config;

import org.bukkit.Location;

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
	
	public boolean setScheduler() {return plugin.getConfig().getBoolean("Scheduler");}
	
	public int getHourA() 
	{
		if (plugin.getConfig().getInt("Hour A") < 0 || plugin.getConfig().getInt("Hour A") > 24)
		{
			return -1;
		}
		return plugin.getConfig().getInt("Hour A");
	
	}
	
	public int getMinA() 
	{
		if (plugin.getConfig().getInt("Minute A") < 0 || plugin.getConfig().getInt("Minute A") > 24)
		{
			return -1;
		}
		return plugin.getConfig().getInt("Minute A");
	
	}
	
	public int getHourB() 
	{
		if (plugin.getConfig().getInt("Hour B") < 0 || plugin.getConfig().getInt("Hour B") > 24)
		{
			return -1;
		}
		return plugin.getConfig().getInt("Hour B");
	
	}
	
	public int getMinB() 
	{
		if (plugin.getConfig().getInt("Minute B") < 0 || plugin.getConfig().getInt("Minute B") > 24)
		{
			return -1;
		}
		return plugin.getConfig().getInt("Minute B");
	
	}
	
	
	public String getReward1() 
	{
		if (plugin.getConfig().getString("Reward 1") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 1").toUpperCase();
	}
	
	public String getReward2() 
	{
		if (plugin.getConfig().getString("Reward 2") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 2").toUpperCase();
	}
	public String getReward3() 
	{
		if (plugin.getConfig().getString("Reward 3") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 3").toUpperCase();
	}
	public String getReward4() 
	{
		if (plugin.getConfig().getString("Reward 4") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 4").toUpperCase();
	}
	public String getReward5() 
	{
		if (plugin.getConfig().getString("Reward 5") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 5").toUpperCase();
	}
	public String getReward6() 
	{
		if (plugin.getConfig().getString("Reward 6") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 6").toUpperCase();
	}
	public String getReward7() 
	{
		if (plugin.getConfig().getString("Reward 7") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 7").toUpperCase();
	}
	public String getReward8() 
	{
		if (plugin.getConfig().getString("Reward 8") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 8").toUpperCase();
	}
	public String getReward9() 
	{
		if (plugin.getConfig().getString("Reward 9") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 9").toUpperCase();
	}
	public String getReward10() 
	{
		if (plugin.getConfig().getString("Reward 10") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 10").toUpperCase();
	}
	
	public String getReward11() 
	{
		if (plugin.getConfig().getString("Reward 11") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 11").toUpperCase();
	}
	public String getReward12() 
	{
		if (plugin.getConfig().getString("Reward 12") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 12").toUpperCase();
	}
	public String getReward13() 
	{
		if (plugin.getConfig().getString("Reward 13") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 13").toUpperCase();
	}
	public String getReward14() 
	{
		if (plugin.getConfig().getString("Reward 14") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 14").toUpperCase();
	}
	public String getReward15() 
	{
		if (plugin.getConfig().getString("Reward 15") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 15").toUpperCase();
	}
	public String getReward16() 
	{
		if (plugin.getConfig().getString("Reward 16") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 16").toUpperCase();
	}
	public String getReward17() 
	{
		if (plugin.getConfig().getString("Reward 17") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 17").toUpperCase();
	}
	public String getReward18() 
	{
		if (plugin.getConfig().getString("Reward 18") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 18").toUpperCase();
	}
	public String getReward19() 
	{
		if (plugin.getConfig().getString("Reward 19") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 19").toUpperCase();
	}
	
	public String getReward20() 
	{
		if (plugin.getConfig().getString("Reward 20") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 20").toUpperCase();
	}
	public String getReward21() 
	{
		if (plugin.getConfig().getString("Reward 21") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 21").toUpperCase();
	}
	public String getReward22() 
	{
		if (plugin.getConfig().getString("Reward 22") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 22").toUpperCase();
	}
	public String getReward23() 
	{
		if (plugin.getConfig().getString("Reward 23") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 23").toUpperCase();
	}
	public String getReward24() 
	{
		if (plugin.getConfig().getString("Reward 24") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 24").toUpperCase();
	}
	public String getReward25() 
	{
		if (plugin.getConfig().getString("Reward 25") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 25").toUpperCase();
	}
	public String getReward26() 
	{
		if (plugin.getConfig().getString("Reward 26") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 26").toUpperCase();
	}
	public String getReward27() 
	{
		if (plugin.getConfig().getString("Reward 27") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 27").toUpperCase();
	}
	public String getReward28() 
	{
		if (plugin.getConfig().getString("Reward 28") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 28").toUpperCase();
	}
	
	public String getReward29() 
	{
		if (plugin.getConfig().getString("Reward 29") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 29").toUpperCase();
	}
	public String getReward30() 
	{
		if (plugin.getConfig().getString("Reward 30") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 30").toUpperCase();
	}
	public String getReward31() 
	{
		if (plugin.getConfig().getString("Reward 31") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 31").toUpperCase();
	}
	public String getReward32() 
	{
		if (plugin.getConfig().getString("Reward 32") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 32").toUpperCase();
	}
	public String getReward33() 
	{
		if (plugin.getConfig().getString("Reward 33") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 33").toUpperCase();
	}
	public String getReward34() 
	{
		if (plugin.getConfig().getString("Reward 34") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 34").toUpperCase();
	}
	public String getReward35() 
	{
		if (plugin.getConfig().getString("Reward 35") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 35").toUpperCase();
	}
	public String getReward36() 
	{
		if (plugin.getConfig().getString("Reward 36") == null) return "PAPER";
		return plugin.getConfig().getString("Reward 36").toUpperCase();
	}




	
	public int getAmount1() {return plugin.getConfig().getInt("Amount 1");}
	public int getAmount2() {return plugin.getConfig().getInt("Amount 2");}
	public int getAmount3() {return plugin.getConfig().getInt("Amount 3");}
	public int getAmount4() {return plugin.getConfig().getInt("Amount 4");}
	public int getAmount5() {return plugin.getConfig().getInt("Amount 5");}
	public int getAmount6() {return plugin.getConfig().getInt("Amount 6");}
	public int getAmount7() {return plugin.getConfig().getInt("Amount 7");}
	public int getAmount8() {return plugin.getConfig().getInt("Amount 8");}
	public int getAmount9() {return plugin.getConfig().getInt("Amount 9");}
	public int getAmount10() {return plugin.getConfig().getInt("Amount 10");}
	public int getAmount11() {return plugin.getConfig().getInt("Amount 11");}
	public int getAmount12() {return plugin.getConfig().getInt("Amount 12");}
	public int getAmount13() {return plugin.getConfig().getInt("Amount 13");}
	public int getAmount14() {return plugin.getConfig().getInt("Amount 14");}
	public int getAmount15() {return plugin.getConfig().getInt("Amount 15");}
	public int getAmount16() {return plugin.getConfig().getInt("Amount 16");}
	public int getAmount17() {return plugin.getConfig().getInt("Amount 17");}
	public int getAmount18() {return plugin.getConfig().getInt("Amount 18");}
	public int getAmount19() {return plugin.getConfig().getInt("Amount 19");}
	public int getAmount20() {return plugin.getConfig().getInt("Amount 20");}
	public int getAmount21() {return plugin.getConfig().getInt("Amount 21");}
	public int getAmount22() {return plugin.getConfig().getInt("Amount 22");}
	public int getAmount23() {return plugin.getConfig().getInt("Amount 23");}
	public int getAmount24() {return plugin.getConfig().getInt("Amount 24");}
	public int getAmount25() {return plugin.getConfig().getInt("Amount 25");}
	public int getAmount26() {return plugin.getConfig().getInt("Amount 26");}
	public int getAmount27() {return plugin.getConfig().getInt("Amount 27");}
	public int getAmount28() {return plugin.getConfig().getInt("Amount 28");}
	public int getAmount29() {return plugin.getConfig().getInt("Amount 29");}
	public int getAmount30() {return plugin.getConfig().getInt("Amount 30");}
	public int getAmount31() {return plugin.getConfig().getInt("Amount 31");}
	public int getAmount32() {return plugin.getConfig().getInt("Amount 32");}
	public int getAmount33() {return plugin.getConfig().getInt("Amount 33");}
	public int getAmount34() {return plugin.getConfig().getInt("Amount 34");}
	public int getAmount35() {return plugin.getConfig().getInt("Amount 35");}
	public int getAmount36() {return plugin.getConfig().getInt("Amount 36");}
	
	//setlocation file
	public Location getPlayerSetLocation() {return plugin.data.getConfig().getLocation("PlayerSetLocation");}
	

}
