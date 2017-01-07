package com.elseytd.pleistocraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPantheraSpelaeaSkull extends ModelBase {

	ModelRenderer Head;
    ModelRenderer Snout;
    ModelRenderer Jaw;
  
  public ModelPantheraSpelaeaSkull()
  {
	      textureWidth = 200;
	      textureHeight = 200;
	    
	      Head = new ModelRenderer(this, 0, 35);
	      Head.addBox(-4F, -4F, -8F, 8, 7, 7);
	      Head.setRotationPoint(0F, 21.1F, 8F);
	      Head.setTextureSize(200, 200);
	      Head.mirror = true;
	      setRotation(Head, -0.0911062F, 0F, 0F);
	      Snout = new ModelRenderer(this, 35, 35);
	      Snout.addBox(0F, 0F, 0F, 5, 4, 5);
	      Snout.setRotationPoint(-2.5F, 19.6F, -4.2F);
	      Snout.setTextureSize(200, 200);
	      Snout.mirror = true;
	      setRotation(Snout, 0.1820378F, 0F, 0F);
	      Jaw = new ModelRenderer(this, 35, 48);
	      Jaw.addBox(0F, 0F, 0F, 4, 2, 5);
	      Jaw.setRotationPoint(-2F, 23.1F, -2.7F);
	      Jaw.setTextureSize(200, 200);
	      Jaw.mirror = true;
	      setRotation(Jaw, 0.2275909F, 0F, 0F);
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
