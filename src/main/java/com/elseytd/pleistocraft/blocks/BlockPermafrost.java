package com.elseytd.pleistocraft.blocks;

import com.elseytd.pleistocraft.Main;
import com.elseytd.pleistocraft.Reference;
import com.elseytd.pleistocraft.registries.ItemsRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;

public class BlockPermafrost extends Block{
	
	public BlockPermafrost(Material materialIn) {
		super(materialIn);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setUnlocalizedName("permafrost");
		this.setRegistryName(Reference.MOD_ID + ":" + "permafrost");
		this.setCreativeTab(Main.PleistoCraft);
		this.setSoundType(blockSoundType.GLASS);
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
	}
	
	@Override
	public ArrayList getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) {
	    ArrayList drops = new ArrayList();
	    if (RANDOM.nextFloat() < 0.50F)
		drops.add(new ItemStack(Blocks.DIRT));
	    if (RANDOM.nextFloat() < 0.17F)
	    drops.add(new ItemStack(Blocks.ICE));
	    if (RANDOM.nextFloat() < 0.33F)
	    drops.add(new ItemStack(ItemsRegistry.frozen_animal_tissue, RANDOM.nextInt(2) + 1));
	    return drops;
	}
	

}
