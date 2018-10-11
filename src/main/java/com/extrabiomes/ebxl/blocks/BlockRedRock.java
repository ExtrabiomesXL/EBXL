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
	public enum RedRockVariant{
		ROCK, COBBLESTONE, ROCK_BRICK;
	}

	RedRockVariant variant;
	public BlockRedRock(RedRockVariant variant) {
		super(Material.ROCK);
		this.variant = variant;
		final String name = "red_"+ variant.toString().toLowerCase();
		setUnlocalizedName( Extrabiomes.MODID + ".block." + name );
		setRegistryName(name);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(
			Item.getItemFromBlock(this), 0,
			new ModelResourceLocation(getRegistryName(), "inventory")
		);
	}
}
