package com.extrabiomes.ebxl.gen;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.blocks.BlockExtraLeaves;
import com.extrabiomes.ebxl.blocks.BlockSaplingAutumn.TreeVariant;
import com.extrabiomes.ebxl.blocks.ExtraBlocks;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Random;

public class WorldGenAutumnTree extends WorldGenExtraTree {

	private BlockExtraLeaves leafBlock = null;

	public WorldGenAutumnTree(boolean notify) {
		super(notify);
	}

	public WorldGenAutumnTree(boolean notify, TreeVariant variant) {
		super(notify);
		this.leafBlock = leafBlocks.get(variant);
		// Idiot test for myself so I don't ship broken trees :)
		if (trunkBlock == null || leafBlock == null) {
			Extrabiomes.log.error(this.getClass().getSimpleName() + ": null tree parts for " + variant + ", likely prematurely initialized");
			throw new RuntimeException("Leaf/Trunk blocks not correctly initialized in time for " + variant + " tree generator.");
		}
	}

	private static Map<TreeVariant, BlockExtraLeaves> leafBlocks = Maps.newHashMap();

	public static void initLeaves() {
		leafBlocks.put(TreeVariant.BROWN, (BlockExtraLeaves) ExtraBlocks.leafAutumn_brown);
		leafBlocks.put(TreeVariant.ORANGE, (BlockExtraLeaves) ExtraBlocks.leafAutumn_orange);
		leafBlocks.put(TreeVariant.RED, (BlockExtraLeaves) ExtraBlocks.leafAutumn_red);
		leafBlocks.put(TreeVariant.YELLOW, (BlockExtraLeaves) ExtraBlocks.leafAutumn_yellow);
	}

	private static Block trunkBlock = ExtraBlocks.logAutumn;
	private static final int CANOPY_HEIGHT = 3;
	private static final int CANOPY_RADIUS_EXTRA_RADIUS = 0;

	@Override
	protected void init() {
		BASE_HEIGHT = 5;
		MAX_VARIANCE_HEIGHT = 3;
	}

	@Override
	protected void growLeaves(World world, Random rand, BlockPos position, int height) {
		final int _x = position.getX();
		final int _y = position.getY();
		final int _z = position.getZ();

		final IBlockState leafState;
		if (leafBlock == null) {
			final int idx = rand.nextInt(leafBlocks.size());
			final BlockExtraLeaves leaves = (BlockExtraLeaves) leafBlocks.values().toArray()[idx];
			leafState = leaves.getDefaultState();
		} else {
			leafState = leafBlock.getDefaultState();
		}

		for (int y = _y - CANOPY_HEIGHT + height; y <= _y + height; ++y) {
			final int canopyRow = y - (_y + height);
			final int radius = CANOPY_RADIUS_EXTRA_RADIUS + 1 - (canopyRow / 2);

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
