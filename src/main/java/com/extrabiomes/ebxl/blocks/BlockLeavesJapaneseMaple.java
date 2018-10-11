package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.blocks.BlockSaplingJapaneseMaple.TreeVariantJapaneseMaple;

public class BlockLeavesJapaneseMaple extends BlockExtraLeaves{
    public final TreeVariantJapaneseMaple variant;
    public BlockLeavesJapaneseMaple(TreeVariantJapaneseMaple variant) {
        super();
        this.variant = variant;
        final String name = "leaf_japanese_maple_"+variant.toString().toLowerCase();
        setUnlocalizedName( Extrabiomes.MODID + ".block." + name );
        setRegistryName( name );
    }
}
