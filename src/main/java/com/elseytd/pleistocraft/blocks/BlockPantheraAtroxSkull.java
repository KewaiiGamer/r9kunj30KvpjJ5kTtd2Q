package com.elseytd.pleistocraft.blocks;

import java.util.Random;

import com.elseytd.pleistocraft.blocks.entities.TileEntityPantheraAtroxSkull;
import com.elseytd.pleistocraft.registries.ItemsRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPantheraAtroxSkull extends BlockContainer {

	private Item drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public BlockPantheraAtroxSkull(Material material) {
		super(material);
		this.drop = ItemsRegistry.panthera_atrox_skull;
        this.meta = 0;
        this.least_quantity = 1;
        this.most_quantity = 1;
		this.setUnlocalizedName("block_panthera_atrox_skull");
		this.setCreativeTab(null);
		this.setHardness(0F);
		this.setResistance(10.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}


	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityPantheraAtroxSkull();
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			Block block = worldIn.getBlockState(pos.north()).getBlock();
			Block block1 = worldIn.getBlockState(pos.south()).getBlock();
			Block block2 = worldIn.getBlockState(pos.west()).getBlock();
			Block block3 = worldIn.getBlockState(pos.east()).getBlock();
			EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);
			if (enumfacing == EnumFacing.NORTH && block.isFullBlock()&& !block1.isFullBlock()) {
				enumfacing = EnumFacing.SOUTH;
			} else if (enumfacing == EnumFacing.SOUTH && block1.isFullBlock()&& !block.isFullBlock()) {
				enumfacing = EnumFacing.NORTH;
			} else if (enumfacing == EnumFacing.WEST && block2.isFullBlock()&& !block3.isFullBlock()) {
				enumfacing = EnumFacing.EAST;
			} else if (enumfacing == EnumFacing.EAST && block3.isFullBlock()&& !block2.isFullBlock()) {
				enumfacing = EnumFacing.WEST;
			}
			worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing),2);
		}
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos,EnumFacing facing, float hitX, float hitY, float hitZ, int meta,EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING,placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		int facing = MathHelper.floor_double((double) ((placer.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		TileEntity te = worldIn.getTileEntity(pos);
		if (te != null && te instanceof TileEntityPantheraAtroxSkull) {
			TileEntityPantheraAtroxSkull facedte = (TileEntityPantheraAtroxSkull) te;
			facedte.setFacing(facing);
			System.out.println("PLACED");
			System.out.println(facing);
			worldIn.markBlockForUpdate(pos);
		}
	}

	/*
	 * public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState
	 * state, EntityLivingBase placer, ItemStack stack) {
	 * worldIn.setBlockState(pos, state.withProperty(FACING, placer
	 * .getHorizontalFacing().getOpposite()), 2); }
	 */

	public boolean onBlockActivated(World worldIn, BlockPos pos,IBlockState state, EntityPlayer playerIn, EnumFacing side,float hitX, float hitY, float hitZ) {
		int facing = MathHelper.floor_double((double) ((playerIn.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		TileEntity te = worldIn.getTileEntity(pos);
		if (te != null && te instanceof TileEntityPantheraAtroxSkull) {
			TileEntityPantheraAtroxSkull facedte = (TileEntityPantheraAtroxSkull) te;
			if(facing == 1){
				facing = 3;
			}else if (facing == 3){
				facing = 1;
			}
			facedte.setFacing(facing);
			worldIn.markBlockForUpdate(pos);
		}
		return true;
	}

	@SideOnly(Side.CLIENT)
	public IBlockState getStateForEntityRender(IBlockState state) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
	}

	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.getFront(meta);
		if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
			enumfacing = EnumFacing.NORTH;
		}
		return this.getDefaultState().withProperty(FACING, enumfacing);
	}

	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing) state.getValue(FACING)).getIndex();
	}

	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { FACING });
	}

	@SideOnly(Side.CLIENT)
	static final class SwitchEnumFacing {
		static final int[] FACING_LOOKUP = new int[EnumFacing.values().length];
		static {
			try {
				FACING_LOOKUP[EnumFacing.WEST.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}
			try {
				FACING_LOOKUP[EnumFacing.EAST.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}
			try {
				FACING_LOOKUP[EnumFacing.NORTH.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}
			try {
				FACING_LOOKUP[EnumFacing.SOUTH.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}
		}
	}
	
	@Override
	public Item getItemDropped(IBlockState blockstate, Random random, int fortune) {
	    return this.drop;
	}

	@Override
	public int damageDropped(IBlockState blockstate) {
	    return this.meta;
	}

	@Override
	public int quantityDropped(IBlockState blockstate, int fortune, Random random) {
	    return 1;
	}
}
