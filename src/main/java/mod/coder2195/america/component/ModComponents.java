package mod.coder2195.america.component;

import com.mojang.serialization.Codec;
import mod.coder2195.america.America;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModComponents {
  public static final ComponentType<Integer> AMMO_COUNT = Registry.register(Registries.DATA_COMPONENT_TYPE, America.id("ammo_count"), ComponentType.<Integer>builder().codec(Codec.INT).build());

  public static final ComponentType<Long> LAST_USED = Registry.register(Registries.DATA_COMPONENT_TYPE, America.id("last_used"), ComponentType.<Long>builder().codec(Codec.LONG).build());

  public static final ComponentType<Long> LAST_RELOADED = Registry.register(Registries.DATA_COMPONENT_TYPE, America.id("last_reloaded"), ComponentType.<Long>builder().codec(Codec.LONG).build());

  public static void registerComponents() {
    America.LOGGER.info("Registering components");
  }
}