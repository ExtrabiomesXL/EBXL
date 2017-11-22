package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.init.Biomes;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeWasteland extends ExtraBiome {

	public static BiomeProperties props = new BiomeProperties("Wasteland");
	static {
		props.setBaseHeight(Biomes.DESERT.getBaseHeight());
		props.setHeightVariation(Biomes.DESERT.getHeightVariation());
		props.setTemperature(Biomes.DESERT.getTemperature());
		props.setRainfall(Biomes.DESERT.getRainfall());
		props.setRainDisabled();
	}

	public BiomeWasteland(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.DESERT;
	}

}