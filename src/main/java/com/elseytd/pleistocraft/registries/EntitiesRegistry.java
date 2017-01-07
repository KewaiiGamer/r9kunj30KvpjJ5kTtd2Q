package com.elseytd.pleistocraft.registries;

import java.util.Random;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.elseytd.pleistocraft.Main;
import com.elseytd.pleistocraft.blocks.entities.TileEntitySmilodonPopulatorSkull;
import com.elseytd.pleistocraft.blocks.entities.TileEntityCanisDirusSkull;
import com.elseytd.pleistocraft.blocks.entities.TileEntityCrocutaCrocutaSpelaeaSkull;
import com.elseytd.pleistocraft.blocks.entities.TileEntityHomotheriumSerumSkull;
import com.elseytd.pleistocraft.blocks.entities.TileEntityPantheraAtroxSkull;
import com.elseytd.pleistocraft.blocks.entities.TileEntityPantheraSpelaeaSkull;
import com.elseytd.pleistocraft.blocks.entities.TileEntityPantheraTigrisAltaicaSkull;
import com.elseytd.pleistocraft.entitys.EntitySmilodonPopulator;


public class EntitiesRegistry {
	
	public static void init(){
		registerEntities(EntitySmilodonPopulator.class, "Smilodon_Populator", 10782798, 8351561);
		GameRegistry.registerTileEntity(TileEntitySmilodonPopulatorSkull.class, "TileEntitySmilodonPopulatorSkulls");
		GameRegistry.registerTileEntity(TileEntityHomotheriumSerumSkull.class, "TileEntityHomotheriumSkulls");
		GameRegistry.registerTileEntity(TileEntityPantheraAtroxSkull.class, "TileEntityPantheraAtroxSkulls");
		GameRegistry.registerTileEntity(TileEntityPantheraTigrisAltaicaSkull.class, "TileEntityPantheraTigrisAltaicaSkulls");
		GameRegistry.registerTileEntity(TileEntityPantheraSpelaeaSkull.class, "TileEntityPantheraSpelaeaSkulls");
		GameRegistry.registerTileEntity(TileEntityCrocutaCrocutaSpelaeaSkull.class, "TileEntityCrocutaCrocutaSpelaeaSkulls");
		GameRegistry.registerTileEntity(TileEntityCanisDirusSkull.class, "TileEntityCanisDirusSkulls");
	}
	
	@SuppressWarnings("deprecation")
	public static void registerEntities(Class entityClass, String name, int maincolor, int subcolor){
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = name.hashCode();
		Random random = new Random(x);
		
		//EntityRegistry.addSpawn(entityClass, 5, 1, 1, EnumCreatureType.CREATURE, BiomeGenBase.forest, BiomeGenBase.coldTaiga);
		
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.registerModEntity(entityClass, name, entityId, Main.instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, maincolor, subcolor));
	}
}
