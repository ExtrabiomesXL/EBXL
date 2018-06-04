package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.init.Biomes;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeWoodlands extends ExtraBiome {

	public static BiomeProperties props = new BiomeProperties("Woodlands");
	static {
		props.setBaseHeight(0.3F);
		props.setHeightVariation(0.1F);
		props.setTemperature(Biomes.FOREST.getDefaultTemperature());
		props.setRainfall(Biomes.FOREST.getRainfall());
	}
	
	public BiomeWoodlands(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.COOL;
		
		// setColor(0x85B53E);
		
		// In 1.7 was: FOREST
		dictTypes.add(Type.DENSE);
		dictTypes.add(Type.LUSH);
		dictTypes.add(Type.FOREST);
		
		this.setFoliageColor(1.0, 1.0);
		this.setGrassColor(1.0, 1.0);
		
		spawnableCreatureList.add(new SpawnListEntry(net.minecraft.entity.passive.EntityWolf.class, 5, 4, 4));
	}

}
