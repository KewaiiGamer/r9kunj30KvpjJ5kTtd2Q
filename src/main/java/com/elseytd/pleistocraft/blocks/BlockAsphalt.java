package com.elseytd.pleistocraft.blocks;


import com.elseytd.pleistocraft.Main;
import com.elseytd.pleistocraft.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockAsphalt extends Block{
	
	public BlockAsphalt(Material materialIn) {
		super(materialIn);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setUnlocalizedName("asphalt_block");
		this.setRegistryName(Reference.MOD_ID + ":" + "asphalt_block");
		this.setCreativeTab(Main.PleistoCraft);
		this.setSoundType(blockSoundType.STONE);
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
	}
	

}
