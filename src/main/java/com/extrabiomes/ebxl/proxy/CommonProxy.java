package com.extrabiomes.ebxl.proxy;

import org.apache.logging.log4j.Logger;

import com.extrabiomes.ebxl.Extrabiomes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonProxy {
	protected static Logger log;

	public void preInit(FMLPreInitializationEvent event) {
		log = Extrabiomes.log;
		log.trace("proxy.preInit");
	}

	public void init(FMLInitializationEvent event) {
		log.trace("proxy.init");
	}

	public void postInit(FMLPostInitializationEvent event) {
		log.trace("proxy.postInit");
	}

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	log.trace("proxy.registerBlocks");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	log.trace("proxy.registerItems");
    }

}
