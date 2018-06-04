package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Biomes;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeGreenSwamp extends ExtraBiome {

	public static BiomeProperties props = new BiomeProperties("Green Swamp");
	static {
		props.setBaseHeight(0.05F);
		props.setHeightVariation(0.15F);
		props.setTemperature(Biomes.SWAMPLAND.getDefaultTemperature() - 0.1F);
		props.setRainfall(Biomes.SWAMPLAND.getRainfall());
	}
	
	public BiomeGreenSwamp(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.WARM;
		
		// In 1.7 was: SWAMP | WATER
		dictTypes.add(Type.WET);
		dictTypes.add(Type.SWAMP);
		// dictTypes.add(Type.WATER);
		
		// setColor(0x68C474);
		
		spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 1, 1, 1));
	}
	
	// TODO: look at importing canSpawnEvent handler for slimes

}
