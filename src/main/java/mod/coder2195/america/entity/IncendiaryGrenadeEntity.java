package mod.coder2195.america.entity;

import mod.coder2195.america.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class IncendiaryGrenadeEntity extends ThrownItemEntity {
  @Override
  protected Item getDefaultItem() {
    return ModItems.INCENDIARY_GRENADE;
  }

  public IncendiaryGrenadeEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
    super(entityType, world);
  }

  public IncendiaryGrenadeEntity(World world, LivingEntity owner) {
    super(ModEntities.INCENDIARY_GRENADE, owner, world); // null will be changed later
  }

  public IncendiaryGrenadeEntity(World world, double x, double y, double z) {
    super(ModEntities.INCENDIARY_GRENADE, x, y, z, world); // null will be changed later
  }

  public void detonate() {

    // Detonate the smoke grenade
    World world = this.getWorld();
    Vec3d pos = this.getPos();
    BlockPos blockPos = new BlockPos((int) pos.x, (int) pos.y, (int) pos.z);
    if (world.isClient) return;

    world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 4.0F, true, World.ExplosionSourceType.MOB);


    for (int i = 0; i < 5; i++) {
      for (int x = blockPos.getX() - 4; x <= blockPos.getX() + 4; x++) {
        for (int z = blockPos.getZ() - 4; z <= blockPos.getZ() + 4; z++) {
          for (int y = blockPos.getY() - 4; y <= blockPos.getY() + 4; y++) {
            BlockState state = world.getBlockState(new BlockPos(x, y, z));
            if (state.isBurnable() || state.isReplaceable() || state.isAir())
              world.setBlockState(new BlockPos(x, y, z), Blocks.FIRE.getDefaultState());
          }
        }
      }
    }


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