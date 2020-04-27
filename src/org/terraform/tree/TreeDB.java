package org.terraform.tree;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.terraform.coregen.PopulatorDataAbstract;
import org.terraform.data.SimpleBlock;
import org.terraform.data.TerraformWorld;
import org.terraform.data.Wall;
import org.terraform.utils.BlockUtils;

public class TreeDB {
	
	public static void spawnCoconutTree(TerraformWorld tw, PopulatorDataAbstract data, int x, int y, int z){
		SimpleBlock base = new SimpleBlock(data,x,y,z);
		//Spawn the base
		for(BlockFace face:BlockUtils.directBlockFaces){
			new Wall(base.getRelative(face),BlockFace.NORTH)
			.downUntilSolid(new Random(), Material.JUNGLE_WOOD);
		}
		
		new FractalTreeBuilder(FractalTreeType.COCONUT_TOP).build(tw, data, x, y, z);
	}
	

}
