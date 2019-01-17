package com.extrabiomes.ebxl.gen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public abstract class WorldGenExtraTree extends WorldGenAbstractTree {
	public WorldGenExtraTree(boolean doNotify) {
		super(doNotify);
		init();
	}

	protected int BASE_HEIGHT;
	protected int MAX_VARIANCE_HEIGHT;

	// for initializing the abovementioned variables
	abstract protected void init();

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		if (!isBlockSuitableForGrowing(world, position.down())) {
			return false;
		}

		final int height = rand.nextInt(MAX_VARIANCE_HEIGHT + 1) + BASE_HEIGHT;
		if (!isRoomToGrow(world, position, height)) {
			return false;
		}

		world.setBlockState(position.down(), Blocks.DIRT.getDefaultState());
		growLeaves(world, rand, position, height);
		growTrunk(world, position, height);

		return true;
	}

	protected static boolean isBlockSuitableForGrowing(final World world, final BlockPos position) {
		final Block block = world.getBlockState(position).getBlock();
		return block == Blocks.DIRT || block == Blocks.GRASS;
	}

	protected static boolean isRoomToGrow(final World world, final BlockPos position, final int height) {
		if (position.getY() < 1 || position.getY() + height + 1 > world.getHeight()) {
			return false;
		}

		// TODO: scan relevant cylinder for replaceable space

		return true;
	}

	abstract void growLeaves(World world, Random rand, BlockPos position, int height);

	abstract void growTrunk(World world, BlockPos position, int height);
}