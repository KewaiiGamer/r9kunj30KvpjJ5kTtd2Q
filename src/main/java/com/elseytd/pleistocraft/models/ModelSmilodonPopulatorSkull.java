package com.elseytd.pleistocraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelSmilodonPopulatorSkull extends ModelBase {

	public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer Jaw;
    public ModelRenderer FangL;
    public ModelRenderer FangR;
    public ModelRenderer FangL2;
    public ModelRenderer FangR2;

    public ModelSmilodonPopulatorSkull() {
        this.textureWidth = 150;
        this.textureHeight = 100;
        
        this.FangR2 = new ModelRenderer(this, 32, 50);
        this.FangR2.setRotationPoint(0.0F, 3.2F, 0.5F);
        this.FangR2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(FangR2, 0.36425021489121656F, 0.0F, 0.0F);
        this.FangL2 = new ModelRenderer(this, 32, 40);
        this.FangL2.setRotationPoint(0.0F, 3.2F, 0.3F);
        this.FangL2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(FangL2, 0.36425021489121656F, 0.0F, 0.0F);
        this.FangR = new ModelRenderer(this, 25, 50);
        this.FangR.setRotationPoint(-2.6F, 0.5F, -5.0F);
        this.FangR.addBox(0.0F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 40);
        this.Snout.setRotationPoint(0.0F, -1.7F, -5.4F);
        this.Snout.addBox(-2.5F, -2.0F, -6.0F, 4, 4, 6, 0.0F);
        this.setRotateAngle(Snout, 0.18203784098300857F, 0.0F, 0.0F);
        this.Jaw = new ModelRenderer(this, 0, 51);
        this.Jaw.setRotationPoint(0.0F, 1.0F, -4.6F);
        this.Jaw.addBox(-2.0F, -1.5F, -6.0F, 3, 3, 6, 0.0F);
        this.setRotateAngle(Jaw, 0.6373942428283291F, 0.0F, 0.0F);
        this.FangL = new ModelRenderer(this, 25, 40);
        this.FangL.setRotationPoint(0.59F, 0.5F, -5.0F);
        this.FangL.addBox(0.0F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.Head = new ModelRenderer(this, 0, 25);
        this.Head.setRotationPoint(0.5F, 23.9F, 5.0F);
        this.Head.addBox(-4.0F, -4.0F, -7.0F, 7, 7, 7, 0.0F);
        this.setRotateAngle(Head, -0.5918411493512771F, 0.0F, 0.0F);
        this.FangR.addChild(this.FangR2);
        this.FangL.addChild(this.FangL2);
        this.Snout.addChild(this.FangR);
        this.Head.addChild(this.Snout);
        this.Head.addChild(this.Jaw);
        this.Snout.addChild(this.FangL);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Head.offsetX, this.Head.offsetY, this.Head.offsetZ);
        GlStateManager.translate(this.Head.rotationPointX * f5, this.Head.rotationPointY * f5, this.Head.rotationPointZ * f5);
        GlStateManager.scale(0.85D, 0.85D, 0.85D);
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
