package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.init.Biomes;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeRedwoodForest extends ExtraBiome {

	public static BiomeProperties props = new BiomeProperties("Redwood Forest");
	static {
		props.setBaseHeight(Biomes.FOREST.getBaseHeight());
		props.setHeightVariation(Biomes.FOREST_HILLS.getHeightVariation());
		props.setTemperature(Biomes.FOREST_HILLS.getTemperature());
		props.setRainfall(Biomes.FOREST_HILLS.getRainfall());
		props.setSnowEnabled();
	}

	public BiomeRedwoodForest(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.COOL;

		// In 1.7 was: FOREST | HILLS
		dictTypes.add(Type.COLD);
		dictTypes.add(Type.SPARSE);
		dictTypes.add(Type.FOREST);
		dictTypes.add(Type.CONIFEROUS);
		dictTypes.add(Type.HILLS);
		dictTypes.add(Type.SNOWY);
	}

}
