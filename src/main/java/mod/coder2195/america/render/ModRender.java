package mod.coder2195.america.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

@Environment(EnvType.CLIENT)
public class ModRender {
  public static void init() {
    HudRenderCallback.EVENT.register(DazzledEffect::render);
  }
}
