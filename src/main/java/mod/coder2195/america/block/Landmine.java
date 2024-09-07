package mod.coder2195.america.block;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WeightedPressurePlateBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Landmine extends WeightedPressurePlateBlock {

  public Landmine() {
    super(1, BlockSetType.STONE, Settings.copy(Blocks.STONE_PRESSURE_PLATE).nonOpaque());
  }

  @Override
  protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
    if (world.isClient || !(entity instanceof LivingEntity)) return;
    world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 3.0F, true, World.ExplosionSourceType.TNT);
  }
}
