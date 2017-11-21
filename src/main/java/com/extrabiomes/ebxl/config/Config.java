package com.extrabiomes.ebxl.config;

import java.io.File;

import com.extrabiomes.ebxl.Extrabiomes;
import net.minecraftforge.common.config.Configuration;

public enum Config {
	INSTANCE;
	
	// the config file itself
	public Configuration config;
	
	// TODO: store references to different config settings collections
	
	public static Configuration init(File file) {
		INSTANCE._init(file);
		return INSTANCE.config;
	}
	private void _init(File file) {
		config = new Configuration(file);
		try {
			config.load();
		} catch( Exception e ) {
			Extrabiomes.log.error("Unable to init config", e);
		} finally {
			_flush();
		}
	}
	
	public static void flush() {
		INSTANCE._flush();
	}
	private void _flush() {
		if( config.hasChanged() ) {
			config.save();
		}
	}
}
