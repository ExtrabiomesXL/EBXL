package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockWoodStairs extends BlockStairs {

    public enum WoodStairsVariant{
        REDWOOD, FIR, CYPRESS, JAPANESE_MAPLE, RAINBOW_EUCALYPTUS, AUTUMN, BALD_CYPRESS, SAKURA;
    }

    WoodStairsVariant variant;
    public BlockWoodStairs(IBlockState modelState, WoodStairsVariant variant) {
        super(modelState);
        this.variant = variant;
        final String name = variant.toString().toLowerCase() + "_stairs";
        setUnlocalizedName( Extrabiomes.MODID + ".block." + name );
        setRegistryName(name);
        useNeighborBrightness=true;
    }
}
