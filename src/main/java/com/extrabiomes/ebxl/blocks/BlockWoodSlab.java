package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class BlockWoodSlab extends BlockSlab {
    public static final PropertyEnum<Variant> VARIANT = PropertyEnum.<Variant>create("variant", Variant.class);

    public enum WoodSlabVariant{
        REDWOOD, FIR, CYPRESS, JAPANESE_MAPLE, RAINBOW_EUCALYPTUS, AUTUMN, BALD_CYPRESS, SAKURA;
    }

    public static enum Variant implements IStringSerializable
    {
        DEFAULT;

        @Override
        public String getName() {
            return "default";
        }
    }

    WoodSlabVariant variant;
    public BlockWoodSlab(WoodSlabVariant variant){
        super(Material.WOOD);
        this.variant = variant;
        final String name = variant.toString().toLowerCase()+ "_slab";
        this.setHardness(2.0F).setResistance(5.0F);
        this.setSoundType(SoundType.WOOD);
        this.setHarvestLevel("axe", 0);
        this.setUnlocalizedName( Extrabiomes.MODID + ".block." + name );
        this.setRegistryName(name);

        IBlockState iblockstate = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);

        if(!this.isDouble()) {
            iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        }

        this.setDefaultState(iblockstate);
        this.useNeighborBrightness = !this.isDouble();
    }

    @Override
    public String getUnlocalizedName(int meta) {
        return super.getUnlocalizedName();
    }

    @Override
    public final IBlockState getStateFromMeta(final int meta) {
        IBlockState blockstate = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);

        if(!this.isDouble()) {
            blockstate = blockstate.withProperty(HALF, ((meta&8)!=0)?EnumBlockHalf.TOP:EnumBlockHalf.BOTTOM);
        }

        return blockstate;
    }

    @Override
    public final int getMetaFromState(final IBlockState state) {
        int meta = 0;

        if(!this.isDouble()&& state.getValue(HALF)==EnumBlockHalf.TOP) {
            meta |= 8;
        }

        return meta;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        if(!this.isDouble()){
            return new BlockStateContainer(this, new IProperty[] {VARIANT, HALF});
        }
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

    @Override
    public boolean isDouble() {
        return false;
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return VARIANT;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return Variant.DEFAULT;
    }

    public static class Double extends BlockWoodSlab{

        public Double(WoodSlabVariant variant) {
            super(variant);
        }

        @Override
        public boolean isDouble() {
            return true;
        }
    }

    public static class Half extends BlockWoodSlab{

        public Half(WoodSlabVariant variant) {
            super(variant);
        }

        @Override
        public boolean isDouble() {
            return false;
        }
    }
}
