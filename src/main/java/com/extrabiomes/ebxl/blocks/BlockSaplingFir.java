package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.gen.WorldGenFir;

public class BlockSaplingFir extends BlockExtraSapling{
//    public enum TreeVariantFir {
//        SINGLE, DOUBLE;
//    }
//
//    public final TreeVariantFir variant;

    public BlockSaplingFir() {
        super();
        //
        final String name = "sapling_fir";
        setUnlocalizedName( Extrabiomes.MODID + ".block." + name );
        setRegistryName( name );
        // NB: requires leaves and logs to be registered before calling this:
        setTreeGen( new WorldGenFir(true) );
    }
}
