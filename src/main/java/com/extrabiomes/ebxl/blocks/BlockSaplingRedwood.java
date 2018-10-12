package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;

public class BlockSaplingRedwood extends BlockExtraSapling{
//    public enum TreeVariantRedwood {
//        SINGLE, DOUBLE;
//    }
//
//    public final TreeVariantRedwood variant;

    public BlockSaplingRedwood() {
        super();
        //this.variant = variant;
        final String name = "sapling_redwood";
        setUnlocalizedName( Extrabiomes.MODID + ".block." + name );
        setRegistryName( name );
        // NB: requires leaves and logs to be registered before calling this:
        //setTreeGen( new WorldGenAutumnTree(true, variant) );
    }

}
