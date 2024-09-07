package mod.coder2195.america.item;

import mod.coder2195.america.America;
import mod.coder2195.america.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class ModItemGroups {
  public static ItemGroup AMERICA_WEAPONS = Registry.register(Registries.ITEM_GROUP,
      America.id("america_weapons"),
      FabricItemGroup
          .builder()
          .displayName(Text.translatable("itemgroup.america_weapons"))
          .icon(() -> new ItemStack(ModItems.BULLET)).entries((display, entries) -> {
            entries.add(ModItems.BULLET);
            entries.add(ModBlocks.LANDMINE.asItem());
            entries.add(ModItems.FLASHBANG);
          }).build());

  public static void registerItemGroups() {
    America.LOGGER.info("Registering item groups for " + America.MOD_ID);
  }
}