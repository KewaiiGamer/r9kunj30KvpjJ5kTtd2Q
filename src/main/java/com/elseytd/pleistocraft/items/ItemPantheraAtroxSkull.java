package com.elseytd.pleistocraft.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.elseytd.pleistocraft.Main;
import com.elseytd.pleistocraft.blocks.entities.TileEntityPantheraAtroxSkull;
import com.elseytd.pleistocraft.registries.BlocksRegistry;

public class ItemPantheraAtroxSkull extends Item {

	public ItemPantheraAtroxSkull(String unlocalizedName) {
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.PleistoCraft);
	}

	/**
	 * Called when a Block is right-clicked with this Item
	 **/
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		if (worldIn.isRemote) {
			return true;
		} else if (side != EnumFacing.UP) {
			return false;
		} else {
			IBlockState iblockstate = worldIn.getBlockState(pos);
			Block block = iblockstate.getBlock();
			boolean flag = block.isReplaceable(worldIn, pos);

			if (!flag) {
				pos = pos.up();
			}

			int i = MathHelper
					.floor_double((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EnumFacing enumfacing = EnumFacing.getHorizontal(i);
			BlockPos blockpos = pos.offset(enumfacing);

			if (playerIn.canPlayerEdit(pos, side, stack)
					&& playerIn.canPlayerEdit(blockpos, side, stack)) {
				int skullRotate = 0;
				IBlockState iblockstate1 = BlocksRegistry.block_panthera_atrox_skull
						.getStateFromMeta(0);

				worldIn.setBlockState(pos, iblockstate1, 3);

				--stack.stackSize;
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
			} else {
				return false;
			}

		}
	}
}
