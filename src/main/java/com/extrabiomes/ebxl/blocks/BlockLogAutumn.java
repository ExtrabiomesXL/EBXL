package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

// TODO: Make BlockExtraLog to import
public class BlockLogAutumn extends Block {
	public static final PropertyEnum<BlockLog.EnumAxis> LOG_AXIS = PropertyEnum.<BlockLog.EnumAxis>create("axis", BlockLog.EnumAxis.class);
	
	public BlockLogAutumn() {
		super(Material.WOOD);
        this.setHardness(2.0F);
        this.setSoundType(SoundType.WOOD);

		setUnlocalizedName( Extrabiomes.MODID + ".block.log_autumn" );
		setRegistryName("log_autumn");
		setDefaultState( this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y) );
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(
			Item.getItemFromBlock(this), 0,
			new ModelResourceLocation(getRegistryName(), "inventory")
		);
	}
	
	@Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, LOG_AXIS);
    }
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(facing.getAxis()));
	}

    @Override public boolean canSustainLeaves(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos){ return true; }
    @Override public boolean isWood(net.minecraft.world.IBlockAccess world, BlockPos pos){ return true; }
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		switch (rot) {
			case COUNTERCLOCKWISE_90:
			case CLOCKWISE_90:
				switch ((BlockLog.EnumAxis) state.getValue(LOG_AXIS)) {
					case X:
						return state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
					case Z:
						return state.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
					default:
						return state;
				}	
			default:
				return state;
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		BlockLog.EnumAxis axis = BlockLog.EnumAxis.Y;
		int i = meta & 12;

		if (i == 4) {
			axis = BlockLog.EnumAxis.X;
		} else if (i == 8) {
			axis = BlockLog.EnumAxis.Z;
		}

		return this.getDefaultState().withProperty(LOG_AXIS, axis);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		BlockLog.EnumAxis axis = (BlockLog.EnumAxis) state.getValue(LOG_AXIS);

		if (axis == BlockLog.EnumAxis.X) {
			i |= 4;
		} else if (axis == BlockLog.EnumAxis.Z) {
			i |= 8;
		}

		return i;
	}
}
