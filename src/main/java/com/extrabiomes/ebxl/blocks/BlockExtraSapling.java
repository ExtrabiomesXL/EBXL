package com.extrabiomes.ebxl.blocks;

import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockExtraSapling extends BlockBush implements IGrowable {

	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	
	protected WorldGenAbstractTree treeGen = null;
	
	public BlockExtraSapling() {
		setHardness(0.0F);
		setSoundType(SoundType.PLANT);
	}

	@Override
	public boolean canGrow(World world, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}
	

	@Override
	public boolean canUseBonemeal(World world, Random rand, BlockPos pos, IBlockState state) {
		// NB: jabelar does a 45% chance here
		return rand.nextFloat() < 0.45F;
		// TODO: look at vanilla
		//return true;
	}

	@Override
	public void grow(World world, Random rand, BlockPos pos, IBlockState state) {
		if( state.getValue(STAGE).intValue() == 0 ) {
			world.setBlockState(pos, state.cycleProperty(STAGE), 4);
		} else {
			generateTree(world, rand, pos, state);
		}
	}
	
	public void generateTree(World world, Random rand, BlockPos pos, IBlockState state) {
		if( treeGen == null || !TerrainGen.saplingGrowTree(world, rand, pos) ) return;
		
		world.setBlockToAir(pos);
		treeGen.generate(world, rand, pos);
	}
	public WorldGenAbstractTree getTreeGen() {
		return treeGen;
	}
	public void setTreeGen(WorldGenAbstractTree treeGen) {
		this.treeGen = treeGen;
	}
	
	// properties
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(STAGE, Integer.valueOf(meta & 8) >> 3);
	}
	@Override
	public int getMetaFromState(IBlockState state) {
		final int i = 0 | (state.getValue(STAGE).intValue() << 3);
		return i;
	}
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {STAGE});
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(
			Item.getItemFromBlock(this), 0,
			new ModelResourceLocation(getRegistryName(), "inventory")
		);
	}

}
