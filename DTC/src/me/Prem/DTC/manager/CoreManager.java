package me.Prem.DTC.manager;

import org.bukkit.Material;


import me.Prem.DTC.Blocks.CoreItemStack;
import me.Prem.DTC.Blocks.CoreItemStackHead;

public class CoreManager 
{
	private int coreHealth;
	private GameManager gameManager;
	private CoreItemStack coreBlockItemStack;
	
	public CoreManager (GameManager gameManager)
	{
		this.gameManager = gameManager;
		
	}
	
	public CoreItemStack getCoreItemStack() 
	{
		Material material = Material.getMaterial(gameManager.getConfigClass().getCoreMaterial());
		//if material = customcore return new CoreItemStack(customitem, "core"
	
		return new CoreItemStack(material, "Core");	
	}
	
	public CoreItemStackHead getCoreItemStackHead()
	{
		String customCoreId= gameManager.getConfigClass().getCustomCoreId();
		return new CoreItemStackHead(customCoreId, "Core");
	}
	
	//THE FOLLOWING IS TEST CODE THAT IS COMMENTED
	/*@SuppressWarnings("deprecation")
	public ItemStack getCustomCore (String player)
	{
		Material type = Material.PLAYER_HEAD;
		ItemStack item = new ItemStack (type, 1);
		
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		
		meta.setOwner(player);
		
		item.setItemMeta(meta);
		
		return item;
	}*/

	
	
	

}
