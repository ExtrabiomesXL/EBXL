package com.extrabiomes.ebxl.config;

import com.extrabiomes.ebxl.biomes.*;

public enum BiomeSettings {
/* @formatter:off */
	AUTUMNWOODS		(BiomeAutumnWoods.class)/*,
	GREENHILLS		(BiomeGreenHills.class),
	GREENSWAMP		(BiomeGreenSwamp.class),
	MEADOW			(BiomeMeadow.class),
	REDROCKDESERT	(BiomeRedRockDesert.class),
	REDWOODFOREST	(BiomeRedwoodForest.class),
	WASTELAND		(BiomeWasteland.class),
	WOODLANDS		(BiomeWoodlands.class)*/;
/* @formatter:on */
	
	public final Class<?extends ExtraBiome> biomeClass;
	public final Weights weight;
	
	public ExtraBiome biome;
	
	private enum Weights {
		NONE(0), LIGHT(5), NORMAL(10), HEAVY(20);

		public final int value;

		Weights(int value) {
			this.value = value;
		}
	}
	
	private BiomeSettings( Class<?extends ExtraBiome> clazz, Weights weight ) {
		this.biomeClass = clazz;
		this.weight = weight;
	}
	private BiomeSettings( Class<?extends ExtraBiome> clazz ) {
		this( clazz, Weights.NORMAL );
	}
	
	public void init() throws Exception {
		biome = biomeClass.newInstance();
	}


	public int getWeight() { return weight.value; }
}
