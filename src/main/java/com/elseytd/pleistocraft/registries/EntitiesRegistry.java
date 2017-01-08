package com.elseytd.pleistocraft.registries;

import com.elseytd.pleistocraft.Main;
import com.elseytd.pleistocraft.blocks.entities.*;
import com.elseytd.pleistocraft.entitys.EntitySmilodonPopulator;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;


public class EntitiesRegistry {

	static EntityRegistry.EntityRegistration entityRegistration;


	/** This class needs to be cleaned up
	 *
	 */
	public static void init() {
		int id = 1;
		registerEntities(EntitySmilodonPopulator.class, 1513	, "Smilodon_Populator", 10782798, 8351561);
		/*
		EntityRegistry.registerModEntity(EntitySmilodonPopulator.class, "Simlodon_Populator", id++, Main.instance, 64, 3, true, 0x996600, 0x00ff00);
		EntityRegistry.addSpawn(EntitySmilodonPopulator.class, 5, 1, 1, EnumCreatureType.CREATURE, Biomes.PLAINS, Biomes.COLD_TAIGA);
		EntityList.ENTITY_EGGS.put(Integer.toString(id++), new EntityList.EntityEggInfo(Integer.toString(id++), 0x996600 , 0x00ff00));
		*/
		GameRegistry.registerTileEntity(TileEntitySmilodonPopulatorSkull.class, "TileEntitySmilodonPopulatorSkulls");
		GameRegistry.registerTileEntity(TileEntityHomotheriumSerumSkull.class, "TileEntityHomotheriumSkulls");
		GameRegistry.registerTileEntity(TileEntityPantheraAtroxSkull.class, "TileEntityPantheraAtroxSkulls");
		GameRegistry.registerTileEntity(TileEntityPantheraTigrisAltaicaSkull.class, "TileEntityPantheraTigrisAltaicaSkulls");
		GameRegistry.registerTileEntity(TileEntityPantheraSpelaeaSkull.class, "TileEntityPantheraSpelaeaSkulls");
		GameRegistry.registerTileEntity(TileEntityCrocutaCrocutaSpelaeaSkull.class, "TileEntityCrocutaCrocutaSpelaeaSkulls");
		GameRegistry.registerTileEntity(TileEntityCanisDirusSkull.class, "TileEntityCanisDirusSkulls");
	}

	@SuppressWarnings("deprecation")
	public static void registerEntities(Class entityClass, int ID, String name, int maincolor, int subcolor) {

		long x = name.hashCode();
		Random random = new Random(x);

		EntityRegistry.addSpawn(entityClass, 100, 10, 10, EnumCreatureType.CREATURE, Biomes.PLAINS, Biomes.COLD_TAIGA);

		EntityRegistry.registerModEntity(entityClass, name, ID, Main.instance, 64, 1, true);
		EntityRegistry.registerEgg(entityClass, maincolor, subcolor);
		//EntityList.ENTITY_EGGS.put(Integer.toString(ID), new EntityList.EntityEggInfo(Integer.toString(ID), maincolor, subcolor));
	}
}