package com.elseytd.pleistocraft.render;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.elseytd.pleistocraft.Main;
import com.elseytd.pleistocraft.Reference;
import com.elseytd.pleistocraft.blocks.entities.TileEntityCanisDirusSkull;
import com.elseytd.pleistocraft.blocks.entities.TileEntityCrocutaCrocutaSpelaeaSkull;
import com.elseytd.pleistocraft.blocks.entities.TileEntityHomotheriumSerumSkull;
import com.elseytd.pleistocraft.blocks.entities.TileEntityPantheraAtroxSkull;
import com.elseytd.pleistocraft.blocks.entities.TileEntityPantheraSpelaeaSkull;
import com.elseytd.pleistocraft.blocks.entities.TileEntityPantheraTigrisAltaicaSkull;
import com.elseytd.pleistocraft.blocks.entities.TileEntitySmilodonPopulatorSkull;
import com.elseytd.pleistocraft.entitys.EntitySmilodonPopulator;
import com.elseytd.pleistocraft.models.ModelSmilodonPopulator;
import com.elseytd.pleistocraft.registries.BlocksRegistry;
import com.elseytd.pleistocraft.registries.ItemsRegistry;

public class Renderer {
	
	@SuppressWarnings("deprecation")
	public static void registerItemRenderer() {
		
		//Items
		registeritem(ItemsRegistry.cooked_smilodon_meat);
		registeritem(ItemsRegistry.raw_smilodon_meat);
		registeritem(ItemsRegistry.asphalt_crumbs);
		registeritem(ItemsRegistry.asphalt_fossil);
		registeritem(ItemsRegistry.frozen_animal_tissue);
		registeritem(ItemsRegistry.homotherium_serum_skull);
		registeritem(ItemsRegistry.panthera_atrox_skull);
		registeritem(ItemsRegistry.panthera_tigris_altaica_skull);
		registeritem(ItemsRegistry.panthera_spelaea_skull);
		registeritem(ItemsRegistry.crocuta_crocuta_spelaea_skull);
		registeritem(ItemsRegistry.canis_dirus_skull);
		registeritem(ItemsRegistry.smilodon_populator_skull);
		registeritem(ItemsRegistry.smilodon_populator_fang);
		registeritem(ItemsRegistry.smilodon_populator_fang_sword);
				
		//Blocks
		registerblock(BlocksRegistry.asphalt_block);
		registerblock(BlocksRegistry.natural_asphalt);
		registerblock(BlocksRegistry.permafrost);
		registerblock(BlocksRegistry.block_homotherium_serum_skull);
		registerblock(BlocksRegistry.block_panthera_atrox_skull);
		registerblock(BlocksRegistry.block_panthera_tigris_altaica_skull);
		registerblock(BlocksRegistry.block_panthera_spelaea_skull);
		registerblock(BlocksRegistry.block_crocuta_crocuta_spelaea_skull);
		registerblock(BlocksRegistry.block_canis_dirus_skull);
		registerblock(BlocksRegistry.block_smilodon_populator_skull);
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHomotheriumSerumSkull.class, new RenderHomotheriumSerumSkull());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPantheraAtroxSkull.class, new RenderPantheraAtroxSkull());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPantheraTigrisAltaicaSkull.class, new RenderPantheraTigrisAltaicaSkull());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPantheraSpelaeaSkull.class, new RenderPantheraSpelaeaSkull());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrocutaCrocutaSpelaeaSkull.class, new RenderCrocutaCrocutaSpelaeaSkull());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCanisDirusSkull.class, new RenderCanisDirusSkull());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmilodonPopulatorSkull.class, new RenderSmilodonPopulatorSkull());
		
		//Entitys
		RenderingRegistry.registerEntityRenderingHandler(EntitySmilodonPopulator.class, new RenderSmilodonPopulator(new ModelSmilodonPopulator(), 0.75F));
	}
	
	public static void registerblock(Block block) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void registeritem(Item item) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	
}
