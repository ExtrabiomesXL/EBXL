package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;
import net.minecraft.init.Biomes;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeAutumnWoods extends ExtraBiome {

	public static BiomeProperties props = new BiomeProperties("Autumn Woods");
	static {
		props.setBaseHeight(Biomes.PLAINS.getBaseHeight());
		props.setHeightVariation(Biomes.PLAINS.getHeightVariation());
		props.setTemperature(Biomes.PLAINS.getTemperature());
		props.setRainfall(Biomes.PLAINS.getRainfall());
		props.setSnowEnabled();
	}
		
	public BiomeAutumnWoods(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.COOL;
		
		// In 1.7 was: FOREST
		dictTypes.add(Type.COLD);
		dictTypes.add(Type.DENSE);
		dictTypes.add(Type.FOREST);
	}

}
