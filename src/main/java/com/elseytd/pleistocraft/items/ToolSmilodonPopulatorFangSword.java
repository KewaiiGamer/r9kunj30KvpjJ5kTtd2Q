package com.elseytd.pleistocraft.items;

import com.elseytd.pleistocraft.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ToolSmilodonPopulatorFangSword extends ItemSword {
		
	private static float AttackDamage = 3.0F;	//0.0=4 hearts - wood, 4.0=7 hearts - diamond
	private static int HarvestLevel = 0; 		//0 - wood, 3 - diamond
	private static int MaxUsage = 131;			//1516 - diamond
	private static int Enchantablility = 11;	//22 - gold
	private static float Efficiency = 5.0F;	//Mining speed 12 - gold, 8 - diamond
	private static String Name = "Smilodon Fang Sword";
	
	private static ToolMaterial Material = EnumHelper.addToolMaterial(Name, HarvestLevel, MaxUsage, Efficiency, AttackDamage, Enchantablility);
	private static String name;
	
	public ToolSmilodonPopulatorFangSword(String unlocalizedName) {
		super(Material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.PleistoCraft);
	}

	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		//tooltip.add("If you want something here on any item, let me know.");
    }
}
