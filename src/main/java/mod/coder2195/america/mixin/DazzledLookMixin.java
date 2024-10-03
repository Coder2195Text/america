package mod.coder2195.america.mixin;

import mod.coder2195.america.effect.ModStatusEffects;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LookAtEntityGoal.class)
public abstract class DazzledLookMixin {
  @Shadow
  @Final
  protected MobEntity mob;

  @Shadow
  private int lookTime;

  @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
  private void injected(CallbackInfo ci) {
    if (mob.hasStatusEffect(ModStatusEffects.DAZZLED)) {
      lookTime = -1;
      ci.cancel();
    }
  }
}
