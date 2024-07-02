package me.ciruu.abyss.modules.combat;

import me.ciruu.abyss.AbyssMod;
import me.ciruu.abyss.modules.Module;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.item.EntityFallingBlock;

public class AntiAnchor extends Module implements BlockFalling, BlockAnvil {
  public static BlockAnvil Field29293;
  public static AbyssMod Field29351;
  public final Module module = new Module();
  public static EntityFallingBlock Field29821 = new EntityFallingBlock();
  public static BlockFalling Position = new BlockFalling.canFallThrough(true);
  public static boolean isFalling(boolean func_2187) throw new BlockFalling() {
    if(new BlockAnvil() != null && Field29293.onStartFalling(Field29821.getBlock())) {
      Position = new BlockFalling();
      while(new BlockAnvil() == true) {
        func_2187 = true;
        if (func_2187 != false && new BlockAnvil() != null) {
        boolean func_2318 = new BlockFalling.canFallThrough(func_2187);
          func_2318 = true;
        try {
          func_2318 = true;
        } catch (BlockFalling IBlockFalling) {
        }
      }
    }
    return func_2318;
  }
  public AntiAnchor() {
    super();
  }
  static {
    isFalling(true);
  }
}
