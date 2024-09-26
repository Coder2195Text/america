package mod.coder2195.america.mixin;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FireBlock.class)
public class FireMixin {
  @Inject(cancellable = true, method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/BlockPos;down()Lnet/minecraft/util/math/BlockPos;"))
  private void injected(BlockState state, WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
    for (int x = -1; x <= 1; x += 2) {
      for (int y = -1; y <= 1; y += 2) {
        for (int z = -1; z <= 1; z += 2) {
          BlockPos blockPos = pos.add(x, y, z);
          if (world.getBlockState(blockPos).getBlock() instanceof AbstractFireBlock) {
            cir.setReturnValue(true);
            cir.cancel();
          }
        }
      }
    }

  }

  @Redirect(method = "scheduledTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/FireBlock;areBlocksAroundFlammable(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Z"))
  private boolean injected2(FireBlock instance, BlockView world, BlockPos pos) {
    for (int x = -1; x <= 1; x += 2) {
      for (int y = -1; y <= 1; y += 2) {
        for (int z = -1; z <= 1; z += 2) {
          BlockPos blockPos = pos.add(x, y, z);
          if (world.getBlockState(blockPos).getBlock() instanceof AbstractFireBlock) {
            return true;
          }
        }
      }
    }
    return instance.areBlocksAroundFlammable(world, pos);
  }
}