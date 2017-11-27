package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockRedRock extends Block {
	public BlockRedRock() {
		super(Material.ROCK);
		setUnlocalizedName( Extrabiomes.MODID + ".block.redrock" );
		setRegistryName("redrock");
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(
			Item.getItemFromBlock(this), 0,
			new ModelResourceLocation(getRegistryName(), "inventory")
		);
	}
}
