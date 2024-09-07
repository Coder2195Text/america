package mod.coder2195.america.item;

import mod.coder2195.america.America;
import mod.coder2195.america.entity.FlashbangEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
  public static final Item BULLET = register(new Item(new Item.Settings()), "bullet");
  public static final Item URANIUM = register(new Item(new Item.Settings()), "uranium");

  public static final Item FLASHBANG = register(new Grenade(FlashbangEntity.class), "flashbang");

  public static Item register(Item item, String id) {
    return Registry.register(Registries.ITEM, America.id(id), item);
  }

  public static void registerItems() {
    America.LOGGER.info("Registering Items");
  }
}
