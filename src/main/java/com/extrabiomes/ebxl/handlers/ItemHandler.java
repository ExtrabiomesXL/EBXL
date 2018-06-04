package com.extrabiomes.ebxl.handlers;

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
		ExtraBlocks.redrock.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		register(reg, ExtraBlocks.crackedsand);
		ExtraBlocks.crackedsand.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		register(reg, ExtraBlocks.logAutumn);
		ExtraBlocks.logAutumn.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		register(reg, ExtraBlocks.leafAutumn_brown);
		ExtraBlocks.leafAutumn_brown.setCreativeTab(CreativeTabs.DECORATIONS);
		register(reg, ExtraBlocks.leafAutumn_orange);
		ExtraBlocks.leafAutumn_orange.setCreativeTab(CreativeTabs.DECORATIONS);
		register(reg, ExtraBlocks.leafAutumn_red);
		ExtraBlocks.leafAutumn_red.setCreativeTab(CreativeTabs.DECORATIONS);
		register(reg, ExtraBlocks.leafAutumn_yellow);
		ExtraBlocks.leafAutumn_yellow.setCreativeTab(CreativeTabs.DECORATIONS);
		
		register(reg, ExtraBlocks.saplingAutumn_brown);
		ExtraBlocks.saplingAutumn_brown.setCreativeTab(CreativeTabs.DECORATIONS);
		register(reg, ExtraBlocks.saplingAutumn_orange);
		ExtraBlocks.saplingAutumn_orange.setCreativeTab(CreativeTabs.DECORATIONS);
		register(reg, ExtraBlocks.saplingAutumn_red);
		ExtraBlocks.saplingAutumn_red.setCreativeTab(CreativeTabs.DECORATIONS);
		register(reg, ExtraBlocks.saplingAutumn_yellow);
		ExtraBlocks.saplingAutumn_yellow.setCreativeTab(CreativeTabs.DECORATIONS);
	}
	
	public static void register(IForgeRegistry<Item> reg, Item item) {
		reg.register(item);
	}
	public static void register(IForgeRegistry<Item> reg, Block block) {
		register(reg, new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

}
