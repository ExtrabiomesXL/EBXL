package com.extrabiomes.ebxl.config;

import com.extrabiomes.ebxl.biomes.*;

import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public enum BiomeSettings {
/* @formatter:off */
	AUTUMNWOODS		(BiomeAutumnWoods.class),
	GREENHILLS		(BiomeGreenHills.class,		Weights.LIGHT),
	GREENSWAMP		(BiomeGreenSwamp.class),
	MEADOW			(BiomeMeadow.class,			Weights.HEAVY),
	RAINFOREST		(BiomeRainforest.class,		Weights.HEAVY),
	REDROCKDESERT	(BiomeRedRockDesert.class),
	REDWOODFOREST	(BiomeRedwoodForest.class,	Weights.LIGHT),
	WASTELAND		(BiomeWasteland.class,		Weights.LIGHT),
	WOODLANDS		(BiomeWoodlands.class,		Weights.HEAVY);
/* @formatter:on */
	
	public final Class<?extends ExtraBiome> biomeClass;
	
	public ExtraBiome biome;
	public boolean enabled = true;
	public int weight;
	
	public enum Weights {
		NONE(0), LIGHT(5), NORMAL(10), HEAVY(20);

		public final int value;

		Weights(int value) {
			this.value = value;
		}
	}
	
	private BiomeSettings( Class<?extends ExtraBiome> clazz, Weights weight ) {
		this.biomeClass = clazz;
		this.weight = weight.value;
	}
	private BiomeSettings( Class<?extends ExtraBiome> clazz ) {
		this( clazz, Weights.NORMAL );
	}
	
	public ExtraBiome init() throws Exception {
		if( this.enabled ) {
			biome = biomeClass.getConstructor(this.getClass()).newInstance(this);
		}
		return biome;
	}
	
	public BiomeEntry getBiomeEntry() {
		return new BiomeEntry(biome, getWeight());
	}

	public int getWeight() { return weight; }
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public BiomeType getBiomeType() {
		if( biome == null ) {
			return ExtraBiome.DEFAULT_TYPE;
		} else {
			return biome.type;
		}
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
