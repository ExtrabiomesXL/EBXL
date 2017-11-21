package com.extrabiomes.ebxl.config;

public enum BiomeSettings {
/* @formatter:off */
	AUTUMNWOODS		(61),
	GREENHILLS		(67),
	GREENSWAMP		(40),
	MEADOW			(43),
	REDROCKDESERT	(46),
	REDWOODFOREST	(50),
	WASTELAND		(58),
	WOODLANDS		(59);
/* @formatter:on */
	
	public final int defaultID;
	
	private int biomeID;
	
	private BiomeSettings() {
		this(0);
	}
	private BiomeSettings(int defaultID) {
		this.defaultID = defaultID;
		this.biomeID = this.defaultID;
	}
	
	public int getID() { return biomeID; }
	public void setID(int id) { biomeID = id; }
}
