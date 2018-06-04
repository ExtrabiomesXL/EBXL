package com.extrabiomes.ebxl.biomes;

import java.util.Random;

import com.extrabiomes.ebxl.config.BiomeSettings;
import com.extrabiomes.ebxl.gen.WorldGenAutumnTree;

import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Biomes;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeAutumnWoods extends ExtraBiome {
	
	public static WorldGenAutumnTree treeGen = new WorldGenAutumnTree(false);

	public static BiomeProperties props = new BiomeProperties("Autumn Woods");
	static {
		props.setBaseHeight(0.5F);
		props.setHeightVariation(0.4F);
		props.setTemperature(Biomes.PLAINS.getDefaultTemperature());
		props.setRainfall(Biomes.PLAINS.getRainfall());
		props.setSnowEnabled();
	}
		
	public BiomeAutumnWoods(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.COOL;
		
		// this is a light orange...
		// setColor(0xF29C11);
		
		// In 1.7 was: FOREST
		dictTypes.add(Type.COLD);
		dictTypes.add(Type.DENSE);
		dictTypes.add(Type.FOREST);
		
		this.setFoliageColor(1.0, 0.1);
		this.setGrassColor(1.0, 0.1);
		
		spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
	}

	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		return treeGen;
	}
}
