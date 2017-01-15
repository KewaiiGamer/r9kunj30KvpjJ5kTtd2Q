package com.elseytd.pleistocraft.render;

import com.elseytd.pleistocraft.Reference;
import com.elseytd.pleistocraft.entitys.EntitySmilodonPopulator;
import com.elseytd.pleistocraft.models.ModelSmilodonPopulator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/*public class RenderSmilodonPopulator extends RenderLiving<EntitySmilodonPopulatorkindaWorking> {

	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID+":"+"textures/entitys/populator.png");

	public static final Factory FACTORY = new Factory() {
	};

	protected ModelSmilodonPopulator modelentity;
	
	/*public RenderSmilodonPopulator(ModelBase modelbase, float par2) {
		super(Minecraft.getMinecraft().getRenderManager(),modelbase, par2);
		modelentity = ((ModelSmilodonPopulator) mainModel);
	}
	public RenderSmilodonPopulator(RenderManager render) {
		super(render, new ModelSmilodonPopulator(), 0.5F);
		this.addLayer(new LayerBipedArmor(this));
		this.addLayer(new LayerHeldItem(this));
		this.addLayer(new LayerArrow(this));
	}

	public void renderSmilodonPopulator(EntitySmilodonPopulatorkindaWorking entity, double x, double y, double z, float u, float v){
		super.doRender(entity,x,y,z,u,v);
	}
	
	public void doRenderLiving(EntityLiving entityliving, double x, double y, double z, float u, float v){
		renderSmilodonPopulator((EntitySmilodonPopulatorkindaWorking)entityliving,x,y,z,u,v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v){
		renderSmilodonPopulator((EntitySmilodonPopulatorkindaWorking)entity,x,y,z,u,v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}


	@Override
	protected ResourceLocation getEntityTexture(RenderSmilodonPopulator entity) {
		return null;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySmilodonPopulatorkindaWorking entity) {
		return null;
	}
}
*/
import net.minecraft.client.renderer.entity.Render;

import javax.annotation.Nonnull;

public class RenderSmilodonPopulator extends RenderLiving<EntitySmilodonPopulator> {

	private ResourceLocation mobTexture = new ResourceLocation(Reference.MOD_ID+":"+"textures/entitys/smilodon_populator.png");

	public static final Factory FACTORY = new Factory();

	public RenderSmilodonPopulator(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelSmilodonPopulator(), 0.5F);
	}

	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntitySmilodonPopulator entity) {
		return mobTexture;
	}

	public static class Factory implements IRenderFactory<EntitySmilodonPopulator> {

		@Override
		public Render<? super EntitySmilodonPopulator> createRenderFor(RenderManager manager) {
			return new RenderSmilodonPopulator(manager);
		}

	}

}