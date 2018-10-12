package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;

public class BlockSaplingCypress extends BlockExtraSapling{
    public enum TreeVariantCypress {
        REGULAR, BALD;
    }

    public final TreeVariantCypress variant;
    public BlockSaplingCypress(TreeVariantCypress variant) {
        super();
        this.variant = variant;
        final String name = "sapling_cypress_"+variant.toString().toLowerCase();
        setUnlocalizedName( Extrabiomes.MODID + ".block." + name );
        setRegistryName( name );
        // NB: requires leaves and logs to be registered before calling this:
        //setTreeGen( new WorldGenAutumnTree(true, variant) );
    }
}
