package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.blocks.BlockSaplingCypress.TreeVariantCypress;

public class BlockLeavesCypress extends BlockExtraLeaves{
    public final TreeVariantCypress variant;
    public BlockLeavesCypress(TreeVariantCypress variant) {
        super();
        this.variant = variant;
        final String name = "leaf_cypress_"+variant.toString().toLowerCase();
        setUnlocalizedName( Extrabiomes.MODID + ".block." + name );
        setRegistryName( name );
    }
}
