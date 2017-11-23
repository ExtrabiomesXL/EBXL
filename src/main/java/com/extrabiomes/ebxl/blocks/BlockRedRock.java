package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRedRock extends Block {
	public BlockRedRock() {
		super(Material.ROCK);
		setUnlocalizedName( Extrabiomes.MODID + ".block.redrock" );
		setRegistryName("redrock");
	}
}
