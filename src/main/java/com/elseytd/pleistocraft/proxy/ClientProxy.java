package com.elseytd.pleistocraft.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.elseytd.pleistocraft.render.Renderer;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent e){
		super.preInit(e);
	}
	@Override
	public void init(FMLInitializationEvent e){
		Renderer.registerItemRenderer();
		super.init(e);
	}
	@Override
	public void postInit(FMLPostInitializationEvent e){
		super.postInit(e);
	}

}
