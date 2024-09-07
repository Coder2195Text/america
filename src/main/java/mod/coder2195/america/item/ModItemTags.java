package mod.coder2195.america.item;

import mod.coder2195.america.America;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
  public static final TagKey<Item> GUNS = TagKey.of(RegistryKeys.ITEM, America.id("guns"));
}