package com.extrabiomes.ebxl;

import org.apache.logging.log4j.Logger;

import com.extrabiomes.ebxl.proxy.CommonProxy;

import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(useMetadata = true, modid = Extrabiomes.MODID)
public class Extrabiomes {
	public static final String MODID = "extrabiomesxl";
	
	@SidedProxy(clientSide = "com.extrabiomes.ebxl.proxy.ClientProxy", 
				serverSide = "com.extrabiomes.ebxl.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@Mod.Instance
	public static Extrabiomes instance;
	
	public static Logger log;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		log = event.getModLog();
		log.trace("preInit");
		proxy.preInit(event);
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		log.trace("init");
		proxy.init(event);
		
		// dump loaded biome list
		for( BiomeType type : BiomeType.values() ) {
			log.info(type);
			for( BiomeEntry entry : BiomeManager.getBiomes(type) ) {
				log.info(entry.biome+" : "+entry.itemWeight);
			}
		}
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		log.trace("postInit");
		proxy.postInit(event);
	}
}
