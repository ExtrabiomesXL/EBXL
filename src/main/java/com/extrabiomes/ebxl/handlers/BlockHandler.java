package com.extrabiomes.ebxl.handlers;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.blocks.*;
import com.extrabiomes.ebxl.blocks.BlockSaplingAutumn.TreeVariant;
import com.extrabiomes.ebxl.blocks.BlockQuarterLog.QuarterLogVarient;
import com.extrabiomes.ebxl.gen.WorldGenAutumnTree;
import com.extrabiomes.ebxl.blocks.BlockLogCypress.CypressLogVariant;
import com.extrabiomes.ebxl.blocks.BlockSaplingCypress.TreeVariantCypress;
import com.extrabiomes.ebxl.blocks.BlockRedRock.RedRockVariant;
import com.extrabiomes.ebxl.blocks.BlockPlank.PlankVariant;
import com.extrabiomes.ebxl.blocks.BlockSaplingJapaneseMaple.TreeVariantJapaneseMaple;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockHandler {

	public static void init(Register<Block> event) {
		final IForgeRegistry<Block> reg = event.getRegistry();
		ExtraBlocks.redrock = register(reg, new BlockRedRock(RedRockVariant.ROCK));
		ExtraBlocks.red_cobblestone = register(reg, new BlockRedRock(RedRockVariant.COBBLESTONE));
		ExtraBlocks.redrock_brick = register(reg, new BlockRedRock(RedRockVariant.ROCK_BRICK));
		ExtraBlocks.crackedsand = register(reg, new BlockCrackedSand());
		ExtraBlocks.plank_fir = register(reg, new BlockPlank(PlankVariant.FIR));
		ExtraBlocks.plank_redwood = register(reg, new BlockPlank(PlankVariant.REDWOOD));
		ExtraBlocks.plank_cypress = register(reg, new BlockPlank(PlankVariant.CYPRESS));
		ExtraBlocks.plank_japanese_maple = register(reg, new BlockPlank(PlankVariant.JAPANESE_MAPLE));
		ExtraBlocks.plank_rainbow_eucalyptus = register(reg, new BlockPlank(PlankVariant.RAINBOW_EUCALYPTUS));
		ExtraBlocks.plank_autumn = register(reg, new BlockPlank(PlankVariant.AUTUMN));
		ExtraBlocks.plank_bald_cypress = register(reg, new BlockPlank(PlankVariant.BALD_CYPRESS));
		ExtraBlocks.plank_sakura = register(reg, new BlockPlank(PlankVariant.SAKURA));
		
		ExtraBlocks.logAutumn = register(reg, new BlockLogAutumn());
		ExtraBlocks.quarterLog_fir = register(reg, new BlockQuarterLog(QuarterLogVarient.FIR));
		ExtraBlocks.quarterLog_oak = register(reg, new BlockQuarterLog(QuarterLogVarient.OAK));
		ExtraBlocks.quarterLog_redwood = register(reg, new BlockQuarterLog(QuarterLogVarient.REDWOOD));
		ExtraBlocks.quarterLog_bald_cypress = register(reg, new BlockQuarterLog(QuarterLogVarient.BALD_CYPRESS));
		ExtraBlocks.quarterLog_rainbow_eucalyptus = register(reg, new BlockQuarterLog(QuarterLogVarient.RAINBOW_EUCALYPTUS));
		ExtraBlocks.logFir = register(reg, new BlockLogFir());
		ExtraBlocks.logRedwood = register(reg, new BlockLogRedwood());
		ExtraBlocks.logCypress_regular = register(reg, new BlockLogCypress(CypressLogVariant.REGULAR));
		ExtraBlocks.logCypress_bald = register(reg, new BlockLogCypress(CypressLogVariant.BALD));
		ExtraBlocks.logCypress_bald_elbow = register(reg, new BlockLogCypress(CypressLogVariant.BALD_ELBOW));
		ExtraBlocks.logJapaneseMaple = register(reg, new BlockLogJapaneseMaple());
		ExtraBlocks.logRainbowEucalyptus_regular = register(reg, new BlockLogRainbowEucalyptus(BlockLogRainbowEucalyptus.RainbowEucalyotusLogVariant.REGULAR));
		ExtraBlocks.logRainbowEucalyptus_elbow = register(reg, new BlockLogRainbowEucalyptus(BlockLogRainbowEucalyptus.RainbowEucalyotusLogVariant.ELBOW));
		ExtraBlocks.logSakura = register(reg, new BlockLogSakura());


		ExtraBlocks.leafAutumn_brown = register(reg, new BlockLeavesAutumn(TreeVariant.BROWN));
		ExtraBlocks.leafAutumn_orange = register(reg, new BlockLeavesAutumn(TreeVariant.ORANGE));
		ExtraBlocks.leafAutumn_red = register(reg, new BlockLeavesAutumn(TreeVariant.RED));
		ExtraBlocks.leafAutumn_yellow = register(reg, new BlockLeavesAutumn(TreeVariant.YELLOW));
		ExtraBlocks.leafFir = register(reg, new BlockLeavesFir());
		ExtraBlocks.leafRedwood = register(reg, new BlockLeavesRedwood());
		ExtraBlocks.leafCypress_regular = register(reg, new BlockLeavesCypress(TreeVariantCypress.REGULAR));
		ExtraBlocks.leafCypress_bald = register(reg, new BlockLeavesCypress(TreeVariantCypress.BALD));
		ExtraBlocks.leafJapaneseMaple_regular = register(reg, new BlockLeavesJapaneseMaple(TreeVariantJapaneseMaple.REGULAR));
		ExtraBlocks.leafJapaneseMaple_shrub = register(reg, new BlockLeavesJapaneseMaple(TreeVariantJapaneseMaple.SHRUB));
		ExtraBlocks.leafRainbowEucalyptus = register(reg, new BlockLeavesRainbowEucalyptus());
		ExtraBlocks.leafSakura = register(reg, new BlockLeavesSakura());

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

		ExtraBlocks.saplingJapaneseMaple_regular = register(reg, new BlockSaplingJapaneseMaple(TreeVariantJapaneseMaple.REGULAR));
		((BlockLeavesJapaneseMaple)ExtraBlocks.leafJapaneseMaple_regular).setSapling((BlockExtraSapling)ExtraBlocks.saplingJapaneseMaple_regular);

		ExtraBlocks.saplingJapaneseMaple_shrub = register(reg, new BlockSaplingJapaneseMaple(TreeVariantJapaneseMaple.SHRUB));
		((BlockLeavesJapaneseMaple)ExtraBlocks.leafJapaneseMaple_shrub).setSapling((BlockExtraSapling)ExtraBlocks.saplingJapaneseMaple_shrub);

		ExtraBlocks.saplingRainbowEucalyptus = register(reg, new BlockSaplingRainbowEucalyptus());
		((BlockLeavesRainbowEucalyptus)ExtraBlocks.leafRainbowEucalyptus).setSapling((BlockExtraSapling)ExtraBlocks.saplingRainbowEucalyptus);

		ExtraBlocks.saplingSakura = register(reg, new BlockSaplingSakura());
		((BlockLeavesSakura)ExtraBlocks.leafSakura).setSapling((BlockExtraSapling)ExtraBlocks.saplingSakura);

		Extrabiomes.log.info("-- blocks registered");
	}
	
	public static Block register(IForgeRegistry<Block> reg, Block block) {
		reg.register(block);
		return block;
	}

	@SideOnly(Side.CLIENT)
	public static void initModels() {
		((BlockRedRock)ExtraBlocks.redrock).initModel();
		((BlockRedRock)ExtraBlocks.red_cobblestone).initModel();
		((BlockRedRock)ExtraBlocks.redrock_brick).initModel();
		((BlockCrackedSand)ExtraBlocks.crackedsand).initModel();
		((BlockPlank)ExtraBlocks.plank_redwood).initModel();
		((BlockPlank)ExtraBlocks.plank_fir).initModel();
		((BlockPlank)ExtraBlocks.plank_rainbow_eucalyptus).initModel();
		((BlockPlank)ExtraBlocks.plank_sakura).initModel();
		((BlockPlank)ExtraBlocks.plank_japanese_maple).initModel();
		((BlockPlank)ExtraBlocks.plank_cypress).initModel();
		((BlockPlank)ExtraBlocks.plank_bald_cypress).initModel();
		((BlockPlank)ExtraBlocks.plank_autumn).initModel();
		((BlockLogAutumn)ExtraBlocks.logAutumn).initModel();
		((BlockLogFir)ExtraBlocks.logFir).initModel();
		((BlockLogRedwood)ExtraBlocks.logRedwood).initModel();
		((BlockQuarterLog)ExtraBlocks.quarterLog_fir).initModel();
		((BlockQuarterLog)ExtraBlocks.quarterLog_redwood).initModel();
		((BlockQuarterLog)ExtraBlocks.quarterLog_oak).initModel();
		((BlockQuarterLog)ExtraBlocks.quarterLog_bald_cypress).initModel();
		((BlockQuarterLog)ExtraBlocks.quarterLog_rainbow_eucalyptus).initModel();
		((BlockLogCypress)ExtraBlocks.logCypress_regular).initModel();
		((BlockLogCypress)ExtraBlocks.logCypress_bald).initModel();
		((BlockLogCypress)ExtraBlocks.logCypress_bald_elbow).initModel();
		((BlockLogRainbowEucalyptus)ExtraBlocks.logRainbowEucalyptus_regular).initModel();
		((BlockLogRainbowEucalyptus)ExtraBlocks.logRainbowEucalyptus_elbow).initModel();
		((BlockLogJapaneseMaple)ExtraBlocks.logJapaneseMaple).initModel();
		((BlockLogSakura)ExtraBlocks.logSakura).initModel();

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
		((BlockLeavesJapaneseMaple)ExtraBlocks.leafJapaneseMaple_regular).initModel();
		((BlockSaplingJapaneseMaple)ExtraBlocks.saplingJapaneseMaple_regular).initModel();
		((BlockLeavesJapaneseMaple)ExtraBlocks.leafJapaneseMaple_shrub).initModel();
		((BlockSaplingJapaneseMaple)ExtraBlocks.saplingJapaneseMaple_shrub).initModel();
		((BlockLeavesRainbowEucalyptus)ExtraBlocks.leafRainbowEucalyptus).initModel();
		((BlockSaplingRainbowEucalyptus)ExtraBlocks.saplingRainbowEucalyptus).initModel();
		((BlockLeavesSakura)ExtraBlocks.leafSakura).initModel();
		((BlockSaplingSakura)ExtraBlocks.saplingSakura).initModel();

		Extrabiomes.log.info("-- models registered");
	}

}
