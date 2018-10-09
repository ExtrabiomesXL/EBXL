package com.extrabiomes.ebxl;

import com.extrabiomes.ebxl.blocks.ExtraBlocks;
import com.extrabiomes.ebxl.handlers.ItemHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabExtraBiomes extends CreativeTabs {
    public CreativeTabExtraBiomes(String label) {super(label);}

    @Override
    public ItemStack getTabIconItem(){return new ItemStack(ExtraBlocks.saplingAutumn_brown);}
}
