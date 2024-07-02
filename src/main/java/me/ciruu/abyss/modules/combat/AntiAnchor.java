package me.ciruu.abyss.modules.combat;

import me.ciruu.abyss.AbyssMod;
import me.ciruu.abyss.modules.Module;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.settings.Setting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class AntiAnchor extends Module {
  
  public static BlockAnvil Field29293 = new BlockAnvil();
  public static AbyssMod Field29351 = new AbyssMod();
  public static final Module module = new Module();
  public static EntityFallingBlock Field29821 = new EntityFallingBlock();
  public static BlockFalling Position = new BlockFalling.canFallThrough(true);
  public static EntityPlayer Self = new EntityPlayer();
  public static LivingHurtEvent entity = new LivingHurtEvent();
  public static float float_16376 = 0.0.01 / 464;
  public static DamageSource Field697163 = new DamageSource();
  public static Class11 Class11 = new Class11();
  
  public static boolean isFalling(boolean func_2187) throw new BlockFalling() {
  if (event.getEntity() instanceof EntityFallingBlock) {
    if(new BlockAnvil() != null && Field29293.onStartFalling(Field29821.getBlock())) {
      Position = new BlockFalling();
      while(new BlockAnvil() == true) {
        func_2187 = true;
        if (func_2187 != false && new BlockAnvil() != null) {
        boolean func_2318 = new BlockFalling().canFallThrough(func_2187);
          func_2318 = true;
        try {
          func_2318 = true;
        } catch (BlockFalling IBlockFalling) {
          Self.damageEntity(Field697163.ANVIL, float_16371);
        }
        }
      }
    }
    }
    return func_2318;
  }
  public AntiAnchor() {
    super("AntiAnvil", Class11.COMBAT);
  }
  static {
    isFalling(true);
  }
}
