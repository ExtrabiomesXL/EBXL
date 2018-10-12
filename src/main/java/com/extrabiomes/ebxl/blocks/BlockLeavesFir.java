package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BlockLeavesFir extends BlockExtraLeaves{

    public BlockLeavesFir(){
        super();
        setUnlocalizedName( Extrabiomes.MODID + ".block." + "leaf_fir" );
        setRegistryName( "leaf_fir" );
    }




    @SideOnly(Side.CLIENT)
    public IBlockColor getBlockColor(){
        return new IBlockColor() {
            @Override
            public int colorMultiplier(IBlockState state, @Nullable IBlockAccess world, @Nullable BlockPos pos, int tintIndex) {
                boolean inWorld = world != null && pos != null;
                return inWorld ? BiomeColorHelper.getFoliageColorAtPos(world, pos) : ColorizerFoliage.getFoliageColorBasic();

            }
        };
    }
}
