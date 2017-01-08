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

public class BlockNaturalAsphalt extends Block{
	
	public BlockNaturalAsphalt(Material materialIn) {
		super(materialIn);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setUnlocalizedName("natural_asphalt");
		this.setRegistryName(Reference.MOD_ID + ":" + "natural_asphalt");
		this.setCreativeTab(Main.PleistoCraft);
		this.setSoundType(blockSoundType.STONE);
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
	}
	
	@Override
	public ArrayList getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) {
	    ArrayList drops = new ArrayList();
	    if (RANDOM.nextFloat() < 0.60F)
	    drops.add(new ItemStack(ItemsRegistry.asphalt_crumbs, RANDOM.nextInt(4) + 2));
	    if (RANDOM.nextFloat() < 0.25F)
	    drops.add(new ItemStack(Blocks.DIRT, RANDOM.nextInt(2) + 1));
	    if (RANDOM.nextFloat() < 0.15F)
	    drops.add(new ItemStack(ItemsRegistry.asphalt_fossil, RANDOM.nextInt(2) + 1));
	    return drops;
	}
	

}
