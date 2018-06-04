package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;

public class BlockLeavesAutumn extends BlockExtraLeaves {

	public BlockLeavesAutumn(BlockExtraSapling sapling) {
		super(sapling);
		setUnlocalizedName( Extrabiomes.MODID + ".block.leaf_autumn" );
		setRegistryName( "leaf_autumn" );
	}
	
}
