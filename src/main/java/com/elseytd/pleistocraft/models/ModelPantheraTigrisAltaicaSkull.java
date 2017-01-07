package com.elseytd.pleistocraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelPantheraTigrisAltaicaSkull extends ModelBase {

	ModelRenderer Head;
    ModelRenderer Snout;
    ModelRenderer Jaw;
  
  public ModelPantheraTigrisAltaicaSkull()
  {     
	  this.textureWidth = 128;
      this.textureHeight = 128;
      
      this.Head = new ModelRenderer(this, 87, 22);
      this.Head.setRotationPoint(-4.0F, 16.0F, 0.0F);
      this.Head.addBox(0.0F, 0.0F, 0.0F, 10, 10, 10, 0.0F);
      this.setRotateAngle(Head, -0.4553564018453205F, -0.0F, 0.0F);
      this.Snout = new ModelRenderer(this, 102, 45);
      this.Snout.setRotationPoint(2.0F, 3.0F, -4.7F);
      this.Snout.addBox(0.0F, 0.0F, 0.0F, 6, 5, 6, 0.0F);
      this.setRotateAngle(Snout, 0.11152653920243764F, -0.0F, 0.0F);
      this.Jaw = new ModelRenderer(this, 76, 46);
      this.Jaw.setRotationPoint(3.0F, 9.7F, -3.6F);
      this.Jaw.addBox(0.0F, 0.0F, 0.0F, 4, 3, 7, 0.0F);
      this.setRotateAngle(Jaw, 0.40980330836826856F, -0.0F, 0.0F);
      this.Head.addChild(this.Snout);
      this.Head.addChild(this.Jaw);
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
