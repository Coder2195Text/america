package mod.coder2195.america.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import mod.coder2195.america.item.ModItemTags;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class CooldownMixin {
  @Shadow
  @Nullable
  public ClientPlayerEntity player;

  @Shadow
  private int itemUseCooldown;

  @Inject(method = "doItemUse()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/HeldItemRenderer;resetEquipProgress(Lnet/minecraft/util/Hand;)V", ordinal = 1), cancellable = true)
  private void injected(CallbackInfo ci, @Local Hand hand) {
    ItemStack itemStack = this.player.getStackInHand(hand);
    if (itemStack.isIn(ModItemTags.GUNS)) {
      this.itemUseCooldown = 0;
      ci.cancel();
    }
  }
}