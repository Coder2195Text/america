package mod.coder2195.america;

import mod.coder2195.america.datagen.BlockLootTableProvider;
import mod.coder2195.america.datagen.BlockTagProvider;
import mod.coder2195.america.datagen.ModelProvider;
import mod.coder2195.america.datagen.RecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class AmericaDatagen implements DataGeneratorEntrypoint {
  @Override
  public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

    pack.addProvider(ModelProvider::new);
    pack.addProvider(RecipeProvider::new);
    pack.addProvider(BlockTagProvider::new);
    pack.addProvider(BlockLootTableProvider::new);
  }
}
