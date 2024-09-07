package mod.coder2195.america.datagen;

import mod.coder2195.america.block.ModBlocks;
import mod.coder2195.america.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModelProvider extends FabricModelProvider {


  public ModelProvider(FabricDataOutput output) {
    super(output);
  }


  @Override
  public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_ORE);
    blockStateModelGenerator.registerWeightedPressurePlate(ModBlocks.LANDMINE, ModBlocks.LANDMINE);

  }

  @Override
  public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    itemModelGenerator.register(ModItems.BULLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM, Models.GENERATED);
    itemModelGenerator.register(ModBlocks.LANDMINE.asItem(), Models.GENERATED);
    itemModelGenerator.register(ModItems.FLASHBANG, Models.GENERATED);
  }
}
