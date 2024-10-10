package mod.coder2195.america.item;

import mod.coder2195.america.America;
import mod.coder2195.america.block.ModBlocks;
import mod.coder2195.america.entity.FlashbangEntity;
import mod.coder2195.america.entity.IncendiaryGrenadeEntity;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
  public static final Item BULLET = register(new Item(new Item.Settings()), "bullet");
  public static final Item URANIUM = register(new Item(new Item.Settings()), "uranium");

  public static final Item FLASHBANG = register(new Grenade(FlashbangEntity.class), "flashbang");
  public static final Item INCENDIARY_GRENADE = register(new Grenade(IncendiaryGrenadeEntity.class), "incendiary_grenade");

  public static final Item AK47 = register(new Gun(), "ak47");


  public static final Item[] GUNS = new Item[]{AK47};

  public static Item register(Item item, String id) {
    return Registry.register(Registries.ITEM, America.id(id), item);
  }

  public static void registerItems() {
    America.LOGGER.info("Registering Items");
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((group) -> {
      group.add(ModItems.URANIUM);
    });
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register((group) -> {
      group.add(ModBlocks.URANIUM_ORE);
    });
  }
}
