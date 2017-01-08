package com.elseytd.pleistocraft.registries;

import com.elseytd.pleistocraft.blocks.*;
import net.minecraft.block.material.Material;

//Referenced in CommonProxy in PreInt

public final class BlocksRegistry {
	  
	public static BlockAsphalt asphalt_block;
	public static BlockNaturalAsphalt natural_asphalt;
	public static BlockPermafrost permafrost;
	public static BlockHomotheriumSerumSkull block_homotherium_serum_skull;
	public static BlockPantheraAtroxSkull block_panthera_atrox_skull;
	public static BlockPantheraTigrisAltaicaSkull block_panthera_tigris_altaica_skull;
	public static BlockPantheraSpelaeaSkull block_panthera_spelaea_skull;
	public static BlockCrocutaCrocutaSpelaeaSkull block_crocuta_crocuta_spelaea_skull;

	public static BlockCanisDirusSkull block_canis_dirus_skull;
	public static BlockSmilodonPopulatorSkull block_smilodon_populator_skull;

    public static final void init() {
    	
    	//EX: GameRegistry.registerBlock(VARIABLENAME = new CLASSNAME(VARIABLES), "VARIABLENAME");

		asphalt_block = new BlockAsphalt(Material.ROCK);
		natural_asphalt = new BlockNaturalAsphalt(Material.ROCK);
		permafrost = new BlockPermafrost(Material.ICE);
		block_smilodon_populator_skull = new BlockSmilodonPopulatorSkull(Material.GROUND);
		block_homotherium_serum_skull = new BlockHomotheriumSerumSkull(Material.GROUND);
		block_panthera_atrox_skull = new BlockPantheraAtroxSkull(Material.GROUND);
		block_panthera_tigris_altaica_skull = new BlockPantheraTigrisAltaicaSkull(Material.GROUND);
		block_panthera_spelaea_skull = new BlockPantheraSpelaeaSkull(Material.GROUND);
		block_crocuta_crocuta_spelaea_skull = new BlockCrocutaCrocutaSpelaeaSkull(Material.GROUND);
		block_canis_dirus_skull = new BlockCanisDirusSkull(Material.GROUND);

    }
    
    
}
