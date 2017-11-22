package com.extrabiomes.ebxl.handlers;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.biomes.ExtraBiome;
import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeHandler {

	public static void registerBiome(BiomeSettings settings) {
		final ExtraBiome biome;
		try {
			biome = settings.init();
		} catch (Exception e) {
			Extrabiomes.log.error("Unable to init "+settings, e);
			return;
		}
		ForgeRegistries.BIOMES.register(biome);
		
		for( BiomeDictionary.Type type : biome.dictTypes ) {
			BiomeDictionary.addTypes(biome, type);
		}
		
		BiomeManager.addBiome(settings.getBiomeType(), settings.getBiomeEntry());
	}

}
