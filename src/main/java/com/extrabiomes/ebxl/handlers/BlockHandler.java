package com.extrabiomes.ebxl.handlers;

import com.extrabiomes.ebxl.blocks.*;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockHandler {

	public static void init(Register<Block> event) {
		final IForgeRegistry<Block> reg = event.getRegistry();
		// TODO: figure out GameRegistry.ObjectHolder interactions
		reg.register(new BlockRedRock());
	}

}
