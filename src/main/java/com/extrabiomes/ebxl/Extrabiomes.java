package com.extrabiomes.ebxl;

import net.minecraft.creativetab.CreativeTabs;
import org.apache.logging.log4j.Logger;

import com.extrabiomes.ebxl.config.DebugSettings;
import com.extrabiomes.ebxl.proxy.CommonProxy;

import net.minecraftforge.common.BiomeDictionary;
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
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		log.trace("postInit");
		proxy.postInit(event);
		
		if( DebugSettings.DUMP_BIOMES.getBoolean() ) {
			dumpAllBiomes();
		}
	}

	public static final CreativeTabs creativeTab = new CreativeTabExtraBiomes(MODID);
	
	/**
	 * Dump a list of all loaded biomes and their type enums to
	 */
	public static void dumpAllBiomes() {
		for( BiomeType type : BiomeType.values() ) {
			log.info(type+" -----");
			for( BiomeEntry entry : BiomeManager.getBiomes(type) ) {
				log.info("  "+entry.biome.getRegistryName()+" ("+entry.biome.getClass()+") : "+ entry.itemWeight);
				final StringBuilder str = new StringBuilder("    -");
				for( BiomeDictionary.Type dictType : BiomeDictionary.getTypes(entry.biome) ) {
					str.append(" "+dictType);
				}
				log.info(str.toString());
			}
		}
	}
}
