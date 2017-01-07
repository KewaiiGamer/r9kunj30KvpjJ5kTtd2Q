package com.elseytd.pleistocraft.render;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.elseytd.pleistocraft.Main;
import com.elseytd.pleistocraft.Reference;
import com.elseytd.pleistocraft.blocks.entities.TileEntityPantheraAtroxSkull;
import com.elseytd.pleistocraft.models.ModelPantheraAtroxSkull;

public class RenderPantheraAtroxSkull extends TileEntitySpecialRenderer {

	private final ModelPantheraAtroxSkull model;
	private final String TextureLocation = Reference.MOD_ID + ":textures/blocks/panthera_atrox_skull.png";
	
	public RenderPantheraAtroxSkull() {
		this.model = new ModelPantheraAtroxSkull();
	}

	private void adjustRotatePivotViaMeta(World world, BlockPos pos) {
            IBlockState meta = world.getBlockState(pos);
            GL11.glPushMatrix();
            GL11.glRotatef(1 * (-90), 0.0F, 0.0F, 1.0F);
            GL11.glPopMatrix();
    }

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

		ResourceLocation textures = (new ResourceLocation(TextureLocation));
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		
		TileEntityPantheraAtroxSkull facedEntity = (TileEntityPantheraAtroxSkull) te;
		
		int d = facedEntity.getFacing();
		int k = d * 90;
		GL11.glRotatef(k, 0.0F, 1.0F, 0.0F);
		
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();

	}
}
