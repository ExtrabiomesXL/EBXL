package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeMeadow extends ExtraBiome {

	public BiomeMeadow(BiomeSettings settings) {
		super(settings);
		this.type = BiomeType.COOL;
	}

}
