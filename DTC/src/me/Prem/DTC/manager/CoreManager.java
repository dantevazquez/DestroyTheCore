package me.Prem.DTC.manager;

import org.bukkit.Material;


import me.Prem.DTC.Blocks.CoreItemStack;
import me.Prem.DTC.Blocks.CoreItemStackHead;

public class CoreManager 
{

	private GameManager gameManager;

	public CoreManager (GameManager gameManager)
	{
		this.gameManager = gameManager;
		
	}
	
	public CoreItemStack getCoreItemStack() 
	{
		Material material = Material.getMaterial(gameManager.getConfigClass().getCoreMaterial());
		return new CoreItemStack(material, "Core");	
	}
	
	public CoreItemStackHead getCoreItemStackHead()
	{
		String customCoreId= gameManager.getConfigClass().getCustomCoreId();
		return new CoreItemStackHead(customCoreId, "Core");
	}
	
}
