package com.elseytd.pleistocraft.items;

import com.elseytd.pleistocraft.Main;
import net.minecraft.item.ItemFood;

public class FoodRawSmilodonMeat extends ItemFood {

	public FoodRawSmilodonMeat(int amount, boolean isWolfFood,String name) {
		super(amount, isWolfFood);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Main.PleistoCraft);
	}
}
