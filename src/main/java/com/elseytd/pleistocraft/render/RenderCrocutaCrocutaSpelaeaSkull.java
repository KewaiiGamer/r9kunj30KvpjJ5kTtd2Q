package com.elseytd.pleistocraft.render;

import com.elseytd.pleistocraft.Reference;
import com.elseytd.pleistocraft.blocks.entities.TileEntityCrocutaCrocutaSpelaeaSkull;
import com.elseytd.pleistocraft.models.ModelCrocutaCrocutaSpelaeaSkull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderCrocutaCrocutaSpelaeaSkull extends TileEntitySpecialRenderer {

	private final ModelCrocutaCrocutaSpelaeaSkull model;
	private final String TextureLocation = Reference.MOD_ID + ":textures/blocks/crocuta_crocuta_spelaea_skull.png";
	
	public RenderCrocutaCrocutaSpelaeaSkull() {
		this.model = new ModelCrocutaCrocutaSpelaeaSkull();
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
		
		TileEntityCrocutaCrocutaSpelaeaSkull facedEntity = (TileEntityCrocutaCrocutaSpelaeaSkull) te;
		
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
