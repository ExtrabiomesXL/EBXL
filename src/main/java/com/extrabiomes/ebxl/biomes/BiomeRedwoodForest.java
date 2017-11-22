package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeRedwoodForest extends ExtraBiome {

	public BiomeRedwoodForest(BiomeSettings settings) {
		super(settings);
		this.type = BiomeType.COOL;
	}

}
