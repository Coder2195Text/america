package mod.coder2195.america;

import mod.coder2195.america.block.ModBlocks;
import mod.coder2195.america.entity.client.ModEntitiesClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class AmericaClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    ModBlocks.registerClient();
    ModEntitiesClient.registerEntityRenderers();
  }
}
