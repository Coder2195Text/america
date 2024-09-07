package mod.coder2195.america.entity;


import mod.coder2195.america.America;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModEntities {
  public static final EntityType<FlashbangEntity> FLASHBANG = Registry.register(Registries.ENTITY_TYPE,
      America.id("flashbang"),
      FabricEntityTypeBuilder.<FlashbangEntity>create(SpawnGroup.MISC, FlashbangEntity::new)
          .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

  public static void registerEntities() {
    America.LOGGER.info("Registering Entities");
  }
}
