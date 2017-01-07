package com.elseytd.pleistocraft.world;

import java.util.Random;
import com.elseytd.pleistocraft.registries.BlocksRegistry;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenSnow;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

public class PermafrostWorldGenerator implements IWorldGenerator{

		@Override
		public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		    switch (world.provider.getDimensionId()) {
		    case 0: //Overworld
		    	BiomeGenBase biome = world.getBiomeGenForCoords(new BlockPos(chunkX, 64, chunkZ));
		    	if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD))
		    	{	 
		    		this.runGenerator(this.gen_permafrost, world, random, chunkX, chunkZ, 40, 0, 64);
		    	}
		        break;
		    }
		}
		
		private WorldGenerator gen_permafrost;
		public PermafrostWorldGenerator() {
		    this.gen_permafrost = new WorldGenMinable(BlocksRegistry.permafrost.getDefaultState(), 8);
		}
		
		private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
		        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		    int heightDiff = maxHeight - minHeight + 1;
		    for (int i = 0; i < chancesToSpawn; i ++) {
		        int x = chunk_X * 16 + rand.nextInt(16);
		        int y = minHeight + rand.nextInt(heightDiff);
		        int z = chunk_Z * 16 + rand.nextInt(16);
		        generator.generate(world, rand, new BlockPos(x, y, z));
		    }
		}
	  
	  
}
