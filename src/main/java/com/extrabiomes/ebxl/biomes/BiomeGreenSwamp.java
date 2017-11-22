package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.init.Biomes;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeGreenSwamp extends ExtraBiome {

	public static BiomeProperties props = new BiomeProperties("Green Swamp");
	static {
		props.setBaseHeight(Biomes.SWAMPLAND.getBaseHeight());
		props.setHeightVariation(Biomes.SWAMPLAND.getHeightVariation());
		props.setTemperature(Biomes.SWAMPLAND.getTemperature());
		props.setRainfall(Biomes.SWAMPLAND.getRainfall());
	}
	
	public BiomeGreenSwamp(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.WARM;
		
		// In 1.7 was: SWAMP | WATER
		dictTypes.add(Type.WET);
		dictTypes.add(Type.SWAMP);
		// dictTypes.add(Type.WATER);
	}

}
