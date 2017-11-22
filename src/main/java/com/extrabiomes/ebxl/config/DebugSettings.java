package com.extrabiomes.ebxl.config;

public enum DebugSettings {
	DUMP_BIOMES;
	
	public Object value = null;
	
	public boolean getBoolean() {
		try {
			return (Boolean)value;
		} catch( Exception e ) {
			return false;
		}
	}
}
