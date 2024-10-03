package mod.coder2195.america.entity.client;

import mod.coder2195.america.America;
import mod.coder2195.america.entity.ModEntities;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

@Environment(EnvType.CLIENT)
public class ModEntitiesClient {
  public static void registerEntityRenderers() {
    America.LOGGER.info("Registering Entity Renderers");
    EntityRendererRegistry.register(ModEntities.FLASHBANG, FlyingItemEntityRenderer::new);
    EntityRendererRegistry.register(ModEntities.INCENDIARY_GRENADE, FlyingItemEntityRenderer::new);
  }
}
