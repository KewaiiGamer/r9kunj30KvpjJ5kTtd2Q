package com.elseytd.pleistocraft.render;

import com.elseytd.pleistocraft.Reference;
import com.elseytd.pleistocraft.entitys.EntitySmilodonPopulator;
import com.elseytd.pleistocraft.models.ModelSmilodonPopulator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerArrow;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSmilodonPopulator extends RenderLiving<EntitySmilodonPopulator> {

	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID+":"+"textures/entitys/smilodon_populator.png");
	
	protected ModelSmilodonPopulator modelentity;
	
	/*public RenderSmilodonPopulator(ModelBase modelbase, float par2) {
		super(Minecraft.getMinecraft().getRenderManager(),modelbase, par2);
		modelentity = ((ModelSmilodonPopulator) mainModel);
	}*/
	public RenderSmilodonPopulator(RenderManager render) {
		super(render, new ModelSmilodonPopulator(), 0.5F);
		this.addLayer(new LayerBipedArmor(this));
		this.addLayer(new LayerHeldItem(this));
		this.addLayer(new LayerArrow(this));
	}
/*
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


	@Override
	protected ResourceLocation getEntityTexture(RenderSmilodonPopulator entity) {
		return null;
	}
*/
	@Override
	protected ResourceLocation getEntityTexture(EntitySmilodonPopulator entity) {
		return null;
	}
}
