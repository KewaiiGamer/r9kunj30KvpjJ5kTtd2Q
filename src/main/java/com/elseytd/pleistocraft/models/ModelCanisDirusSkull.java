package com.elseytd.pleistocraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelCanisDirusSkull extends ModelBase {

	public ModelRenderer Head;
    public ModelRenderer Snout;

    public ModelCanisDirusSkull() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.Head = new ModelRenderer(this, 19, 27);
        this.Head.setRotationPoint(-2.7F, 18.9F, 0.0F);
        this.Head.addBox(0.0F, -1.0F, 0.0F, 7, 8, 8, 0.0F);
        this.Snout = new ModelRenderer(this, 55, 27);
        this.Snout.setRotationPoint(1.5F, 3.1F, -4.5F);
        this.Snout.addBox(0.0F, 0.0F, 0.0F, 4, 4, 5, 0.0F);
        this.Head.addChild(this.Snout);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Head.offsetX, this.Head.offsetY, this.Head.offsetZ);
        GlStateManager.translate(this.Head.rotationPointX * f5, this.Head.rotationPointY * f5, this.Head.rotationPointZ * f5);
        GlStateManager.scale(0.75D, 0.75D, 0.75D);
        GlStateManager.translate(-this.Head.offsetX, -this.Head.offsetY, -this.Head.offsetZ);
        GlStateManager.translate(-this.Head.rotationPointX * f5, -this.Head.rotationPointY * f5, -this.Head.rotationPointZ * f5);
        this.Head.render(f5);
        GlStateManager.popMatrix();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
  

}
