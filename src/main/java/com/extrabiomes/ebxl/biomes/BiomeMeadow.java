package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.init.Biomes;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeMeadow extends ExtraBiome {

	public static BiomeProperties props = new BiomeProperties("Meadow");
	static {
		props.setBaseHeight(Biomes.PLAINS.getBaseHeight());
		props.setHeightVariation(Biomes.PLAINS.getHeightVariation());
		props.setTemperature(Biomes.PLAINS.getTemperature());
		props.setRainfall(Biomes.PLAINS.getRainfall());
	}
	
	public BiomeMeadow(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.COOL;
	}

}
