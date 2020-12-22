package me.Prem.DTC.Blocks;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.Prem.DTC.utils.Utils;

public class CoreItemStackHead extends ItemStack
{

	private String displayName;
	private boolean isActive = false;
	
	public CoreItemStackHead(String playerName, String displayName) 
	{
		super(Material.PLAYER_HEAD, 1);
		setHeadDesign(playerName);
		this.displayName = displayName;
		setCustomModelId(1);
		setAsEnchanted();
		setNameData();
	
	}
	
	public boolean isActive() 
	{
		return isActive;
	}
	
	public void setActive(boolean value) 
	{
		isActive = value;
	}
	
	private void setCustomModelId(int customModelData) 
	{
		ItemMeta meta  = getItemMeta();
		meta.setCustomModelData(customModelData);
		setItemMeta(meta);
	}
	
	private void setAsEnchanted()
	{
		ItemMeta meta  = getItemMeta();
		meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES,ItemFlag.HIDE_ENCHANTS);
		setItemMeta(meta);
	}
	private void setNameData() 
	{
		List<String> lore = new ArrayList<String>();
		ItemMeta meta  = getItemMeta();
		lore.add(Utils.chat("&dPlace on the ground to begin DTC event!"));
		meta.setLore(lore);
		meta.setDisplayName(displayName);
		setItemMeta(meta);
	}
	
	@SuppressWarnings("deprecation")
	private void setHeadDesign(String playerName)
	{
		String pName= playerName;
		SkullMeta meta = (SkullMeta) getItemMeta();
		meta.setOwner(pName);
		setItemMeta(meta);
	}

}
