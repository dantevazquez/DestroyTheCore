package me.Prem.DTC.config;

import me.Prem.DTC.Main;

public class Config {

	private Main plugin;
	
	public Config (Main plugin) {
		this.plugin = plugin;
	}
	
	public int getMaxCoreHealth() {return plugin.getConfig().getInt("MaxCoreHealth");}
	
	public String getCoreMaterial() {return plugin.getConfig().getString("CoreMaterial");}
}
