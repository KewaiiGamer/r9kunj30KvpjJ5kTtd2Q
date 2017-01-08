package com.elseytd.pleistocraft.items;

import com.elseytd.pleistocraft.Main;
import com.elseytd.pleistocraft.blocks.entities.TileEntitySmilodonPopulatorSkull;
import com.elseytd.pleistocraft.registries.BlocksRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemSmilodonPopulatorSkull extends Item {

	public ItemSmilodonPopulatorSkull(String unlocalizedName) {
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.PleistoCraft);
	}
	/**
	 * Called when a Block is right-clicked with this Item
	 **/
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) {
			return EnumActionResult.SUCCESS;
		} else if (side != EnumFacing.UP) {
			return EnumActionResult.FAIL;
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
				IBlockState iblockstate1 = BlocksRegistry.block_smilodon_populator_skull
						.getStateFromMeta(0);

				worldIn.setBlockState(pos, iblockstate1, 3);

				--stack.stackSize;
				int facing = MathHelper.floor_double((double) ((playerIn.rotationYaw * 4F) / 360F) + 0.5D) & 3;
				TileEntity te = worldIn.getTileEntity(pos);
				if (te != null && te instanceof TileEntitySmilodonPopulatorSkull) {
					TileEntitySmilodonPopulatorSkull facedte = (TileEntitySmilodonPopulatorSkull) te;
					if(facing == 1){
						facing = 3;
					}else if (facing == 3){
						facing = 1;
					}
					facedte.setFacing(facing);
					worldIn.notifyBlockUpdate(pos, iblockstate, iblockstate1, 3);
				}
				return EnumActionResult.SUCCESS;
			} else {
				return EnumActionResult.FAIL;
			}

		}
	}
}
