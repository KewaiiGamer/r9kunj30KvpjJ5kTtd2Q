package com.elseytd.pleistocraft.registries;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.elseytd.pleistocraft.blocks.BlockPantheraAtroxSkull;
import com.elseytd.pleistocraft.blocks.BlockPantheraSpelaeaSkull;
import com.elseytd.pleistocraft.blocks.BlockPantheraTigrisAltaicaSkull;
import com.elseytd.pleistocraft.blocks.BlockAsphalt;
import com.elseytd.pleistocraft.blocks.BlockCanisDirusSkull;
import com.elseytd.pleistocraft.blocks.BlockCrocutaCrocutaSpelaeaSkull;
import com.elseytd.pleistocraft.blocks.BlockHomotheriumSerumSkull;
import com.elseytd.pleistocraft.blocks.BlockNaturalAsphalt;
import com.elseytd.pleistocraft.blocks.BlockPermafrost;
import com.elseytd.pleistocraft.blocks.BlockSmilodonPopulatorSkull;

//Referenced in CommonProxy in PreInt

public final class BlocksRegistry {
	  
	public static Block asphalt_block;
	public static Block natural_asphalt;
	public static Block permafrost;
	public static Block block_homotherium_serum_skull;
	public static Block block_panthera_atrox_skull;
	public static Block block_panthera_tigris_altaica_skull;
	public static Block block_panthera_spelaea_skull;
	public static Block block_crocuta_crocuta_spelaea_skull;
	public static Block block_canis_dirus_skull;
	public static Block block_smilodon_populator_skull;
	
    public static final void init() {
    	
    	//EX: GameRegistry.registerBlock(VARIABLENAME = new CLASSNAME(VARIABLES), "VARIABLENAME");
    	
    	GameRegistry.registerBlock(asphalt_block = new BlockAsphalt(Material.rock), "asphalt_block");
    	GameRegistry.registerBlock(natural_asphalt = new BlockNaturalAsphalt(Material.rock), "natural_asphalt");
    	GameRegistry.registerBlock(permafrost = new BlockPermafrost(Material.ice), "permafrost");
    	GameRegistry.registerBlock(block_smilodon_populator_skull = new BlockSmilodonPopulatorSkull(Material.ground), "block_smilodon_populator_skull");
    	GameRegistry.registerBlock(block_homotherium_serum_skull = new BlockHomotheriumSerumSkull(Material.ground), "block_homotherium_serum_skull");
    	GameRegistry.registerBlock(block_panthera_atrox_skull = new BlockPantheraAtroxSkull(Material.ground), "block_panthera_atrox_skull");
    	GameRegistry.registerBlock(block_panthera_tigris_altaica_skull = new BlockPantheraTigrisAltaicaSkull(Material.ground), "block_panthera_tigris_altaica_skull");
    	GameRegistry.registerBlock(block_panthera_spelaea_skull = new BlockPantheraSpelaeaSkull(Material.ground), "block_panthera_spelaea_skull");
    	GameRegistry.registerBlock(block_crocuta_crocuta_spelaea_skull = new BlockCrocutaCrocutaSpelaeaSkull(Material.ground), "block_crocuta_crocuta_spelaea_skull");
    	GameRegistry.registerBlock(block_canis_dirus_skull = new BlockCanisDirusSkull(Material.ground), "block_canis_dirus_skull");
    }
    
    
}
