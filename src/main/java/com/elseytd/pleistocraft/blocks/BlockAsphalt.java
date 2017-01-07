package com.elseytd.pleistocraft.blocks;

import java.util.ArrayList;

import com.elseytd.pleistocraft.Main;
import com.elseytd.pleistocraft.registries.ItemsRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockAsphalt extends Block{
	
	public BlockAsphalt(Material materialIn) {
		super(materialIn);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setUnlocalizedName("asphalt_block");
		this.setCreativeTab(Main.PleistoCraft);
		this.setStepSound(soundTypeStone);
	}
	

}
