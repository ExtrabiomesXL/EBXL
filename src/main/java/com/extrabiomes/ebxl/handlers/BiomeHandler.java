package com.extrabiomes.ebxl.handlers;

import com.extrabiomes.ebxl.biomes.ExtraBiome;
import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeHandler {

	public static void registerBiome(BiomeSettings settings) {
		Biome biome = new ExtraBiome(settings);	// TODO: instantiate the correct class instead
		ForgeRegistries.BIOMES.register(biome);
		
		// TODO: register dictionary types
		
		BiomeManager.addBiome(settings.getBiomeType(), new BiomeEntry(biome,settings.getWeight()));
	}

}
