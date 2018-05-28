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
		
		register(reg, ExtraBlocks.leafAutumn);
		ExtraBlocks.leafAutumn.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	public static void register(IForgeRegistry<Item> reg, Item item) {
		reg.register(item);
	}
	public static void register(IForgeRegistry<Item> reg, Block block) {
		register(reg, new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

}
