package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.gen.WorldGenAutumnTree;

public class BlockSaplingAutumn extends BlockExtraSapling {
	
	public enum TreeVariant {
		BROWN, ORANGE, RED, YELLOW;
	}

	public final TreeVariant variant;
	public BlockSaplingAutumn(TreeVariant variant) {
		super();
		this.variant = variant;
		final String name = "sapling_autumn_"+variant.toString().toLowerCase();
		setUnlocalizedName( Extrabiomes.MODID + ".block." + name );
		setRegistryName( name );
		// NB: requires leaves and logs to be registered before calling this:
		setTreeGen( new WorldGenAutumnTree(true, variant) );
	}
}
