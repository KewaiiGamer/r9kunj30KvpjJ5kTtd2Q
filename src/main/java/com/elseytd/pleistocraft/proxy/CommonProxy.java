package com.elseytd.pleistocraft.proxy;

//import com.elseytd.pleistocraft.event.EventOnEntityCreated;

import com.elseytd.pleistocraft.registries.BlocksRegistry;
import com.elseytd.pleistocraft.registries.CraftingRegistry;
import com.elseytd.pleistocraft.registries.EntitiesRegistry;
import com.elseytd.pleistocraft.registries.ItemsRegistry;
import com.elseytd.pleistocraft.world.PermafrostWorldGenerator;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
    	ItemsRegistry.init();
    	BlocksRegistry.init();
    }

    public void init(FMLInitializationEvent e) {
    	EntitiesRegistry.init();
    	CraftingRegistry.init();
    	GameRegistry.registerWorldGenerator(new PermafrostWorldGenerator(), 1);
        //MinecraftForge.EVENT_BUS.register(new EventOnEntityCreated());
    }
	
    public void postInit(FMLPostInitializationEvent e) {
    }
}