package com.elseytd.pleistocraft.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.elseytd.pleistocraft.Main;
import com.elseytd.pleistocraft.Reference;
import com.elseytd.pleistocraft.entitys.EntitySmilodonPopulator;
import com.elseytd.pleistocraft.models.ModelSmilodonPopulator;

public class RenderSmilodonPopulator extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID+":"+"textures/entitys/smilodon_populator.png");
	
	protected ModelSmilodonPopulator modelentity;
	
	public RenderSmilodonPopulator(ModelBase modelbase, float par2) {
		super(Minecraft.getMinecraft().getRenderManager(),modelbase, par2);
		modelentity = ((ModelSmilodonPopulator) mainModel);
	}	

	public void renderSmilodonPopulator(EntitySmilodonPopulator entity, double x, double y, double z, float u, float v){
		super.doRender(entity,x,y,z,u,v);
	}
	
	public void doRenderLiving(EntityLiving entityliving, double x, double y, double z, float u, float v){
		renderSmilodonPopulator((EntitySmilodonPopulator)entityliving,x,y,z,u,v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v){
		renderSmilodonPopulator((EntitySmilodonPopulator)entity,x,y,z,u,v);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}


}
