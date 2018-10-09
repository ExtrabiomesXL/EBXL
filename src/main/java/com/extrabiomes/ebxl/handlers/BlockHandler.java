package com.extrabiomes.ebxl.handlers;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.blocks.*;
import com.extrabiomes.ebxl.blocks.BlockSaplingAutumn.TreeVariant;
import com.extrabiomes.ebxl.blocks.BlockQuarterLog.QuarterLogVarient;
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
		ExtraBlocks.quarterLog_fir = register(reg, new BlockQuarterLog(QuarterLogVarient.FIR));
		ExtraBlocks.quarterLog_oak = register(reg, new BlockQuarterLog(QuarterLogVarient.OAK));
		ExtraBlocks.quarterLog_redwood = register(reg, new BlockQuarterLog(QuarterLogVarient.REDWOOD));
		ExtraBlocks.logFir = register(reg, new BlockLogFir());
		ExtraBlocks.logRedwood = register(reg, new BlockLogRedwood());


		ExtraBlocks.leafAutumn_brown = register(reg, new BlockLeavesAutumn(TreeVariant.BROWN));
		ExtraBlocks.leafAutumn_orange = register(reg, new BlockLeavesAutumn(TreeVariant.ORANGE));
		ExtraBlocks.leafAutumn_red = register(reg, new BlockLeavesAutumn(TreeVariant.RED));
		ExtraBlocks.leafAutumn_yellow = register(reg, new BlockLeavesAutumn(TreeVariant.YELLOW));
		ExtraBlocks.leafFir = register(reg, new BlockLeavesFir());
		ExtraBlocks.leafRedwood = register(reg, new BlockLeavesRedwood());

		WorldGenAutumnTree.initLeaves();
		
		ExtraBlocks.saplingAutumn_brown = register(reg, new BlockSaplingAutumn(TreeVariant.BROWN));
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn_brown).setSapling((BlockExtraSapling)ExtraBlocks.saplingAutumn_brown);
		
		ExtraBlocks.saplingAutumn_orange = register(reg, new BlockSaplingAutumn(TreeVariant.ORANGE));
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn_orange).setSapling((BlockExtraSapling)ExtraBlocks.saplingAutumn_orange);
		
		ExtraBlocks.saplingAutumn_red = register(reg, new BlockSaplingAutumn(TreeVariant.RED));
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn_red).setSapling((BlockExtraSapling)ExtraBlocks.saplingAutumn_red);
		
		ExtraBlocks.saplingAutumn_yellow = register(reg, new BlockSaplingAutumn(TreeVariant.YELLOW));
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn_yellow).setSapling((BlockExtraSapling)ExtraBlocks.saplingAutumn_yellow);

		ExtraBlocks.saplingFir = register(reg, new BlockSaplingFir());
		((BlockLeavesFir)ExtraBlocks.leafFir).setSapling((BlockExtraSapling)ExtraBlocks.saplingFir);
		ExtraBlocks.saplingRedwood = register(reg, new BlockSaplingRedwood());
		((BlockLeavesRedwood)ExtraBlocks.leafRedwood).setSapling((BlockExtraSapling)ExtraBlocks.saplingRedwood);

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
		((BlockLogFir)ExtraBlocks.logFir).initModel();
		((BlockLogRedwood)ExtraBlocks.logRedwood).initModel();
		((BlockQuarterLog)ExtraBlocks.quarterLog_fir).initModel();
		((BlockQuarterLog)ExtraBlocks.quarterLog_redwood).initModel();
		((BlockQuarterLog)ExtraBlocks.quarterLog_oak).initModel();
		
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn_brown).initModel();
		((BlockSaplingAutumn)ExtraBlocks.saplingAutumn_brown).initModel();
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn_orange).initModel();
		((BlockSaplingAutumn)ExtraBlocks.saplingAutumn_orange).initModel();
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn_red).initModel();
		((BlockSaplingAutumn)ExtraBlocks.saplingAutumn_red).initModel();
		((BlockLeavesAutumn)ExtraBlocks.leafAutumn_yellow).initModel();
		((BlockSaplingAutumn)ExtraBlocks.saplingAutumn_yellow).initModel();
		((BlockLeavesFir)ExtraBlocks.leafFir).initModel();
		((BlockSaplingFir)ExtraBlocks.saplingFir).initModel();
		((BlockLeavesRedwood)ExtraBlocks.leafRedwood).initModel();
		((BlockSaplingRedwood)ExtraBlocks.saplingRedwood).initModel();

		Extrabiomes.log.info("-- models registered");
	}

}
