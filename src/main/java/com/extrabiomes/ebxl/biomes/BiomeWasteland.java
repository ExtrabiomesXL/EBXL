package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeWasteland extends ExtraBiome {

	public BiomeWasteland(BiomeSettings settings) {
		super(settings);
		this.type = BiomeType.DESERT;
	}

}
