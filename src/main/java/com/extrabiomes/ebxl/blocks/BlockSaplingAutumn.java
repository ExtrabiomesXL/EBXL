package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.gen.WorldGenAutumnTree;

public class BlockSaplingAutumn extends BlockExtraSapling {

	public BlockSaplingAutumn() {
		super();
		setUnlocalizedName( Extrabiomes.MODID + ".block.sapling_autumn" );
		setRegistryName( "sapling_autumn" );
		// NB: requires leaves and logs to be registered before calling this:
		setTreeGen( new WorldGenAutumnTree(true) );
	}
}
