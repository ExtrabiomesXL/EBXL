package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;

public class ExtraBiome extends Biome {

	public static BiomeProperties props = new BiomeProperties("extra");
	
	static {
		props.setTemperature(Biomes.DESERT.getTemperature());
		props.setRainfall(Biomes.FOREST.getRainfall());
		props.setBaseHeight(Biomes.FOREST.getBaseHeight());
		props.setHeightVariation(Biomes.FOREST.getHeightVariation());
	}
	
	public ExtraBiome(BiomeSettings settings) {
		super(props);
		this.setRegistryName(Extrabiomes.MODID, settings.name());
	}

}
