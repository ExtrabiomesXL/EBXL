package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.init.Biomes;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

/**
 * The biome formerly known as Mountain Ridge or Redrock Ridge...
 */

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

		// In 1.7 was: MOUNTAIN | DESERT
		dictTypes.add(Type.HOT);
		dictTypes.add(Type.SPARSE);
		dictTypes.add(Type.DRY);
		dictTypes.add(Type.MESA);
	}

}
