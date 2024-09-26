package mod.coder2195.america;

import mod.coder2195.america.block.ModBlocks;
import mod.coder2195.america.effect.ModStatusEffects;
import mod.coder2195.america.entity.ModEntities;
import mod.coder2195.america.item.ModItemGroups;
import mod.coder2195.america.item.ModItems;
import mod.coder2195.america.sound.ModSounds;
import mod.coder2195.america.world.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class America implements ModInitializer {
  public static final String MOD_ID = "america";

  // This logger is used to write text to the console and the log file.
  // It is considered best practice to use your mod id as the logger's name.
  // That way, it's clear which mod wrote info, warnings, and errors.
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  public static Identifier id(String path) {
    return Identifier.of(MOD_ID, path);
  }

  @Override
  public void onInitialize() {
    ModItems.registerItems();
    ModItemGroups.registerItemGroups();
    ModSounds.registerModSounds();
    ModBlocks.registerBlocks();
    ModStatusEffects.registerStatusEffects();
    ModOreGeneration.registerOres();
    ModEntities.registerEntities();
  }
}