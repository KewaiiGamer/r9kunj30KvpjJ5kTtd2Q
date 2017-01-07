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

public class BlockPermafrost extends Block{
	
	public BlockPermafrost(Material materialIn) {
		super(materialIn);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setUnlocalizedName("permafrost");
		this.setCreativeTab(Main.PleistoCraft);
		this.setStepSound(soundTypeGlass);
	}
	
	@Override
	public ArrayList getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) {
	    ArrayList drops = new ArrayList();
	    if (RANDOM.nextFloat() < 0.50F)
		drops.add(new ItemStack(Blocks.dirt));
	    if (RANDOM.nextFloat() < 0.17F)
	    drops.add(new ItemStack(Blocks.ice));
	    if (RANDOM.nextFloat() < 0.33F)
	    drops.add(new ItemStack(ItemsRegistry.frozen_animal_tissue, RANDOM.nextInt(2) + 1));
	    return drops;
	}
	

}
