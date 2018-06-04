package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.blocks.ExtraBlocks;
import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.init.Biomes;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

/**
 * The biome formerly known as Mountain Ridge or Redrock Ridge...
 */

public class BiomeRedRockDesert extends ExtraBiome {

	public static BiomeProperties props = new BiomeProperties("Red Rock Desert");
	static {
		// NB: I had a todo note in 1.7 to validate these height numbers
		props.setBaseHeight(1.7F);
		props.setHeightVariation(-0.1F);
		props.setTemperature(Biomes.DESERT_HILLS.getDefaultTemperature());
		props.setRainfall(Biomes.DESERT_HILLS.getRainfall());
		props.setRainDisabled();
	}

	public BiomeRedRockDesert(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.DESERT;
		
		// setColor(0xC4722F);

		// In 1.7 was: MOUNTAIN | SANDY
		dictTypes.add(Type.HOT);
		dictTypes.add(Type.SPARSE);
		dictTypes.add(Type.DRY);
		dictTypes.add(Type.MESA);
		
		spawnableCreatureList.clear();
	    spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 3, 1, 3));
	    
	    this.topBlock = ExtraBlocks.redrock.getDefaultState();
	    this.fillerBlock = ExtraBlocks.redrock.getDefaultState();
	}

}
