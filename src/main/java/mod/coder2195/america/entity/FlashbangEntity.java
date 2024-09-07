package mod.coder2195.america.entity;

import mod.coder2195.america.effect.ModStatusEffects;
import mod.coder2195.america.item.ModItems;
import mod.coder2195.america.sound.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class FlashbangEntity extends ThrownItemEntity {
  @Override
  protected Item getDefaultItem() {
    return ModItems.FLASHBANG;
  }

  public FlashbangEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
    super(entityType, world);
  }

  public FlashbangEntity(World world, LivingEntity owner) {
    super(ModEntities.FLASHBANG, owner, world); // null will be changed later
  }

  public FlashbangEntity(World world, double x, double y, double z) {
    super(ModEntities.FLASHBANG, x, y, z, world); // null will be changed later
  }

  public void detonate() {
    // Detonate the grenade4

    World world = this.getWorld();
    if (world.isClient) return;
    world.playSound(null, getBlockPos(), ModSounds.FLASHBANG_DETONATE, getSoundCategory(), 2.0F, 1.0F);
    world.getEntitiesByClass(LivingEntity.class, this.getBoundingBox().expand(45.0D), livingEntity -> true).forEach((entity) -> {

      double distance = entity.distanceTo(this);
      if (distance > 32) return;
      int duration = (int) (32 - distance) * 40;
      entity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.DAZZLED, duration));
    });
    kill();
  }


  @Override
  protected void onEntityHit(EntityHitResult entityHitResult) {
    World world = this.getWorld();
    if (world.isClient) return;
    detonate();
  }

  @Override
  protected void onBlockHit(BlockHitResult blockHitResult) {
    World world = this.getWorld();
    if (world.isClient) return;
    detonate();
  }

}