package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.init.Biomes;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeRedRockDesert extends ExtraBiome {

	public static BiomeProperties props = new BiomeProperties("Red Rock Desert");
	static {
		props.setBaseHeight(Biomes.DESERT_HILLS.getBaseHeight());
		props.setHeightVariation(Biomes.DESERT_HILLS.getHeightVariation());
		props.setTemperature(Biomes.DESERT_HILLS.getTemperature());
		props.setRainfall(Biomes.DESERT_HILLS.getRainfall());
		props.setRainDisabled();
	}

	public BiomeRedRockDesert(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.DESERT;
	}

}
