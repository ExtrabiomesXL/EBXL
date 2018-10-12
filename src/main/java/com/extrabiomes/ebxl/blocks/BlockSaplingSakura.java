package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;

public class BlockSaplingSakura extends BlockExtraSapling{
    public BlockSaplingSakura() {
        super();
        //
        final String name = "sapling_sakura";
        setUnlocalizedName( Extrabiomes.MODID + ".block." + name );
        setRegistryName( name );
        // NB: requires leaves and logs to be registered before calling this:
        //setTreeGen( new WorldGenFirTree(true) );
    }
}
