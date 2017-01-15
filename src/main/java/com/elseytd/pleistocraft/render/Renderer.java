package com.elseytd.pleistocraft.render;

import com.elseytd.pleistocraft.Reference;
import com.elseytd.pleistocraft.blocks.BlockAsphalt;
import com.elseytd.pleistocraft.blocks.entities.*;
import com.elseytd.pleistocraft.registries.BlocksRegistry;
import com.elseytd.pleistocraft.registries.ItemsRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Renderer {

	public static BlockAsphalt blockAsphalt;
	@SuppressWarnings("deprecation")
	public static void registerItemRenderer() {
		
		//Items
		registerItem(ItemsRegistry.cooked_smilodon_meat);
		registerItem(ItemsRegistry.raw_smilodon_meat);
		registerItem(ItemsRegistry.asphalt_crumbs);
		registerItem(ItemsRegistry.asphalt_fossil);
		registerItem(ItemsRegistry.frozen_animal_tissue);
		registerItem(ItemsRegistry.homotherium_serum_skull);
		registerItem(ItemsRegistry.panthera_atrox_skull);
		registerItem(ItemsRegistry.panthera_tigris_altaica_skull);
		registerItem(ItemsRegistry.panthera_spelaea_skull);
		registerItem(ItemsRegistry.crocuta_crocuta_spelaea_skull);
		registerItem(ItemsRegistry.canis_dirus_skull);
		registerItem(ItemsRegistry.smilodon_populator_skull);
		registerItem(ItemsRegistry.smilodon_populator_fang);
		registerItem(ItemsRegistry.smilodon_populator_fang_sword);

		//Blocks
		registerBlock(BlocksRegistry.asphalt_block);
		registerBlock(BlocksRegistry.natural_asphalt);
		registerBlock(BlocksRegistry.permafrost);
		registerBlock(BlocksRegistry.block_homotherium_serum_skull);
		registerBlock(BlocksRegistry.block_panthera_atrox_skull);
		registerBlock(BlocksRegistry.block_panthera_tigris_altaica_skull);
		registerBlock(BlocksRegistry.block_panthera_spelaea_skull);
		registerBlock(BlocksRegistry.block_crocuta_crocuta_spelaea_skull);
		registerBlock(BlocksRegistry.block_smilodon_populator_skull);
		registerBlock(BlocksRegistry.block_canis_dirus_skull );
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHomotheriumSerumSkull.class, new RenderHomotheriumSerumSkull());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPantheraAtroxSkull.class, new RenderPantheraAtroxSkull());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPantheraTigrisAltaicaSkull.class, new RenderPantheraTigrisAltaicaSkull());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPantheraSpelaeaSkull.class, new RenderPantheraSpelaeaSkull());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrocutaCrocutaSpelaeaSkull.class, new RenderCrocutaCrocutaSpelaeaSkull());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCanisDirusSkull.class, new RenderCanisDirusSkull());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmilodonPopulatorSkull.class, new RenderSmilodonPopulatorSkull());

		//Entitys
		//RenderingRegistry.registerEntityRenderingHandler(EntitySmilodonPopulatorkindaWorking.class, RenderSmilodonPopulator::new);
	}
	

	public static void registerBlock(Block block) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}


	public static void registerItem(Item item) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}

/*
	public static void registerModel(Object obj, int meta)
	{
		Item item;
		if ((obj instanceof Item)) {
			item = (Item)obj;
		} else if ((obj instanceof Block)){
			item = Item.getItemFromBlock((Block)obj);
		} else {
			throw new IllegalArgumentException("Only item and block instances");
		}
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}*/
}

