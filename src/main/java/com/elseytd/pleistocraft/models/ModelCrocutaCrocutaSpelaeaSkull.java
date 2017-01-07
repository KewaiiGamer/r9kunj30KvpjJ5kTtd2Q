package com.elseytd.pleistocraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCrocutaCrocutaSpelaeaSkull extends ModelBase {

	ModelRenderer Head;
    ModelRenderer Snout;
    ModelRenderer Jaw;
  
  public ModelCrocutaCrocutaSpelaeaSkull()
  {
	      textureWidth = 128;
	      textureHeight = 128;
	    
	      Head = new ModelRenderer(this, 0, 0);
	      Head.addBox(0F, 0F, 0F, 7, 7, 6);
	      Head.setRotationPoint(-3.5F, 16F, 1F);
	      Head.setTextureSize(128, 128);
	      Head.mirror = true;
	      setRotation(Head, -0.1024477F, 0F, 0F);
	      Snout = new ModelRenderer(this, 88, 26);
	      Snout.addBox(0F, 0F, 0F, 4, 4, 5);
	      Snout.setRotationPoint(-2F, 17.8F, -3F);
	      Snout.setTextureSize(128, 128);
	      Snout.mirror = true;
	      setRotation(Snout, 0.0462667F, 0F, 0F);
	      Jaw = new ModelRenderer(this, 0, 13);
	      Jaw.addBox(0F, 0F, 0F, 4, 1, 4);
	      Jaw.setRotationPoint(-2F, 22F, -2F);
	      Jaw.setTextureSize(128, 128);
	      Jaw.mirror = true;
	      setRotation(Jaw, 0.0090881F, 0F, 0F);
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
