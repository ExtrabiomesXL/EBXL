package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class ExtraBiome extends Biome {

	public static BiomeProperties props = new BiomeProperties("extra");
	
	public static BiomeType DEFAULT_TYPE = BiomeType.WARM;
	public BiomeType type = DEFAULT_TYPE;
	
	static {
		props.setTemperature(Biomes.DESERT.getTemperature());
		props.setRainfall(Biomes.FOREST.getRainfall());
		props.setBaseHeight(Biomes.FOREST.getBaseHeight());
		props.setHeightVariation(Biomes.FOREST.getHeightVariation());
	}
	
	public ExtraBiome(BiomeSettings settings) {
		super(props);
		this.setRegistryName(Extrabiomes.MODID, settings.name());
	}

}
