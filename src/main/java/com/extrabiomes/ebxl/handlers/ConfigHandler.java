package com.extrabiomes.ebxl.handlers;

import com.extrabiomes.ebxl.config.BiomeSettings;
import com.extrabiomes.ebxl.config.Config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {
	
	private static final int CONFIG_LEVEL = 0;
	
	public static void init(FMLPreInitializationEvent event) {
		Configuration cfgfile = Config.init(event.getSuggestedConfigurationFile());
		initGeneral(cfgfile);
		initBiomes(cfgfile);
	}

	public static void postInit() {
		// make sure any changes made during load persist
		Config.flush();
	}
	
	private static final String CATEGORY_GENERAL = Configuration.CATEGORY_GENERAL;
	private static void initGeneral(Configuration cfgfile) {
		// track mod config level in case of potential future upgrade needs
		/** 
		 * This is likely -way- overkill these days, but it's a habit I carry over
		 * from the old world, and it's harmless enough to stub in for now. -al [2017.11.12]
		 */
		int configLevel = cfgfile.getInt("config.level", CATEGORY_GENERAL, CONFIG_LEVEL, 0, CONFIG_LEVEL, "Internal format version of EBXL config");
		switch( configLevel ) {
			case CONFIG_LEVEL:
				// no more changes to be made
				break;
		}
	}
	
	private static final String CATEGORY_BIOMES = "biomes";
	private static void initBiomes(Configuration cfgfile) {
		// init the list of biomes :)
		for( BiomeSettings settings : BiomeSettings.values() ) {
			String biome = settings.name().toLowerCase();
			settings.setEnabled(cfgfile.getBoolean(biome+".enabled", CATEGORY_BIOMES, settings.enabled, biome));			
			BiomeHandler.registerBiome(settings);
			// Config.addBiome(settings);
		}
	}

}
