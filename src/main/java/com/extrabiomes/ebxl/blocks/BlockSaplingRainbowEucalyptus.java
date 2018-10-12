package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;

public class BlockSaplingRainbowEucalyptus extends BlockExtraSapling{
    public BlockSaplingRainbowEucalyptus() {
        super();
        //
        final String name = "sapling_rainbow_eucalyptus";
        setUnlocalizedName( Extrabiomes.MODID + ".block." + name );
        setRegistryName( name );
        // NB: requires leaves and logs to be registered before calling this:
        //setTreeGen( new WorldGenFirTree(true) );
    }
}
