package me.Prem.DTC.manager;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.Prem.DTC.utils.Utils;

public class RewardManager 
{
	private GameManager gameManager;

	public RewardManager (GameManager gameManager)
	{
		this.gameManager = gameManager;
	}
	
	public void giveRewards(Player player)
	{
		ItemStack reward[] = {} ;
		reward = new ItemStack[36];
		boolean groundLoot=false;
		
		reward[0]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward1()), gameManager.getConfigClass().getAmount1());
		reward[1]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward2()), gameManager.getConfigClass().getAmount2());
		reward[2]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward3()), gameManager.getConfigClass().getAmount3());
		reward[3]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward4()), gameManager.getConfigClass().getAmount4());
		reward[4]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward5()), gameManager.getConfigClass().getAmount5());
		reward[5]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward6()), gameManager.getConfigClass().getAmount6());
		reward[6]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward7()), gameManager.getConfigClass().getAmount7());
		reward[7]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward8()), gameManager.getConfigClass().getAmount8());
		reward[8]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward9()), gameManager.getConfigClass().getAmount9());
		reward[9]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward10()), gameManager.getConfigClass().getAmount10());
		reward[10]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward11()), gameManager.getConfigClass().getAmount11());
		reward[11]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward12()), gameManager.getConfigClass().getAmount12());
		reward[12]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward13()), gameManager.getConfigClass().getAmount13());
		reward[13]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward14()), gameManager.getConfigClass().getAmount14());
		reward[14]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward15()), gameManager.getConfigClass().getAmount15());
		reward[15]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward16()), gameManager.getConfigClass().getAmount16());
		reward[16]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward17()), gameManager.getConfigClass().getAmount17());
		reward[17]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward18()), gameManager.getConfigClass().getAmount18());
		reward[18]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward19()), gameManager.getConfigClass().getAmount19());
		reward[19]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward20()), gameManager.getConfigClass().getAmount20());
		reward[20]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward21()), gameManager.getConfigClass().getAmount21());
		reward[21]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward22()), gameManager.getConfigClass().getAmount22());
		reward[22]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward23()), gameManager.getConfigClass().getAmount23());
		reward[23]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward24()), gameManager.getConfigClass().getAmount24());
		reward[24]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward25()), gameManager.getConfigClass().getAmount25());
		reward[25]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward26()), gameManager.getConfigClass().getAmount26());
		reward[26]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward27()), gameManager.getConfigClass().getAmount27());
		reward[27]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward28()), gameManager.getConfigClass().getAmount28());
		reward[28]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward29()), gameManager.getConfigClass().getAmount29());
		reward[29]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward30()), gameManager.getConfigClass().getAmount30());
		reward[30]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward31()), gameManager.getConfigClass().getAmount31());
		reward[31]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward32()), gameManager.getConfigClass().getAmount32());
		reward[32]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward33()), gameManager.getConfigClass().getAmount33());
		reward[33]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward34()), gameManager.getConfigClass().getAmount34());
		reward[34]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward35()), gameManager.getConfigClass().getAmount35());
		reward[35]= new ItemStack(Material.getMaterial(gameManager.getConfigClass().getReward36()), gameManager.getConfigClass().getAmount36());
		

		for (int i=0; i<36; i++)
		{
			if (player.getInventory().firstEmpty() == -1)
			{
				//If players inventory is full, drop it to them
				Location loc = player.getLocation();
				World world = player.getWorld();
				world.dropItemNaturally(loc,reward[i]);
				groundLoot= true;
				
			}
			else
			{	
				//give loot player via inventory placement
				player.getInventory().addItem(reward[i]);
			}
		}
		
		player.sendMessage(Utils.chat("&7[&6DTC&7] &eYou have received some loot for winning the event!"));
		
		
		if (groundLoot == true)
		{
			//if loot was dropped..
			player.sendMessage("some loot was dropped on the ground");
		}
	}
}
