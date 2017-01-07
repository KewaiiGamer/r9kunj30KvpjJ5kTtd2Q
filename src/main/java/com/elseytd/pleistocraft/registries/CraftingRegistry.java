package com.elseytd.pleistocraft.registries;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CraftingRegistry {
	
	public static final void init() {

		//Furnace-
		GameRegistry.addSmelting(ItemsRegistry.raw_smilodon_meat, new ItemStack(ItemsRegistry.cooked_smilodon_meat), 1);
		
		//Crafting table-
			//	-Shaped
		GameRegistry.addRecipe(new ItemStack(ItemsRegistry.smilodon_populator_fang_sword), new Object[]{" 1 ", " 2 ", " 3 ", '1', ItemsRegistry.smilodon_populator_fang, '2', Items.string,'3', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.saddle), new Object[]{"222", "2 2", "3 3", '2', Items.leather, '3', Items.iron_ingot});
        GameRegistry.addRecipe(new ItemStack(BlocksRegistry.asphalt_block), new Object[]{"11 ", "11 ", "   ", '1', ItemsRegistry.asphalt_crumbs});
        GameRegistry.addRecipe(new ItemStack(BlocksRegistry.asphalt_block), new Object[]{" 11", " 11", "   ", '1', ItemsRegistry.asphalt_crumbs});
        GameRegistry.addRecipe(new ItemStack(BlocksRegistry.asphalt_block), new Object[]{"   ", "11 ", "11 ", '1', ItemsRegistry.asphalt_crumbs});
        GameRegistry.addRecipe(new ItemStack(BlocksRegistry.asphalt_block), new Object[]{"   ", " 11", " 11", '1', ItemsRegistry.asphalt_crumbs});
                
			//	-Shapeless
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsRegistry.smilodon_populator_fang, 2), new Object[] {ItemsRegistry.smilodon_populator_skull});
		

	}
}
