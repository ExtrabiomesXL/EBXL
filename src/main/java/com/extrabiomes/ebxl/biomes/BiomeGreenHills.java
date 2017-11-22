package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeGreenHills extends ExtraBiome {

	public BiomeGreenHills(BiomeSettings settings) {
		super(settings);
		this.type = BiomeType.WARM;
	}

}
