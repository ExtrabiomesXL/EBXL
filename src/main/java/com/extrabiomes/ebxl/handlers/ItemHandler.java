package com.extrabiomes.ebxl.handlers;

import com.extrabiomes.ebxl.CreativeTabExtraBiomes;
import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.biomes.ExtraBiome;
import com.extrabiomes.ebxl.blocks.ExtraBlocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemHandler {

	public static void init(Register<Item> event) {
		final IForgeRegistry<Item> reg = event.getRegistry();
		
		register(reg, ExtraBlocks.redrock);
		ExtraBlocks.redrock.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.red_cobblestone);
		ExtraBlocks.red_cobblestone.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.redrock_brick);
		ExtraBlocks.redrock_brick.setCreativeTab(Extrabiomes.creativeTab);

		register(reg, ExtraBlocks.crackedsand);
		ExtraBlocks.crackedsand.setCreativeTab(Extrabiomes.creativeTab);

		register(reg, ExtraBlocks.plank_autumn);
		ExtraBlocks.plank_autumn.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.plank_bald_cypress);
		ExtraBlocks.plank_bald_cypress.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.plank_cypress);
		ExtraBlocks.plank_cypress.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.plank_fir);
		ExtraBlocks.plank_fir.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.plank_japenese_maple);
		ExtraBlocks.plank_japenese_maple.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.plank_rainbow_eucalyptus);
		ExtraBlocks.plank_rainbow_eucalyptus.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.plank_redwood);
		ExtraBlocks.plank_redwood.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.plank_sakura);
		ExtraBlocks.plank_sakura.setCreativeTab(Extrabiomes.creativeTab);

		
		register(reg, ExtraBlocks.logAutumn);
		ExtraBlocks.logAutumn.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.logFir);
		ExtraBlocks.logFir.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.logRedwood);
		ExtraBlocks.logRedwood.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.logCypress_regular);
		ExtraBlocks.logCypress_regular.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.logCypress_bald);
		ExtraBlocks.logCypress_bald.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.logCypress_bald_elbow);
		ExtraBlocks.logCypress_bald_elbow.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.quarterLog_fir);
		register(reg, ExtraBlocks.logRainbowEucalyptus_regular);
		ExtraBlocks.logRainbowEucalyptus_regular.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.logRainbowEucalyptus_elbow);
		ExtraBlocks.logRainbowEucalyptus_elbow.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.logJapeneseMaple);
		ExtraBlocks.logJapeneseMaple.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.logSakura);
		ExtraBlocks.logSakura.setCreativeTab(Extrabiomes.creativeTab);
		ExtraBlocks.quarterLog_fir.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.quarterLog_redwood);
		ExtraBlocks.quarterLog_redwood.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.quarterLog_oak);
		ExtraBlocks.quarterLog_oak.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.quarterLog_bald_cypress);
		ExtraBlocks.quarterLog_bald_cypress.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.quarterLog_rainbow_eucalyptus);
		ExtraBlocks.quarterLog_rainbow_eucalyptus.setCreativeTab(Extrabiomes.creativeTab);

		register(reg, ExtraBlocks.leafAutumn_brown);
		ExtraBlocks.leafAutumn_brown.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.leafAutumn_orange);
		ExtraBlocks.leafAutumn_orange.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.leafAutumn_red);
		ExtraBlocks.leafAutumn_red.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.leafAutumn_yellow);
		ExtraBlocks.leafAutumn_yellow.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.leafFir);
		ExtraBlocks.leafFir.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.leafRedwood);
		ExtraBlocks.leafRedwood.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.leafCypress_regular);
		ExtraBlocks.leafCypress_regular.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.leafCypress_bald);
		ExtraBlocks.leafCypress_bald.setCreativeTab(Extrabiomes.creativeTab);

		register(reg, ExtraBlocks.saplingAutumn_brown);
		ExtraBlocks.saplingAutumn_brown.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.saplingAutumn_orange);
		ExtraBlocks.saplingAutumn_orange.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.saplingAutumn_red);
		ExtraBlocks.saplingAutumn_red.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.saplingAutumn_yellow);
		ExtraBlocks.saplingAutumn_yellow.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.saplingFir);
		ExtraBlocks.saplingFir.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.saplingRedwood);
		ExtraBlocks.saplingRedwood.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.saplingCypress_regular);
		ExtraBlocks.saplingCypress_regular.setCreativeTab(Extrabiomes.creativeTab);
		register(reg, ExtraBlocks.saplingCypress_bald);
		ExtraBlocks.saplingCypress_bald.setCreativeTab(Extrabiomes.creativeTab);
	}
	
	public static void register(IForgeRegistry<Item> reg, Item item) {
		reg.register(item);
	}
	public static void register(IForgeRegistry<Item> reg, Block block) {
		register(reg, new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

}
