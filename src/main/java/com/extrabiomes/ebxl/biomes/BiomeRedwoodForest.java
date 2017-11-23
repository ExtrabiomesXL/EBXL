package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeRedwoodForest extends ExtraBiome {

	public static BiomeProperties props = new BiomeProperties("Redwood Forest");
	static {
		props.setBaseHeight(1.2F);
		props.setHeightVariation(0.3F);
		props.setTemperature(1.1F);
		props.setRainfall(1.4F);
	}

	public BiomeRedwoodForest(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.WARM;

		// setColor(0x0BD626);
		
		// In 1.7 was: FOREST | HILLS
		dictTypes.add(Type.SPARSE);
		dictTypes.add(Type.FOREST);
		dictTypes.add(Type.CONIFEROUS);
		dictTypes.add(Type.HILLS);
	}

}
