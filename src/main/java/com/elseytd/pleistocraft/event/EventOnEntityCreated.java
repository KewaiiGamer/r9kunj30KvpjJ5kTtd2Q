package com.elseytd.pleistocraft.event;

import com.elseytd.pleistocraft.entitys.EntitySmilodonPopulator;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventOnEntityCreated {
    
    
    //Autotames smilodons when born next to player
    @SubscribeEvent
    public void OnEntityJoin(EntityJoinWorldEvent event){
	if(event.entity instanceof EntitySmilodonPopulator && !event.world.isRemote){
            EntitySmilodonPopulator e = (EntitySmilodonPopulator) event.entity;
            EntityPlayer p = event.world.getClosestPlayerToEntity(e, 8);
            if(e.isChild() && p != null){
                e.setTamed(true);
                e.setAttackTarget((EntityLivingBase) null);
                e.setHealth(40.0F);
                e.setOwnerId(p.getUniqueID().toString());
                e.worldObj.setEntityState(e, (byte) 7);
            }
        }
    }
}
