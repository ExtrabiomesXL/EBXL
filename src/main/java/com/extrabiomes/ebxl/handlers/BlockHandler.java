package com.extrabiomes.ebxl.handlers;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.blocks.*;
import com.extrabiomes.ebxl.blocks.BlockSaplingAutumn.TreeVariant;
import com.extrabiomes.ebxl.gen.WorldGenAutumnTree;

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
		
		ExtraBlocks.leafAutumn_brown = register(reg, new BlockLeavesAutumn(TreeVariant.BROWN));
		ExtraBlocks.leafAutumn_orange = register(reg, new BlockLeavesAutumn(TreeVariant.ORANGE));
		ExtraBlocks.leafAutumn_red = register(reg, new BlockLeavesAutumn(TreeVariant.RED));
		ExtraBlocks.leafAutumn_yellow = register(reg, new BlockLeavesAutumn(TreeVariant.YELLOW));
		
		WorldGenAutumnTree.initLeaves();
		
		ExtraBlocks.saplingAutumn_brown = register(reg, new BlockSaplingAutumn(TreeVariant.BROWN));
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn_brown).setSapling((BlockExtraSapling)ExtraBlocks.saplingAutumn_brown);
		
		ExtraBlocks.saplingAutumn_orange = register(reg, new BlockSaplingAutumn(TreeVariant.ORANGE));
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn_orange).setSapling((BlockExtraSapling)ExtraBlocks.saplingAutumn_orange);
		
		ExtraBlocks.saplingAutumn_red = register(reg, new BlockSaplingAutumn(TreeVariant.RED));
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn_red).setSapling((BlockExtraSapling)ExtraBlocks.saplingAutumn_red);
		
		ExtraBlocks.saplingAutumn_yellow = register(reg, new BlockSaplingAutumn(TreeVariant.YELLOW));
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn_yellow).setSapling((BlockExtraSapling)ExtraBlocks.saplingAutumn_yellow);
				
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
		
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn_brown).initModel();
		((BlockSaplingAutumn)ExtraBlocks.saplingAutumn_brown).initModel();
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn_orange).initModel();
		((BlockSaplingAutumn)ExtraBlocks.saplingAutumn_orange).initModel();
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn_red).initModel();
		((BlockSaplingAutumn)ExtraBlocks.saplingAutumn_red).initModel();
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn_yellow).initModel();
		((BlockSaplingAutumn)ExtraBlocks.saplingAutumn_yellow).initModel();

		Extrabiomes.log.info("-- models registered");
	}

}
