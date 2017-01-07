package com.elseytd.pleistocraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPantheraAtroxSkull extends ModelBase {

	ModelRenderer Head;
    ModelRenderer Snout;
    ModelRenderer Jaw;
  
  public ModelPantheraAtroxSkull()
  {
	      textureWidth = 769;
	      textureHeight = 538;
	    
	      Head = new ModelRenderer(this, 87, 22);
	      Head.addBox(0F, 0F, 0F, 10, 10, 9);
	      Head.setRotationPoint(-5F, 14F, -1F);
	      Head.setTextureSize(64, 32);
	      Head.mirror = true;
	      setRotation(Head, 0F, 0F, 0F);
	      Snout = new ModelRenderer(this, 102, 45);
	      Snout.addBox(0F, 0F, 0F, 6, 6, 7);
	      Snout.setRotationPoint(-3F, 16.5F, -7.53F);
	      Snout.setTextureSize(64, 32);
	      Snout.mirror = true;
	      setRotation(Snout, 0.1115265F, 0F, 0F);
	      Jaw = new ModelRenderer(this, 76, 46);
	      Jaw.addBox(0F, 0F, 0F, 4, 3, 7);
	      Jaw.setRotationPoint(-2F, 21F, -6F);
	      Jaw.setTextureSize(64, 32);
	      Jaw.mirror = true;
	      setRotation(Jaw, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3,float f4, float f5) {
	  super.render(entity, f, f1, f2, f3, f4, f5);
	  setRotationAngles(f, f1, f2, f3, f4, f5,entity);
      Head.render(f5);
      Snout.render(f5);
      Jaw.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  

}
