package com.extrabiomes.ebxl.handlers;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeHandler {

	public static void registerBiome(BiomeSettings settings) {
		final Biome biome;
		try {
			biome = settings.init();
		} catch (Exception e) {
			Extrabiomes.log.error("Unable to init "+settings, e);
			return;
		}
		ForgeRegistries.BIOMES.register(biome);
		
		// TODO: register dictionary types
		
		BiomeManager.addBiome(settings.getBiomeType(), settings.getBiomeEntry());
	}

}
