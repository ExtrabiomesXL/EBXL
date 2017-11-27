package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeRainforest extends ExtraBiome {

	public static BiomeProperties props = new BiomeProperties("Rainforest");
	static {
		props.setBaseHeight(0.85F);
		props.setHeightVariation(0.45F);
		props.setTemperature(1.1F);
		props.setRainfall(1.4F);
		
		props.setWaterColor(0x0BD626);
	}
	
	public BiomeRainforest(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.WARM;
		
		// In 1.7 was: JUNGLE | HILLS
		dictTypes.add(Type.DENSE);
		dictTypes.add(Type.LUSH);
		dictTypes.add(Type.JUNGLE);
		dictTypes.add(Type.HOT);
	}

}
