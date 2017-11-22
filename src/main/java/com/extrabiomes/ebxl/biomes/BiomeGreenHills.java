package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.init.Biomes;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeGreenHills extends ExtraBiome {

	public static BiomeProperties props = new BiomeProperties("Green Hills");
	static {
		props.setBaseHeight(Biomes.EXTREME_HILLS_WITH_TREES.getBaseHeight());
		props.setHeightVariation(Biomes.EXTREME_HILLS_WITH_TREES.getHeightVariation());
		props.setTemperature(Biomes.EXTREME_HILLS_WITH_TREES.getTemperature());
		props.setRainfall(Biomes.EXTREME_HILLS_WITH_TREES.getRainfall());
	}
	
	public BiomeGreenHills(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.WARM;
	}

}
