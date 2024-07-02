package me.ciruu.abyss.modules.combat;

import me.ciruu.abyss.AbyssMod;
import me.ciruu.abyss.modules.Module;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockFalling;

public class AntiAnchor extends Module implements AbyssMod, BlockAnvil {
  public static BlockAnvil Field29293;
  public static AbyssMod Field29351;
  public final Module module = new Module();
  public static BlockFalling Position = new BlockFalling.canFallThrough();
  
  public static void isFalling(BlockFalling Position, int Range) {

  }
  public AntiAnchor() {
    super();
  }
  static {
    Field29293 = new BlockAnvil();
    Field29351 = new AbyssMod();
  }
}
