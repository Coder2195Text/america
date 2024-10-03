package mod.coder2195.america.mixin;

import mod.coder2195.america.effect.ModStatusEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public abstract class DazzledTargetMixin extends LivingEntity {
  protected DazzledTargetMixin(EntityType<? extends LivingEntity> entityType, World world) {
    super(entityType, world);
  }


  @Inject(method = "getTarget", at = @At("HEAD"), cancellable = true)
  private void injected(CallbackInfoReturnable<LivingEntity> cir) {
    if (this.hasStatusEffect(ModStatusEffects.DAZZLED)) {
      cir.setReturnValue(null);
    }
  }
}
