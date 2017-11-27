package com.extrabiomes.ebxl.proxy;

import com.extrabiomes.ebxl.handlers.BlockHandler;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		log.info("client.preInit");
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		log.info("client.registerModels");
		BlockHandler.initModels();
		// ItemHandler.initModels();
	}
}
