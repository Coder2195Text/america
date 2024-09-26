package mod.coder2195.america.render;

import mod.coder2195.america.effect.ModStatusEffects;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class DazzledEffect {
  public static int getDazzledStrength(LivingEntity entity, float tickDelta) {
    // strength from 00 to ff
    StatusEffectInstance statusEffectInstance = entity.getStatusEffect(ModStatusEffects.DAZZLED);
    return Math.round(MathHelper.clamp((!statusEffectInstance.isDurationBelow(200) ? 1.0F : 0.8F + MathHelper.sin(((float) statusEffectInstance.getDuration() - tickDelta) * 3.1415927F * 0.2F) * 0.2F) * 0xff, 0, 0xff));
  }

  public static void render(DrawContext drawContext, RenderTickCounter tickCounter) {
    var tickDelta = tickCounter.getTickDelta(true);
    var client = MinecraftClient.getInstance();
    if (client.player != null && client.player.hasStatusEffect(ModStatusEffects.DAZZLED)) {
      int color = getDazzledStrength(client.player, tickDelta) << 24 | 0xFFFFFF;
      drawContext.fill(0, 0, client.getWindow().getScaledWidth(), client.getWindow().getScaledHeight(), color);
    }
  }
}
