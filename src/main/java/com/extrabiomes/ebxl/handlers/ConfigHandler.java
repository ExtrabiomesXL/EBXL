package com.extrabiomes.ebxl.handlers;

import java.util.Map;

import com.extrabiomes.ebxl.config.BiomeSettings;
import com.extrabiomes.ebxl.config.Config;
import com.extrabiomes.ebxl.config.DebugSettings;
import com.extrabiomes.ebxl.config.DecorationSettings;
import com.extrabiomes.ebxl.config.DecorationSettings.Decoration;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {
	
	private static final int CONFIG_LEVEL = 0;
	
	public static void init(FMLPreInitializationEvent event) {
		Configuration cfgfile = Config.init(event.getSuggestedConfigurationFile());
		initGeneral(cfgfile);
		initBiomes(cfgfile);
		initDebug(cfgfile);
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
			final String biome = settings.name().toLowerCase();
			settings.setEnabled(cfgfile.getBoolean(biome+".enabled", CATEGORY_BIOMES, settings.enabled, "Does this biome generate?"));
			settings.setWeight(cfgfile.getInt(biome+".weight", CATEGORY_BIOMES, settings.weight, 0, 50, "How common is this biome? 10 is vanilla."));
			initDecorations(settings, cfgfile);
			// BiomeHandler.registerBiome(settings);
			// Config.addBiome(settings);
		}
	}
	private static void initDecorations(BiomeSettings biomeSettings, Configuration cfgfile) {
		final DecorationSettings settings;
		try {
			settings = DecorationSettings.valueOf(biomeSettings.name());
		} catch( Exception e ) {
			return;
		}
		// parse all of a given biome's decoration settings
		final String biome = settings.name().toLowerCase();
		Map<Decoration, Integer> map = settings.get();
		for( Decoration decor : Decoration.values() ) {
			// don't init null properties
			if( !map.containsKey(decor) ) continue;
			final int val = cfgfile.getInt(biome+decor.key, CATEGORY_BIOMES, map.get(decor), 0, 50, "Number of "+biome+decor.key+" to try to generate per chunk" );
			map.put(decor, val);
		}
	}
	
	private static final String CATEGORY_DEBUG = "debug";
	private static void initDebug(Configuration cfgfile) {
		DebugSettings.DUMP_BIOMES.value = cfgfile.getBoolean("dump.biomes", CATEGORY_DEBUG, true, "Dump a list of loaded biomes, types, and weights to log in postInit");
		// TODO: DebugSettings.DUMP_DECORATIONS.value = cfgfile.getBoolean("dump.decorations", CATEGORY_DEBUG, true, "Dump a list of decoration counts per biome");
	}

}
