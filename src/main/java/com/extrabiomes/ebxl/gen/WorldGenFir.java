package com.extrabiomes.ebxl.gen;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.blocks.BlockExtraLeaves;
import com.extrabiomes.ebxl.blocks.ExtraBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class WorldGenFir extends WorldGenExtraTree {

	public WorldGenFir(boolean notify) {
		super(notify);
		// Idiot test for myself so I don't ship broken trees :)
		if (trunkBlock == null || leafBlock == null) {
			Extrabiomes.log.error(this.getClass().getSimpleName() + ": null tree parts, likely prematurely initialized");
			throw new RuntimeException("Leaf/Trunk blocks not correctly initialized in time for tree generator.");
		}
	}

	private static BlockExtraLeaves leafBlock = (BlockExtraLeaves) ExtraBlocks.leafFir;
	private static Block trunkBlock = ExtraBlocks.logFir;
	private static final int CANOPY_HEIGHT = 12;

	@Override
	protected void init() {
		BASE_HEIGHT = 8;
		MAX_VARIANCE_HEIGHT = 24;
	}

	@Override
	protected void growLeaves(World world, Random rand, BlockPos position, int height) {
		final int _x = position.getX();
		final int _y = position.getY();
		final int _z = position.getZ();

		final IBlockState leafState = leafBlock.getDefaultState();

		int max_radius = 2 + rand.nextInt(6);
		int radius = rand.nextInt(2);
		int radius_step = 1;
		int radius_reset = 0;

		// for( int y = _y - CANOPY_HEIGHT + height; y <= _y + height; ++y ) {
		for (int y = _y + height; y >= _y - CANOPY_HEIGHT + height; --y) {
			final int canopyRow = y - (_y + height);

			for (int x = _x - radius; x <= _x + radius; ++x) {
				final int xDistanceFromTrunk = Math.abs(x - _x);

				for (int z = _z - radius; z <= _z + radius; ++z) {
					final int zDistanceFromTrunk = Math.abs(z - _z);

					if (xDistanceFromTrunk != radius || zDistanceFromTrunk != radius ||
							(canopyRow != 0 && rand.nextInt(2) != 0)) {
						final BlockPos pos = new BlockPos(x, y, z);
						final IBlockState blockState = world.getBlockState(pos);
						if (blockState.getBlock().canBeReplacedByLeaves(blockState, world, pos)) {
							world.setBlockState(pos, leafState);
						}
					}
				}
			}

			if (radius >= radius_step) {
				radius = radius_reset;
				radius_reset = 1;

				if (++radius_step > max_radius) {
					radius_step = max_radius;
				}
			} else {
				++radius;
			}
		}
	}

	@Override
	protected void growTrunk(World world, BlockPos position, int height) {
		for (int y = 0; y < height; ++y) {
			final BlockPos pos = position.up(y);
			final IBlockState blockState = world.getBlockState(pos);
			if (blockState.getBlock().isReplaceable(world, pos) || blockState.getBlock().isLeaves(blockState, world, pos)) {
				world.setBlockState(pos, trunkBlock.getDefaultState());
			}
		}
	}

}