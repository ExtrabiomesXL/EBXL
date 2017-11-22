package com.extrabiomes.ebxl.biomes;

import java.util.List;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.config.BiomeSettings;
import com.google.common.collect.Lists;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager.BiomeType;

public abstract class ExtraBiome extends Biome {

	public static BiomeType DEFAULT_TYPE = BiomeType.WARM;
	public BiomeType type = DEFAULT_TYPE;
	
	public final List<BiomeDictionary.Type> dictTypes = Lists.newArrayList();
	
	public ExtraBiome(BiomeSettings settings, BiomeProperties props) {
		super(props);
		this.setRegistryName(Extrabiomes.MODID, settings.name());
	}

}
