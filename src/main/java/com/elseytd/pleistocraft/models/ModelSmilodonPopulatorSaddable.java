package com.elseytd.pleistocraft.models;

import com.elseytd.pleistocraft.entitys.EntitySmilodonPopulator;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelSmilodonPopulatorSaddable extends ModelBase{
   public ModelRenderer Body;
    public ModelRenderer saddle;
    public ModelRenderer Chest;
    public ModelRenderer Tail;
    public ModelRenderer LegRB;
    public ModelRenderer LegLB;
    public ModelRenderer Neck;
    public ModelRenderer LegRF;
    public ModelRenderer LegLF;
    public ModelRenderer Head;
    public ModelRenderer EarL;
    public ModelRenderer EarR;
    public ModelRenderer JawU;
    public ModelRenderer JawB;
    public ModelRenderer ToothBL;
    public ModelRenderer ToothBR;
    public ModelRenderer ToothL;
    public ModelRenderer ToothR;
    public ModelRenderer thing1;
    public ModelRenderer thing2;
    public ModelRenderer front;
    public ModelRenderer chest;
    public ModelRenderer legplace1;
    public ModelRenderer legplace2;

    public ModelSmilodonPopulatorSaddable() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.EarR = new ModelRenderer(this, 139, 25);
        this.EarR.setRotationPoint(-3.0F, -1.7F, -2.5F);
        this.EarR.addBox(-1.5F, -2.0F, -1.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(EarR, -2.0436060211601603F, -1.562069680534925F, 2.0682151636132806F);
        this.legplace2 = new ModelRenderer(this, 0, 140);
        this.legplace2.setRotationPoint(-0.5F, 6.0F, 0.5F);
        this.legplace2.addBox(0.0F, 0.0F, 0.0F, 2, 4, 3, 0.0F);
        this.EarL = new ModelRenderer(this, 152, 25);
        this.EarL.setRotationPoint(3.0F, -1.7F, -2.5F);
        this.EarL.addBox(-1.5F, -2.0F, -1.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(EarL, -2.0436060211601603F, -1.562069680534925F, 2.0682151636132806F);
        this.legplace1 = new ModelRenderer(this, 0, 140);
        this.legplace1.setRotationPoint(-0.5F, 6.0F, 0.5F);
        this.legplace1.addBox(0.0F, 0.0F, 0.0F, 2, 4, 3, 0.0F);
        this.LegLF = new ModelRenderer(this, 0, 40);
        this.LegLF.setRotationPoint(4.99F, 6.0F, -7.0F);
        this.LegLF.addBox(-3.0F, 0.0F, -3.0F, 5, 15, 6, 0.0F);
        this.JawU = new ModelRenderer(this, 169, 22);
        this.JawU.setRotationPoint(0.0F, -1.0F, -5.5F);
        this.JawU.addBox(-2.5F, 0.0F, -9.0F, 5, 5, 9, 0.0F);
        this.saddle = new ModelRenderer(this, 0, 100);
        this.saddle.setRotationPoint(-8.0F, -5.0F, -5.0F);
        this.saddle.addBox(0.0F, 0.0F, 0.0F, 16, 3, 12, 0.0F);
        this.setRotateAngle(saddle, -0.136659280431156F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 120, 0);
        this.Neck.setRotationPoint(0.0F, -2.8F, -11.0F);
        this.Neck.addBox(-4.5F, -4.0F, -7.0F, 9, 9, 13, 0.0F);
        this.setRotateAngle(Neck, -0.3740240587023848F, 0.0F, 0.0F);
        this.thing1 = new ModelRenderer(this, 0, 120);
        this.thing1.setRotationPoint(14.5F, 3.0F, 3.0F);
        this.thing1.addBox(0.0F, 0.0F, 0.0F, 1, 7, 5, 0.0F);
        this.setRotateAngle(thing1, 0.136659280431156F, 0.0F, 0.0F);
        this.LegRF = new ModelRenderer(this, 25, 40);
        this.LegRF.setRotationPoint(-4.99F, 6.0F, -7.0F);
        this.LegRF.addBox(-2.0F, 0.0F, -3.0F, 5, 15, 6, 0.0F);
        this.ToothL = new ModelRenderer(this, 140, 45);
        this.ToothL.setRotationPoint(-0.02F, 4.3F, 0.7F);
        this.ToothL.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(ToothL, 0.27314402793711257F, -0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 61, 33);
        this.Tail.setRotationPoint(0.0F, -2.0F, 5.0F);
        this.Tail.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 12, 0.0F);
        this.setRotateAngle(Tail, -0.8178612874845427F, 0.091106186954104F, 0.0F);
        this.Head = new ModelRenderer(this, 169, 0);
        this.Head.setRotationPoint(0.0F, -2.2F, -6.0F);
        this.Head.addBox(-4.5F, -2.0F, -9.0F, 9, 9, 9, 0.0F);
        this.setRotateAngle(Head, 0.5009094953223726F, -0.0F, 0.0F);
        this.front = new ModelRenderer(this, 67, 100);
        this.front.setRotationPoint(4.5F, -1.0F, -0.3F);
        this.front.addBox(0.0F, 0.0F, 0.0F, 7, 3, 2, 0.0F);
        this.setRotateAngle(front, 0.136659280431156F, 0.0F, 0.0F);
        this.ToothBL = new ModelRenderer(this, 139, 35);
        this.ToothBL.setRotationPoint(1.49F, 3.6F, -8.0F);
        this.ToothBL.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2, 0.0F);
        this.setRotateAngle(ToothBL, 0.06719517620178168F, 0.0F, 0.0F);
        this.JawB = new ModelRenderer(this, 169, 41);
        this.JawB.setRotationPoint(0.0F, 3.6F, -7.2F);
        this.JawB.addBox(-1.5F, 0.0F, -7.0F, 3, 3, 7, 0.0F);
        this.setRotateAngle(JawB, -0.02809980095710871F, -0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 60, 0);
        this.Body.setRotationPoint(0.0F, 2.0F, 11.0F);
        this.Body.addBox(-6.0F, -3.0F, -11.0F, 12, 11, 16, 0.0F);
        this.thing2 = new ModelRenderer(this, 0, 120);
        this.thing2.setRotationPoint(0.5F, 3.0F, 3.0F);
        this.thing2.addBox(0.0F, 0.0F, 0.0F, 1, 7, 5, 0.0F);
        this.setRotateAngle(thing2, 0.136659280431156F, 0.0F, 0.0F);
        this.ToothBR = new ModelRenderer(this, 149, 35);
        this.ToothBR.setRotationPoint(-2.49F, 3.6F, -8.0F);
        this.ToothBR.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2, 0.0F);
        this.setRotateAngle(ToothBR, 0.06719517620178168F, -0.0F, 0.0F);
        this.Chest = new ModelRenderer(this, 0, 0);
        this.Chest.setRotationPoint(0.0F, 1.0F, -9.0F);
        this.Chest.addBox(-7.0F, -6.0F, -13.0F, 14, 14, 14, 0.0F);
        this.LegLB = new ModelRenderer(this, 0, 65);
        this.LegLB.setRotationPoint(4.0F, 6.0F, 2.0F);
        this.LegLB.addBox(-3.0F, 0.0F, -3.0F, 5, 16, 6, 0.0F);
        this.LegRB = new ModelRenderer(this, 25, 65);
        this.LegRB.setRotationPoint(-4.0F, 6.0F, 2.0F);
        this.LegRB.addBox(-2.0F, 0.0F, -3.0F, 5, 16, 6, 0.0F);
        this.chest = new ModelRenderer(this, 0, 165);
        this.chest.setRotationPoint(4.0F, -2.5F, 9.0F);
        this.chest.addBox(0.0F, 0.0F, 0.0F, 8, 7, 8, 0.0F);
        this.setRotateAngle(chest, 0.136659280431156F, 0.0F, 0.0F);
        this.ToothR = new ModelRenderer(this, 150, 45);
        this.ToothR.setRotationPoint(0.02F, 4.3F, 0.7F);
        this.ToothR.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(ToothR, 0.27314402793711257F, -0.0F, 0.0F);
        this.Head.addChild(this.EarR);
        this.thing2.addChild(this.legplace2);
        this.Head.addChild(this.EarL);
        this.thing1.addChild(this.legplace1);
        this.Chest.addChild(this.LegLF);
        this.Head.addChild(this.JawU);
        this.Chest.addChild(this.Neck);
        this.saddle.addChild(this.thing1);
        this.Chest.addChild(this.LegRF);
        this.ToothBL.addChild(this.ToothL);
        this.Body.addChild(this.Tail);
        this.Neck.addChild(this.Head);
        this.saddle.addChild(this.front);
        this.JawU.addChild(this.ToothBL);
        this.Head.addChild(this.JawB);
        this.saddle.addChild(this.thing2);
        this.JawU.addChild(this.ToothBR);
        this.Body.addChild(this.Chest);
        this.Body.addChild(this.LegLB);
        this.Body.addChild(this.LegRB);
        this.saddle.addChild(this.chest);
        this.ToothBR.addChild(this.ToothR);
        
        
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float scale) { 
        super.render(entity, f, f1, f2, f3, f4, scale);
        setRotationAngles(f, f1, f2, f3, f4, scale, entity);
        if (this.isChild){
            float z = 0.4F;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0, 0.85, 0);
            GlStateManager.scale(z, z, z);
            GlStateManager.translate(0.0F, scale, 0.0F);
            Body.render(scale);	
            saddle.render(scale);
            GlStateManager.popMatrix();
        }else{
            float z = 0.8F;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0, 0.25, 0);
            GlStateManager.scale(z, z, z);
            GlStateManager.translate(0.0F, scale, 0.0F);
            GlStateManager.translate(0.0F, 0.0F, -0.2F);
            Body.render(scale);	
            saddle.render(scale);
            GlStateManager.popMatrix();
            EntitySmilodonPopulator e = (EntitySmilodonPopulator) entity;
            if(e.isSaddled()){
                
            }
        }
    }

   @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity){
	float swingamt = 0.8F;
        this.LegRB.rotateAngleX = MathHelper.cos(f * 0.6662F) * swingamt * f1;
        this.LegLB.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1F * f1;
        this.LegRF.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1F * f1;
        this.LegLF.rotateAngleX = MathHelper.cos(f * 0.6662F) * swingamt * f1;
    }
    
    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    /**
    * Used for easily adding entity-dependent animations. The second and third float params here are the same second
    * and third as in the setRotationAngles method.
    */
    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float p_78086_2_, float p_78086_3_, float partialTickTime)
    {
        EntitySmilodonPopulator entity = (EntitySmilodonPopulator)entitylivingbaseIn;

        if (entity.isSitting()){
            
        }else{
            
        }
    }
}
