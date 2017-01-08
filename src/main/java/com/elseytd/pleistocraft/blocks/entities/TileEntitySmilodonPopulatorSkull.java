package com.elseytd.pleistocraft.blocks.entities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySmilodonPopulatorSkull extends TileEntity{
	
	public int facing;
	
	@Override
	public void readFromNBT(NBTTagCompound nbttagcompound) {
	super.readFromNBT(nbttagcompound);
	facing = nbttagcompound.getInteger("facing");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbttagcompound) {
	super.writeToNBT(nbttagcompound);
	nbttagcompound.setInteger("facing", facing);
	return nbttagcompound;
	}

	public int getFacing() {
	return facing;
	}

	public void setFacing(int facing) {
	this.facing = facing;
	}
}
