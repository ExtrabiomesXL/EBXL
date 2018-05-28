package com.extrabiomes.ebxl.gen;

import java.util.Random;

import com.extrabiomes.ebxl.blocks.ExtraBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenAutumnTree extends WorldGenAbstractTree {

	public WorldGenAutumnTree(boolean notify) {
		super(notify);
	}
	
    private static Block     trunkBlock                 = ExtraBlocks.logAutumn;
    private static Block     leafBlock					= Blocks.LEAVES;
    private static final int BASE_HEIGHT                = 5; // was 4
    private static final int CANOPY_HEIGHT              = 3;
    private static final int CANOPY_RADIUS_EXTRA_RADIUS = 0;
    private static final int MAX_VARIANCE_HEIGHT        = 3; // was 2

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
							world.setBlockState(pos, leafBlock.getDefaultState());
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
