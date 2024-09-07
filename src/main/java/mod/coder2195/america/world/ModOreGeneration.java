package mod.coder2195.america.world;

import mod.coder2195.america.America;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModOreGeneration {
  public static final RegistryKey<PlacedFeature> URANIUM_ORE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, America.id("uranium_ore"));

  public static void registerOres() {
    America.LOGGER.info("Registering ores...");
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BADLANDS, BiomeKeys.ERODED_BADLANDS, BiomeKeys.WOODED_BADLANDS, BiomeKeys.DESERT), GenerationStep.Feature.UNDERGROUND_ORES, URANIUM_ORE);
  }
}
