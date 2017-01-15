package com.elseytd.pleistocraft.models;

import net.minecraft.client.model.ModelRenderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * Smilodon Grey - Undefined
 * Created using Tabula 5.1.0
 */
public class ModelSmilodonPopulator extends ModelBase {
    public ModelRenderer chest;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer neck;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer tail;
    public ModelRenderer beard;
    public ModelRenderer snout;
    public ModelRenderer jaw;
    public ModelRenderer earL;
    public ModelRenderer earR;
    public ModelRenderer fangL;
    public ModelRenderer fangR;
    public ModelRenderer fangL2;
    public ModelRenderer fangR2;

    public ModelSmilodonPopulator() {
        this.textureWidth = 150;
        this.textureHeight = 100;
        this.earL = new ModelRenderer(this, 22, 25);
        this.earL.setRotationPoint(1.4F, -5.5F, -3.5F);
        this.earL.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(earL, 0.36425021489121656F, 0.0F, 0.40980330836826856F);
        this.chest = new ModelRenderer(this, 0, 0);
        this.chest.setRotationPoint(0.0F, 4.0F, 6.0F);
        this.chest.addBox(-5.5F, -6.0F, -14.0F, 11, 13, 10, 0.0F);
        this.head = new ModelRenderer(this, 0, 25);
        this.head.setRotationPoint(0.5F, -1.6F, -10.2F);
        this.head.addBox(-4.0F, -4.0F, -7.0F, 7, 7, 7, 0.0F);
        this.setRotateAngle(head, 0.31869712141416456F, 0.0F, 0.0F);
        this.leg4 = new ModelRenderer(this, 71, 65);
        this.leg4.setRotationPoint(-5.0F, -1.6F, -2.0F);
        this.leg4.addBox(0.0F, 0.0F, 0.0F, 4, 20, 6, 0.0F);
        this.setRotateAngle(leg4, 0.136659280431156F, 0.0F, 0.0F);
        this.jaw = new ModelRenderer(this, 0, 51);
        this.jaw.setRotationPoint(0.0F, 0.5F, -4.6F);
        this.jaw.addBox(-2.0F, -1.5F, -6.0F, 3, 3, 6, 0.0F);
        this.setRotateAngle(jaw, 0.31869712141416456F, 0.0F, 0.0F);
        this.fangR = new ModelRenderer(this, 25, 50);
        this.fangR.setRotationPoint(-2.4F, 0.5F, -5.0F);
        this.fangR.addBox(0.0F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.fangL2 = new ModelRenderer(this, 32, 40);
        this.fangL2.setRotationPoint(0.0F, 3.2F, 0.3F);
        this.fangL2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(fangL2, 0.36425021489121656F, 0.0F, 0.0F);
        this.fangL = new ModelRenderer(this, 25, 40);
        this.fangL.setRotationPoint(0.49F, 0.5F, -5.0F);
        this.fangL.addBox(0.0F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.leg3 = new ModelRenderer(this, 45, 65);
        this.leg3.setRotationPoint(1.0F, -1.6F, -2.0F);
        this.leg3.addBox(0.0F, 0.0F, 0.0F, 4, 20, 6, 0.0F);
        this.setRotateAngle(leg3, 0.136659280431156F, 0.0F, 0.0F);
        this.beard = new ModelRenderer(this, 98, 7);
        this.beard.setRotationPoint(-0.5F, 1.0F, -13.0F);
        this.beard.addBox(0.0F, 0.0F, 0.0F, 0, 6, 12, 0.0F);
        this.neck = new ModelRenderer(this, 98, 0);
        this.neck.setRotationPoint(0.5F, -0.5F, -9.5F);
        this.neck.addBox(-4.0F, -4.5F, -11.0F, 7, 8, 11, 0.0F);
        this.setRotateAngle(neck, -0.4553564018453205F, 0.0F, 0.0F);
        this.tail = new ModelRenderer(this, 0, 65);
        this.tail.setRotationPoint(-1.5F, -4.5F, 4.8F);
        this.tail.addBox(0.0F, 0.0F, 0.0F, 3, 3, 9, 0.0F);
        this.setRotateAngle(tail, -1.0016444577195458F, 0.0F, 0.0F);
        this.leg1 = new ModelRenderer(this, 45, 30);
        this.leg1.setRotationPoint(1.0F, -5.0F, -12.5F);
        this.leg1.addBox(0.0F, 0.0F, 0.0F, 5, 25, 6, 0.0F);
        this.snout = new ModelRenderer(this, 0, 40);
        this.snout.setRotationPoint(0.0F, -1.7F, -5.4F);
        this.snout.addBox(-2.5F, -2.0F, -6.0F, 4, 4, 6, 0.0F);
        this.setRotateAngle(snout, 0.18203784098300857F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 45, 0);
        this.body.setRotationPoint(0.0F, 1.8F, 7.0F);
        this.body.addBox(-4.5F, -5.0F, -12.0F, 9, 12, 17, 0.0F);
        this.setRotateAngle(body, -0.136659280431156F, 0.0F, 0.0F);
        this.leg2 = new ModelRenderer(this, 70, 31);
        this.leg2.setRotationPoint(-6.1F, -5.0F, -12.5F);
        this.leg2.addBox(0.0F, 0.0F, 0.0F, 5, 25, 6, 0.0F);
        this.earR = new ModelRenderer(this, 31, 25);
        this.earR.setRotationPoint(-5.2F, -4.3F, -3.6F);
        this.earR.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(earR, 0.40980330836826856F, 0.0F, -0.40980330836826856F);
        this.fangR2 = new ModelRenderer(this, 32, 50);
        this.fangR2.setRotationPoint(0.0F, 3.2F, 0.5F);
        this.fangR2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(fangR2, 0.36425021489121656F, 0.0F, 0.0F);
        this.head.addChild(this.earL);
        this.body.addChild(this.leg4);
        this.head.addChild(this.jaw);
        this.snout.addChild(this.fangR);
        this.fangL.addChild(this.fangL2);
        this.snout.addChild(this.fangL);
        this.body.addChild(this.leg3);
        this.neck.addChild(this.beard);
        this.chest.addChild(this.neck);
        this.body.addChild(this.tail);
        this.chest.addChild(this.leg1);
        this.head.addChild(this.snout);
        this.chest.addChild(this.body);
        this.chest.addChild(this.leg2);
        this.head.addChild(this.earR);
        this.fangR.addChild(this.fangR2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.chest.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.head.offsetX, this.head.offsetY, this.head.offsetZ);
        GlStateManager.translate(this.head.rotationPointX * f5, this.head.rotationPointY * f5, this.head.rotationPointZ * f5);
        GlStateManager.scale(1.01D, 1.01D, 1.01D);
        GlStateManager.translate(-this.head.offsetX, -this.head.offsetY, -this.head.offsetZ);
        GlStateManager.translate(-this.head.rotationPointX * f5, -this.head.rotationPointY * f5, -this.head.rotationPointZ * f5);
        this.head.render(f5);
        GlStateManager.popMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
