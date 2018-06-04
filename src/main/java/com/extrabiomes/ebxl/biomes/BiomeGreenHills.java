package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.init.Biomes;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeGreenHills extends ExtraBiome {

	public static BiomeProperties props = new BiomeProperties("Green Hills");
	static {
		props.setBaseHeight(0.9F);
		props.setHeightVariation(0.3F);
		props.setTemperature(Biomes.FOREST.getDefaultTemperature() - 0.1F);
		props.setRainfall(Biomes.FOREST.getRainfall() + 0.1F);
	}
	
	public BiomeGreenHills(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.WARM;

		// In 1.7 was: Hills
		dictTypes.add(Type.WET);
		dictTypes.add(Type.LUSH);
		dictTypes.add(Type.HILLS);
		
		// this is a light slightly bluish green
		// setColor(0x68C474);
		
		this.setFoliageColor(0.7, 0.8);
		this.setGrassColor(0.7, 0.8);
	}

}
