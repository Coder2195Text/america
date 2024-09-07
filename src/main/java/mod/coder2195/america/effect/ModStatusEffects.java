package mod.coder2195.america.effect;

import mod.coder2195.america.America;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

public class ModStatusEffects {
  public static final RegistryEntry<StatusEffect> DAZZLED = register(new StatusEffect(StatusEffectCategory.HARMFUL, 0x8F8B66) {
  }, "dazzled");


  public static RegistryEntry<StatusEffect> register(StatusEffect statusEffect, String id) {
    return Registry.registerReference(Registries.STATUS_EFFECT, America.id(id), statusEffect);
  }


  public static void registerStatusEffects() {
    // Register the status effects
    America.LOGGER.info("Registering mod status effects");

  }
}