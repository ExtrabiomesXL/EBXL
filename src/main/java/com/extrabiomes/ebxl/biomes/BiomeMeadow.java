package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.init.Biomes;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeMeadow extends ExtraBiome {

	public static BiomeProperties props = new BiomeProperties("Meadow");
	static {
		props.setBaseHeight(0.1F);
		props.setHeightVariation(0.03125F);
		props.setTemperature(Biomes.PLAINS.getTemperature());
		props.setRainfall(Biomes.PLAINS.getRainfall());
	}
	
	public BiomeMeadow(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.COOL;
		
		// In 1.7 was: PLAINS
		dictTypes.add(Type.LUSH);
		dictTypes.add(Type.PLAINS);
		
		this.setFoliageColor(1.0, 1.0);
		this.setGrassColor(1.0, 1.0);
		
		spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 6, 2, 6));
	}

}
