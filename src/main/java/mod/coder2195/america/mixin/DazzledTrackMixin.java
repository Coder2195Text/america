package mod.coder2195.america.mixin;

import mod.coder2195.america.effect.ModStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.TrackTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TrackTargetGoal.class)
public class DazzledTrackMixin {
  @Shadow
  @Final
  protected MobEntity mob;

  @Inject(method = "canNavigateToEntity", at = @At("HEAD"), cancellable = true)
  private void injected(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
    if (mob.hasStatusEffect(ModStatusEffects.DAZZLED)) {
      cir.setReturnValue(false);
    }
  }
}
