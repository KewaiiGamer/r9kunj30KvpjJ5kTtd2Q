package com.elseytd.pleistocraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelHomotheriumSerumSkull extends ModelBase {

	public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer Jaw;
    public ModelRenderer ToothBL;
    public ModelRenderer ToothBR;
    public ModelRenderer ToothL;
    public ModelRenderer ToothR;

    public ModelHomotheriumSerumSkull() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.ToothBL = new ModelRenderer(this, 77, 60);
        this.ToothBL.setRotationPoint(4.99F, 8.5F, 2.5F);
        this.ToothBL.addBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(ToothBL, 0.136659280431156F, -0.0F, 0.0F);
        this.ToothL = new ModelRenderer(this, 77, 67);
        this.ToothL.setRotationPoint(0.0F, 3.0F, 0.5F);
        this.ToothL.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(ToothL, 0.4461061568097506F, -0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 87, 22);
        this.Head.setRotationPoint(-4.0F, 16.7F, 0.0F);
        this.Head.addBox(0.0F, 0.0F, 0.0F, 10, 10, 10, 0.0F);
        this.setRotateAngle(Head, -0.31869712141416456F, -0.0F, 0.0F);
        this.ToothBR = new ModelRenderer(this, 87, 60);
        this.ToothBR.setRotationPoint(0.01F, 8.5F, 2.5F);
        this.ToothBR.addBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(ToothBR, 0.091106186954104F, -0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 102, 45);
        this.Snout.setRotationPoint(2.0F, -2.7F, -7.0F);
        this.Snout.addBox(0.0F, 4.0F, 0.0F, 6, 6, 7, 0.0F);
        this.setRotateAngle(Snout, 0.045553093477052F, -0.0F, 0.0F);
        this.Jaw = new ModelRenderer(this, 76, 46);
        this.Jaw.setRotationPoint(3.0F, 8.5F, -6.0F);
        this.Jaw.addBox(0.0F, 0.0F, 0.0F, 4, 3, 7, 0.0F);
        this.setRotateAngle(Jaw, 0.31869712141416456F, 0.0F, 0.0F);
        this.ToothR = new ModelRenderer(this, 87, 67);
        this.ToothR.setRotationPoint(0.0F, 3.0F, 0.5F);
        this.ToothR.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(ToothR, 0.4461061568097506F, -0.0F, 0.0F);
        this.Snout.addChild(this.ToothBL);
        this.ToothBL.addChild(this.ToothL);
        this.Snout.addChild(this.ToothBR);
        this.Head.addChild(this.Snout);
        this.Head.addChild(this.Jaw);
        this.ToothBR.addChild(this.ToothR);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Head.offsetX, this.Head.offsetY, this.Head.offsetZ);
        GlStateManager.translate(this.Head.rotationPointX * f5, this.Head.rotationPointY * f5, this.Head.rotationPointZ * f5);
        GlStateManager.scale(0.8D, 0.8D, 0.8D);
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
