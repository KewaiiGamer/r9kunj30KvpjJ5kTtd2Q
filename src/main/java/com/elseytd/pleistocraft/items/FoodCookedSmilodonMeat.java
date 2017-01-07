package com.elseytd.pleistocraft.items;

import com.elseytd.pleistocraft.Main;

import net.minecraft.item.ItemFood;

public class FoodCookedSmilodonMeat extends ItemFood {

	public FoodCookedSmilodonMeat(int amount, boolean isWolfFood, String name) {
		super(amount, isWolfFood);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Main.PleistoCraft);
	}

}
