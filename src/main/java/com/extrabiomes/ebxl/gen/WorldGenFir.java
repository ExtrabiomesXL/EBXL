package com.extrabiomes.ebxl.gen;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.blocks.BlockExtraLeaves;
import com.extrabiomes.ebxl.blocks.ExtraBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class WorldGenFir extends WorldGenAbstractTree {

    public WorldGenFir(boolean notify) {
        super(notify);
        // Idiot test for myself so I don't ship broken trees :)
        if( trunkBlock == null || leafBlock == null ) {
            Extrabiomes.log.error(this.getClass().getSimpleName()+": null tree parts, likely prematurely initialized");
            throw new RuntimeException("Leaf/Trunk blocks not correctly initialized in time for tree generator.");
        }
    }

    private static BlockExtraLeaves leafBlock           = (BlockExtraLeaves)ExtraBlocks.leafFir;
    private static Block trunkBlock                     = ExtraBlocks.logFir;
    private static final int BASE_HEIGHT                = 8;
    private static final int CANOPY_HEIGHT              = 12;
    private static final int CANOPY_RADIUS_EXTRA_RADIUS = 2;
    private static final int MAX_VARIANCE_HEIGHT        = 24;

    @Override
    public boolean generate(World world, Random rand, BlockPos position) {
        if( !isBlockSuitableForGrowing(world, position.down()) ) {
            return false;
        }

        final int height = rand.nextInt(MAX_VARIANCE_HEIGHT+1) + BASE_HEIGHT;
        if( !isRoomToGrow(world, position, height) ) {
            return false;
        }

        world.setBlockState(position.down(), Blocks.DIRT.getDefaultState());
        growLeaves(world, rand, position, height);
        growTrunk(world, position, height);

        return true;
    }

    private void growLeaves(World world, Random rand, BlockPos position, int height) {
        final int _x = position.getX();
        final int _y = position.getY();
        final int _z = position.getZ();

        final IBlockState leafState = leafBlock.getDefaultState();

        for( int y = _y - CANOPY_HEIGHT + height; y <= _y + height; ++y ) {
            final int canopyRow = y - (_y + height);
            final int radius = CANOPY_RADIUS_EXTRA_RADIUS + 1 - (canopyRow / 2);

            for( int x = _x - radius; x <= _x + radius; ++x ) {
                final int xDistanceFromTrunk = Math.abs(x - _x);

                for( int z = _z - radius; z <= _z + radius; ++z ) {
                    final int zDistanceFromTrunk = Math.abs(z - _z);

                    if( xDistanceFromTrunk != radius || zDistanceFromTrunk != radius ||
                            (canopyRow != 0 && rand.nextInt(2) != 0)) {
                        final BlockPos pos = new BlockPos(x,y,z);
                        final IBlockState blockState = world.getBlockState(pos);
                        if( blockState.getBlock().canBeReplacedByLeaves(blockState, world, pos) ) {
                            world.setBlockState(pos, leafState);
                        }
                    }
                }
            }
        }
    }

    private void growTrunk(World world, BlockPos position, int height) {
        for( int y = 0; y < height; ++y ) {
            final BlockPos pos = position.up(y);
            final IBlockState blockState = world.getBlockState(pos);
            if( blockState.getBlock().isReplaceable(world, pos) || blockState.getBlock().isLeaves(blockState, world, pos) ) {
                world.setBlockState(pos, trunkBlock.getDefaultState());
            }
        }
    }


    private static boolean isBlockSuitableForGrowing(final World world, final BlockPos position) {
        final Block block = world.getBlockState(position).getBlock();
        return block == Blocks.DIRT || block == Blocks.GRASS;
    }

    private static boolean isRoomToGrow(final World world, final BlockPos position, final int height) {
        if( position.getY() < 1 || position.getY() + height + 1 > world.getHeight() ) {
            return false;
        }

        // TODO: scan relevant cylinder for replaceable space

        return true;
    }
}