package com.extrabiomes.ebxl.biomes;

import java.util.List;
import java.util.Map.Entry;

import com.extrabiomes.ebxl.Extrabiomes;
import com.extrabiomes.ebxl.config.BiomeSettings;
import com.extrabiomes.ebxl.config.DecorationSettings;
import com.google.common.collect.Lists;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager.BiomeType;

public abstract class ExtraBiome extends Biome {

	public static BiomeType DEFAULT_TYPE = BiomeType.WARM;
	public BiomeType type = DEFAULT_TYPE;
	
	public final List<BiomeDictionary.Type> dictTypes = Lists.newArrayList();
	
	public final BiomeSettings settings;
	public final DecorationSettings decorSettings;
	
	private int newFlowersPerChunk = 0;
	
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

}
