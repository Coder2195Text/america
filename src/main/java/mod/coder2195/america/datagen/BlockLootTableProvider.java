package mod.coder2195.america.datagen;

import mod.coder2195.america.block.ModBlocks;
import mod.coder2195.america.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class BlockLootTableProvider extends FabricBlockLootTableProvider {
  public BlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
    super(dataOutput, registryLookup);
  }

  @Override
  public void generate() {
    addDrop(ModBlocks.URANIUM_ORE, oreDrops(ModBlocks.URANIUM_ORE, ModItems.URANIUM));
  }
}
