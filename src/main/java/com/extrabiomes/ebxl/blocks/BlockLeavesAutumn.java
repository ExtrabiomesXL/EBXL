package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.blocks.BlockSaplingAutumn.TreeVariant;

public class BlockLeavesAutumn extends BlockExtraLeaves {

	public final TreeVariant variant;
	public BlockLeavesAutumn(TreeVariant variant) {
		super();
		this.variant = variant;
		final String name = "leaf_autumn_"+variant.toString().toLowerCase();
		setUnlocalizedName( Extrabiomes.MODID + ".block." + name );
		setRegistryName( name );
	}
	
}
