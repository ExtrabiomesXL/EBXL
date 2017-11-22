package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeWoodlands extends ExtraBiome {

	public BiomeWoodlands(BiomeSettings settings) {
		super(settings);
		this.type = BiomeType.COOL;
	}

}
