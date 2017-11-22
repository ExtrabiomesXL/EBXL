package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.init.Biomes;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeWoodlands extends ExtraBiome {

	public static BiomeProperties props = new BiomeProperties("Woodlands");
	static {
		props.setBaseHeight(Biomes.FOREST.getBaseHeight());
		props.setHeightVariation(Biomes.FOREST.getHeightVariation());
		props.setTemperature(Biomes.FOREST.getTemperature());
		props.setRainfall(Biomes.FOREST.getRainfall());
	}
	
	public BiomeWoodlands(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.COOL;
	}

}
