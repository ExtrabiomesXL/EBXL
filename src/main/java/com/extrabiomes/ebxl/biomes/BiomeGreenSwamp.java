package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeGreenSwamp extends ExtraBiome {

	public BiomeGreenSwamp(BiomeSettings settings) {
		super(settings);
		this.type = BiomeType.WARM;
	}

}
