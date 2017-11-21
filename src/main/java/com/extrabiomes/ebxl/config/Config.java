package com.extrabiomes.ebxl.config;

import java.io.File;
import java.util.Map;

import com.extrabiomes.ebxl.Extrabiomes;
import com.google.common.collect.Maps;

import net.minecraftforge.common.config.Configuration;

public enum Config {
	INSTANCE;
	
	// the config file itself
	public Configuration config;
	
	public Map<Integer,BiomeSettings> biomes = Maps.newHashMap();
	
	public static Configuration init(File file) {
		INSTANCE._init(file);
		return INSTANCE.config;
	}
	private void _init(File file) {
		config = new Configuration(file);
		try {
			config.load();
		} catch( Exception e ) {
			Extrabiomes.log.error("Unable to init config", e);
		} finally {
			_flush();
		}
	}
	
	public static void flush() {
		INSTANCE._flush();
	}
	private void _flush() {
		if( config.hasChanged() ) {
			config.save();
		}
	}
	
	public static void addBiome(BiomeSettings settings) {
		INSTANCE.biomes.put(settings.getID(), settings);
	}
	public static BiomeSettings getBiome(int id) {
		return INSTANCE.biomes.get(id);
	}
}
