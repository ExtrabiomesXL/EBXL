package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;

public class BlockSaplingJapaneseMaple extends BlockExtraSapling{
    public enum TreeVariantJapaneseMaple {
        REGULAR, SHRUB;
    }

    public final TreeVariantJapaneseMaple variant;
    public BlockSaplingJapaneseMaple(TreeVariantJapaneseMaple variant) {
        super();
        this.variant = variant;
        final String name = "sapling_japanese_maple_"+variant.toString().toLowerCase();
        setUnlocalizedName( Extrabiomes.MODID + ".block." + name );
        setRegistryName( name );
        // NB: requires leaves and logs to be registered before calling this:
        //setTreeGen( new WorldGenAutumnTree(true, variant) );
    }
}
