package com.extrabiomes.ebxl.handlers;

import com.extrabiomes.ebxl.blocks.*;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockHandler {

	public static void init(Register<Block> event) {
		final IForgeRegistry<Block> reg = event.getRegistry();
		// TODO: figure out GameRegistry.ObjectHolder interactions
		register(reg, new BlockRedRock());
		register(reg, new BlockCrackedSand());
	}
	
	public static void register(IForgeRegistry<Block> reg, Block block) {
		reg.register(block);
	}

	@SideOnly(Side.CLIENT)
	public static void initModels() {
		ExtraBlocks.redrock.initModel();
		ExtraBlocks.crackedsand.initModel();
	}

}
