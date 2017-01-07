package com.elseytd.pleistocraft.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.elseytd.pleistocraft.Main;
import com.elseytd.pleistocraft.registries.ItemsRegistry;

public class CreativeTabUtil extends CreativeTabs{
	public CreativeTabUtil(String tabLabel){
		super(tabLabel);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem(){
		return ItemsRegistry.smilodon_populator_skull;
	}

}