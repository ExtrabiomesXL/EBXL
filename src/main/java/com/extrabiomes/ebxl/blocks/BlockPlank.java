package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPlank extends Block {
    public enum PlankVariant{
        REDWOOD, FIR, CYPRESS, JAPENESE_MAPLE, RAINBOW_EUCALYPTUS, AUTUMN, BALD_CYPRESS, SAKURA;
    }

    PlankVariant variant;
    public BlockPlank(PlankVariant variant) {
        super(Material.WOOD);
        this.variant = variant;
        final String name = "plank_"+ variant.toString().toLowerCase();
        setUnlocalizedName( Extrabiomes.MODID + ".block." + name );
        setRegistryName(name);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(this), 0,
                new ModelResourceLocation(getRegistryName(), "inventory")
        );
    }
}
