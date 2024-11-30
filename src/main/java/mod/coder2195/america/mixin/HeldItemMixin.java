package mod.coder2195.america.mixin;

import mod.coder2195.america.item.ModItemTags;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HeldItemRenderer.class)
public abstract class HeldItemMixin {
  @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z", ordinal = 1), method = "renderFirstPersonItem")
  private boolean checkGunInject(ItemStack item, Item _item) {
    return item.isOf(Items.CROSSBOW) || item.isIn(ModItemTags.GUNS);
  }

  @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/item/CrossbowItem;isCharged(Lnet/minecraft/item/ItemStack;)Z"), method = "renderFirstPersonItem")
  private boolean chargedInject(ItemStack item) {
    return item.isIn(ModItemTags.GUNS) || CrossbowItem.isCharged(item);
  }

  @ModifyVariable(method = "renderFirstPersonItem", at = @At("HEAD"), ordinal = 3)
  private float equipInject(float value, AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
//    return item.isIn(ModItemTags.GUNS) ? 0.0F : value;
    return value;
  }
}
