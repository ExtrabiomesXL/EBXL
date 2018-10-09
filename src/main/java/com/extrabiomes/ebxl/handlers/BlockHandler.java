package com.extrabiomes.ebxl.handlers;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.blocks.*;
import com.extrabiomes.ebxl.blocks.BlockSaplingAutumn.TreeVariant;
import com.extrabiomes.ebxl.blocks.BlockQuarterLog.QuarterLogVarient;
import com.extrabiomes.ebxl.gen.WorldGenAutumnTree;
import com.extrabiomes.ebxl.blocks.BlockLogCypress.CypressLogVariant;
import com.extrabiomes.ebxl.blocks.BlockSaplingCypress.TreeVariantCypress;

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
		ExtraBlocks.quarterLog_bald_cypress = register(reg, new BlockQuarterLog(QuarterLogVarient.BALD_CYPRESS));
		ExtraBlocks.logFir = register(reg, new BlockLogFir());
		ExtraBlocks.logRedwood = register(reg, new BlockLogRedwood());
		ExtraBlocks.logCypress_regular = register(reg, new BlockLogCypress(CypressLogVariant.REGULAR));
		ExtraBlocks.logCypress_bald = register(reg, new BlockLogCypress(CypressLogVariant.BALD));
		ExtraBlocks.logCypress_bald_elbow = register(reg, new BlockLogCypress(CypressLogVariant.BALD_ELBOW));


		ExtraBlocks.leafAutumn_brown = register(reg, new BlockLeavesAutumn(TreeVariant.BROWN));
		ExtraBlocks.leafAutumn_orange = register(reg, new BlockLeavesAutumn(TreeVariant.ORANGE));
		ExtraBlocks.leafAutumn_red = register(reg, new BlockLeavesAutumn(TreeVariant.RED));
		ExtraBlocks.leafAutumn_yellow = register(reg, new BlockLeavesAutumn(TreeVariant.YELLOW));
		ExtraBlocks.leafFir = register(reg, new BlockLeavesFir());
		ExtraBlocks.leafRedwood = register(reg, new BlockLeavesRedwood());
		ExtraBlocks.leafCypress_regular = register(reg, new BlockLeavesCypress(TreeVariantCypress.REGULAR));
		ExtraBlocks.leafCypress_bald = register(reg, new BlockLeavesCypress(TreeVariantCypress.BALD));

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

		ExtraBlocks.saplingCypress_regular = register(reg, new BlockSaplingCypress(TreeVariantCypress.REGULAR));
		((BlockLeavesCypress)ExtraBlocks.leafCypress_regular).setSapling((BlockExtraSapling)ExtraBlocks.saplingCypress_regular);

		ExtraBlocks.saplingCypress_bald = register(reg, new BlockSaplingCypress(TreeVariantCypress.BALD));
		((BlockLeavesCypress)ExtraBlocks.leafCypress_bald).setSapling((BlockExtraSapling)ExtraBlocks.saplingCypress_bald);

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
		((BlockQuarterLog)ExtraBlocks.quarterLog_bald_cypress).initModel();
		((BlockLogCypress)ExtraBlocks.logCypress_regular).initModel();
		((BlockLogCypress)ExtraBlocks.logCypress_bald).initModel();
		((BlockLogCypress)ExtraBlocks.logCypress_bald_elbow).initModel();

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
		((BlockLeavesCypress)ExtraBlocks.leafCypress_regular).initModel();
		((BlockSaplingCypress)ExtraBlocks.saplingCypress_regular).initModel();
		((BlockLeavesCypress)ExtraBlocks.leafCypress_bald).initModel();
		((BlockSaplingCypress)ExtraBlocks.saplingCypress_bald).initModel();

		Extrabiomes.log.info("-- models registered");
	}

}
