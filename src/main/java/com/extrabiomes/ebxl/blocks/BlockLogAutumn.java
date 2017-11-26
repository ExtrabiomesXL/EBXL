package com.extrabiomes.ebxl.blocks;

import com.extrabiomes.ebxl.Extrabiomes;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLogAutumn extends BlockLog {
	public BlockLogAutumn() {
		super();
		setUnlocalizedName( Extrabiomes.MODID + ".block.log_autumn" );
		setRegistryName("log_autumn");
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(
			Item.getItemFromBlock(this), 0,
			new ModelResourceLocation(getRegistryName(), "inventory")
		);
	}
}
