package com.extrabiomes.ebxl.biomes;

import com.extrabiomes.ebxl.config.BiomeSettings;

import net.minecraft.init.Biomes;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeWasteland extends ExtraBiome {

	public static BiomeProperties props = new BiomeProperties("Wasteland");
	static {
		props.setBaseHeight(0.1F);
		props.setHeightVariation(0.0F);
		props.setTemperature(Biomes.DESERT.getTemperature());
		props.setRainfall(Biomes.DESERT.getRainfall());
		props.setRainDisabled();
	}

	public BiomeWasteland(BiomeSettings settings) {
		super(settings, props);
		this.type = BiomeType.DESERT;
		
		// setColor(0x9E7C41);
		// waterColorMultiplier = 0xF08000;

		// In 1.7 was: WASTELAND
		dictTypes.add(Type.HOT);
		dictTypes.add(Type.SPARSE);
		dictTypes.add(Type.DRY);
		dictTypes.add(Type.DEAD);
		dictTypes.add(Type.WASTELAND);
		
		spawnableCreatureList.clear();
	}

}
