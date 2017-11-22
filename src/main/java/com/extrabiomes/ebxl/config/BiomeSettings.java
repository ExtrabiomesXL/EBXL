package com.extrabiomes.ebxl.config;

import net.minecraftforge.common.BiomeManager.BiomeType;

public enum BiomeSettings {
/* @formatter:off */
	AUTUMNWOODS		(61,	BiomeType.COOL),
	GREENHILLS		(67,	BiomeType.WARM),
	GREENSWAMP		(40,	BiomeType.WARM),
	MEADOW			(43,	BiomeType.COOL),
	REDROCKDESERT	(46,	BiomeType.DESERT),
	REDWOODFOREST	(50,	BiomeType.COOL),
	WASTELAND		(58,	BiomeType.DESERT),
	WOODLANDS		(59,	BiomeType.COOL);
/* @formatter:on */
	
	public final int defaultID;
	
	private int biomeID;
	private BiomeType type;
	private int weight;
	
	private BiomeSettings(int defaultID, BiomeType type) {
		this(defaultID, type, 10);
	}
	private BiomeSettings(int defaultID, BiomeType type, int weight) {
		this.defaultID = defaultID;
		this.biomeID = this.defaultID;
		this.type = type;
		this.weight = weight;
	}
	
	public int getID() { return biomeID; }
	public void setID(int id) { biomeID = id; }
	
	public BiomeType getBiomeType() { return type; }
	
	public int getWeight() { return weight; }
}
