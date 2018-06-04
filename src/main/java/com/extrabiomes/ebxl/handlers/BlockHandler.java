package com.extrabiomes.ebxl.handlers;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.blocks.*;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockHandler {

	public static void init(Register<Block> event) {
		final IForgeRegistry<Block> reg = event.getRegistry();
		ExtraBlocks.redrock = register(reg, new BlockRedRock());
		ExtraBlocks.crackedsand = register(reg, new BlockCrackedSand());
		
		ExtraBlocks.logAutumn = register(reg, new BlockLogAutumn());
		ExtraBlocks.leafAutumn = register(reg, new BlockLeavesAutumn());
		ExtraBlocks.saplingAutumn = register(reg, new BlockSaplingAutumn());
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn).setSapling((BlockExtraSapling)ExtraBlocks.saplingAutumn);
		
		Extrabiomes.log.info("-- blocks registered");
	}
	
	public static Block register(IForgeRegistry<Block> reg, Block block) {
		reg.register(block);
		return block;
	}

	@SideOnly(Side.CLIENT)
	public static void initModels() {
		((BlockRedRock)ExtraBlocks.redrock).initModel();
		((BlockCrackedSand)ExtraBlocks.crackedsand).initModel();
		((BlockLogAutumn)ExtraBlocks.logAutumn).initModel();
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn).initModel();
		((BlockSaplingAutumn)ExtraBlocks.saplingAutumn).initModel();
		Extrabiomes.log.info("-- models registered");
	}

}
