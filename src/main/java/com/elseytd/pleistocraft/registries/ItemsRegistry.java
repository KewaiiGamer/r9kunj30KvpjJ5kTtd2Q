package com.elseytd.pleistocraft.registries;

import com.elseytd.pleistocraft.Main;
import com.elseytd.pleistocraft.items.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

//Referenced in CommonProxy in PreInt

public final class ItemsRegistry {
		
	//Don't forget to render ;)
	
	//Food
	public static Item cooked_smilodon_meat;
	public static Item raw_smilodon_meat;
	//Misc
	public static Item asphalt_crumbs;
	public static Item asphalt_fossil;
	public static Item frozen_animal_tissue;
	public static ItemSmilodonPopulatorFang smilodon_populator_fang1;
	public static ToolSmilodonPopulatorFangSword smilodon_populator_fang_sword1;
	public static ItemSmilodonPopulatorSkull smilodon_populator_skull1;
	public static ItemHomotheriumSerumSkull homotherium_serum_skull1;
	public static ItemPantheraAtroxSkull panthera_atrox_skull1;
	public static ItemPantheraTigrisAltaicaSkull panthera_tigris_altaica_skull1;
	public static ItemPantheraSpelaeaSkull panthera_spelaea_skull1;
	public static ItemCrocutaCrocutaSpelaeaSkull crocuta_crocuta_spelaea_skull1;
	public static ItemCanisDirusSkull canis_dirus_skull1;

	public static Item smilodon_populator_fang;
	public static Item smilodon_populator_fang_sword;
	public static Item smilodon_populator_skull;
	public static Item homotherium_serum_skull;
	public static Item panthera_atrox_skull;
	public static Item panthera_tigris_altaica_skull;
	public static Item panthera_spelaea_skull;
	public static Item crocuta_crocuta_spelaea_skull;
	public static Item canis_dirus_skull;

	
    public static final void init() {
    	
    	//EX: GameRegistry.registerItem(VARIABLENAME = new CLASSNAME(VARIABLES), "VARIABLENAME");

    	GameRegistry.registerItem(cooked_smilodon_meat = new FoodCookedSmilodonMeat(8,true,"cooked_smilodon_meat"), "cooked_smilodon_meat");
    	GameRegistry.registerItem(raw_smilodon_meat = new FoodRawSmilodonMeat(1,true,"raw_smilodon_meat"), "raw_smilodon_meat");
    	GameRegistry.registerItem(asphalt_crumbs = nonspecial("asphalt_crumbs", asphalt_crumbs), "asphalt_crumbs");
    	GameRegistry.registerItem(asphalt_fossil = nonspecial("asphalt_fossil", asphalt_fossil), "asphalt_fossil");
    	GameRegistry.registerItem(frozen_animal_tissue = nonspecial("frozen_animal_tissue", frozen_animal_tissue), "frozen_animal_tissue");
    	GameRegistry.registerItem(smilodon_populator_fang = nonspecial("smilodon_populator_fang", smilodon_populator_fang), "smilodon_populator_fang");
    	GameRegistry.registerItem(smilodon_populator_fang_sword = new ToolSmilodonPopulatorFangSword("smilodon_populator_fang_sword"), "smilodon_populator_fang_sword");
    	GameRegistry.registerItem(smilodon_populator_skull = new ItemSmilodonPopulatorSkull("smilodon_populator_skull"), "smilodon_populator_skull");
    	GameRegistry.registerItem(homotherium_serum_skull = new ItemHomotheriumSerumSkull("homotherium_serum_skull"), "homotherium_serum_skull");
    	GameRegistry.registerItem(panthera_atrox_skull = new ItemPantheraAtroxSkull("panthera_atrox_skull"), "panthera_atrox_skull");
    	GameRegistry.registerItem(panthera_tigris_altaica_skull = new ItemPantheraTigrisAltaicaSkull("panthera_tigris_altaica_skull"), "panthera_tigris_altaica_skull");
    	GameRegistry.registerItem(panthera_spelaea_skull = new ItemPantheraSpelaeaSkull("panthera_spelaea_skull"), "panthera_spelaea_skull");
    	GameRegistry.registerItem(crocuta_crocuta_spelaea_skull = new ItemCrocutaCrocutaSpelaeaSkull("crocuta_crocuta_spelaea_skull"), "crocuta_crocuta_spelaea_skull");
    	GameRegistry.registerItem(canis_dirus_skull = new ItemCanisDirusSkull("canis_dirus_skull"), "canis_dirus_skull");

    	//smilodon_populator_fang_sword1 = new ToolSmilodonPopulatorFangSword("smilodon_populator_fang_sword");
    }
    
    /**
     * A little thing to register an non-special items (Example- a item that is only used for crafting) or doesn't need a class
     * @param name unlocalized name
     * @param i	item variable
     * @return item to gameregistry.registeritem
     */
    public static Item nonspecial(String name, Item i){
    	return new Item().setUnlocalizedName(name).setCreativeTab(Main.PleistoCraft);
    }

}	