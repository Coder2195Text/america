package mod.coder2195.america.datagen;

import mod.coder2195.america.item.ModItemTags;
import mod.coder2195.america.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {
  public ItemTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
    super(output, completableFuture);
  }

  @Override
  protected void configure(WrapperLookup arg) {
    for (Item item : ModItems.GUNS) {
      getOrCreateTagBuilder(ModItemTags.GUNS).add(item);
    }
//    getOrCreateTagBuilder(ItemTags.MUSIC_DISCS).add(ModItems.ANTHEM_DISC);
//    getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS).add(ModItems.ANTHEM_DISC);
  }

}