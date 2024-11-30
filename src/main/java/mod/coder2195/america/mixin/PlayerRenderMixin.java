package mod.coder2195.america.mixin;


import mod.coder2195.america.item.ModItemTags;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntityRenderer.class)
public class PlayerRenderMixin {

  @Inject(at = @At("HEAD"), method = "getArmPose", cancellable = true)

  private static void injected(AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable<BipedEntityModel.ArmPose> cir) {
    ItemStack itemStack = player.getStackInHand(hand);
    if (itemStack.isIn(ModItemTags.GUNS)) {
      cir.setReturnValue(BipedEntityModel.ArmPose.CROSSBOW_HOLD);
    }
  }
}
