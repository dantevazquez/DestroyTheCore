package me.Prem.DTC.manager;



import org.bukkit.Material;

import me.Prem.DTC.Blocks.CoreItemStack;

public class CoreManager 
{
	private int coreHealth;
	private GameManager gameManager;
	private CoreItemStack coreBlockItemStack;
	
	public CoreManager (GameManager gameManager)
	{
		this.gameManager = gameManager;
		
	}
	
	public CoreItemStack getCoreItemStack() {
		Material material = Material.getMaterial(gameManager.getConfigClass().getCoreMaterial());
		return new CoreItemStack(material, "Core");	
	}
	

	
	
	

}
