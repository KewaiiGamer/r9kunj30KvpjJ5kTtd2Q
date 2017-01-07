package com.elseytd.pleistocraft.blocks.entities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPantheraSpelaeaSkull extends TileEntity{
	
	public int facing;
	
	@Override
	public void readFromNBT(NBTTagCompound nbttagcompound) {
	super.readFromNBT(nbttagcompound);
	facing = nbttagcompound.getInteger("facing");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbttagcompound) {
	super.writeToNBT(nbttagcompound);
	nbttagcompound.setInteger("facing", facing);
	}

	public int getFacing() {
	return facing;
	}

	public void setFacing(int facing) {
	this.facing = facing;
	}
}
