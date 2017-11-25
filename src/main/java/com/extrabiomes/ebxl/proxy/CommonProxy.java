package com.extrabiomes.ebxl.proxy;

import org.apache.logging.log4j.Logger;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.config.Config;
import com.extrabiomes.ebxl.handlers.BiomeHandler;
import com.extrabiomes.ebxl.handlers.BlockHandler;
import com.extrabiomes.ebxl.handlers.ConfigHandler;
import com.extrabiomes.ebxl.handlers.ItemHandler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonProxy {
	protected static Logger log;
	public static Config config;

	public void preInit(FMLPreInitializationEvent event) {
		log = Extrabiomes.log;
		log.info("** proxy.preInit");
		ConfigHandler.init(event);
	}

	public void init(FMLInitializationEvent event) {
		log.info("** proxy.init");
	}

	public void postInit(FMLPostInitializationEvent event) {
		log.info("** proxy.postInit");
		ConfigHandler.postInit();
	}
	
	@SubscribeEvent
	public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
		Config.flush();
	}

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	log.info("** proxy.registerBlocks");
    	BlockHandler.init(event);
    	BiomeHandler.registerAllBiomes();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	log.info("** proxy.registerItems");
    	ItemHandler.init(event);
    }

}
