package com.extrabiomes.ebxl.biomes;

import java.util.List;
import java.util.Map.Entry;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.config.BiomeSettings;
import com.extrabiomes.ebxl.config.DecorationSettings;
import com.google.common.collect.Lists;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ExtraBiome extends Biome {

	public static BiomeType DEFAULT_TYPE = BiomeType.WARM;
	public BiomeType type = DEFAULT_TYPE;
	
	public final List<BiomeDictionary.Type> dictTypes = Lists.newArrayList();
	
	public final BiomeSettings settings;
	public final DecorationSettings decorSettings;
	
	@SuppressWarnings("unused")
	private int newFlowersPerChunk = 0;
	
	private Double foliageColor0 = null;
	private Double foliageColor1 = null;
	private Double grassColor0 = null;
	private Double grassColor1 = null;
	
	public ExtraBiome(BiomeSettings settings, BiomeProperties props) {
		super(props);
		this.setRegistryName(Extrabiomes.MODID, settings.name());
		
		this.settings = settings;
		
		this.decorSettings = DecorationSettings.valueOf(settings.name());
		for( Entry<DecorationSettings.Decoration,Integer> entry : this.decorSettings.get().entrySet() ) {
			switch( entry.getKey() ) {
				case WATERLILY:		this.decorator.waterlilyPerChunk = entry.getValue();	break;
				case TREES:			this.decorator.treesPerChunk = entry.getValue();		break;
				case FLOWERS:		this.decorator.flowersPerChunk = entry.getValue();		break;
				case GRASS:			this.decorator.grassPerChunk = entry.getValue();		break;
				case DEADBUSH:		this.decorator.deadBushPerChunk = entry.getValue();		break;
				case MUSHROOMS:		this.decorator.mushroomsPerChunk = entry.getValue();	break;
				case REEDS:			this.decorator.reedsPerChunk = entry.getValue();		break;
				case CACTI:			this.decorator.cactiPerChunk = entry.getValue();		break;
				case SAND:			this.decorator.sandPatchesPerChunk = entry.getValue();	break;
				case GRAVEL:		this.decorator.gravelPatchesPerChunk = entry.getValue(); break;
				case CLAY:			this.decorator.clayPerChunk = entry.getValue();			break;
				case BIGMUSHROOMS:	this.decorator.bigMushroomsPerChunk = entry.getValue();	break;
				case NEW_FLOWERS:	this.newFlowersPerChunk = entry.getValue();				break;
			}
		}
	}
	
	protected void setFoliageColor(double color0, double color1) {
		this.foliageColor0 = color0;
		this.foliageColor1 = color1;
	}
	
	protected void setGrassColor(double color0, double color1) {
		this.grassColor0 = color0;
		this.grassColor1 = color1;
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) {
		/**
		 * NB: I don't know what these getModdedBiomeGrassColor wrapper calls are doing, we didn't
		 * ever do/have that in the older build... but it's what forge does now, so I'm going with it.
		 */
		if( foliageColor0 != null && foliageColor1 != null )
			return getModdedBiomeGrassColor(ColorizerFoliage.getFoliageColor(foliageColor0, foliageColor1));
		else
			return super.getFoliageColorAtPos(pos);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
    	if( grassColor0 != null && grassColor1 != null )
    		return getModdedBiomeGrassColor(ColorizerGrass.getGrassColor(grassColor0, grassColor1));
    	else
    		return super.getGrassColorAtPos(pos);
    }

	public void setBlocks() {
		
	}

}
