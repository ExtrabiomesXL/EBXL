package com.extrabiomes.ebxl.config;

import java.util.Map;

import com.google.common.collect.Maps;

public enum DecorationSettings {
/* @formatter:off */
	//	 			 lily, tree, flow, gras, dead, mush, reed, cact, sand, grvl, clay, bigm, nFlw
	AUTUMNWOODS		(null, 6,    null, 6,    null, 3,    null, null, null, null, null, null, 5   ),
	GREENHILLS		(null, 1,    null, null, null, null, null, null, null, null, null, null, 5   ),
	GREENSWAMP		(4,    4,    null, null, 0,    8,    10,   null, 0,    0,    1,    null, 6   ),
	MEADOW			(null, 0,    2,    12,   null, null, null, null, null, null, null, null, 8   ),
	REDROCKDESERT	(null, 0,    null, 12,   null, null, null, null, null, null, null, null, null),
	REDWOODFOREST	(null, 7,    null, null, null, null, null, null, null, null, null, null, null),
	WASTELAND		(null, null, null, 1,    3,    null, null, null, null, null, null, null, null),
	WOODLANDS		(null, 8,    null, 3,    null, null, null, null, null, null, null, null, 6   ),
	//				 lily, tree, flow, gras, dead, mush, reed, cact, sand, grvl, clay, bigm, nFlw
	DEFAULT();
/* @formatter:on */
	
	public enum Decoration {
/* @formatter:off */
		WATERLILY	(".waterlily",	0),
		TREES		(".trees",		0),
		FLOWERS		(".flowers",	0), // was 2, by default we don't want vanilla flowers any more
		GRASS		(".grass",		1),
		DEADBUSH	(".deadBush",	0),
		MUSHROOMS	(".mushrooms",	0),
		REEDS		(".reeds",		0),
		CACTI		(".cacti",		0),
		GRAVEL		(".gravel",		1),
		SAND		(".sand",		3),
		CLAY		(".clay",		1),
		BIGMUSHROOMS(".bigMushrooms", 0),
		NEW_FLOWERS	(".newFlowers",	0);
/* @formatter:on */

		public final String key; // config file key
		public final int def; // default value

		private Decoration(String key, int def) {
			this.key = key;
			this.def = def;
		}
	};
	
	private final Map<Decoration, Integer> settings = Maps.newHashMap();

	private void initSetting(Decoration key, Integer val) {
		// only init if not default
		if( val != null && !val.equals(key.def) ) {
			settings.put(key, val);
		}
	}
	
	private DecorationSettings() {
		this( null,null,null,null,null,null,null,null,null,null,null,null,null );
	}
	private DecorationSettings(Integer waterlily, Integer trees, Integer flowers, Integer grass, Integer deadBush,
			Integer mushrooms, Integer reeds, Integer cacti, Integer sand, Integer gravel, Integer clay,
			Integer bigMushrooms, Integer newFlowers)
	{	
		initSetting(Decoration.WATERLILY, waterlily);
        initSetting(Decoration.TREES, trees);
        initSetting(Decoration.FLOWERS, flowers);
        initSetting(Decoration.GRASS, grass);
        initSetting(Decoration.DEADBUSH, deadBush);
        initSetting(Decoration.MUSHROOMS, mushrooms);
        initSetting(Decoration.REEDS, reeds);
        initSetting(Decoration.CACTI, cacti);
        initSetting(Decoration.SAND, sand);
        initSetting(Decoration.GRAVEL, gravel);
        initSetting(Decoration.CLAY, clay);
        initSetting(Decoration.BIGMUSHROOMS, bigMushrooms);
		initSetting(Decoration.NEW_FLOWERS, newFlowers);
	}
	
	public int get(Decoration decor) {
		if( settings.containsKey(decor) ) {
			return settings.get(decor).intValue();
		} else {
			return decor.def;
		}
	}
	public Map<Decoration, Integer> get() {
		return settings;
	}
}
