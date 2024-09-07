package mod.coder2195.america.sound;

import mod.coder2195.america.America;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;

public class ModSounds {
  public static final SoundEvent BULLET_HIT = registerSoundEvent("entity.bullet.hit");
  public static final SoundEvent ANTHEM = registerSoundEvent("music.anthem");

  public static final SoundEvent ASSAULT_RIFLE_FIRE = registerSoundEvent("item.assault_rifle.fire");
  public static final SoundEvent ASSAULT_RIFLE_RELOAD = registerSoundEvent("item.assault_rifle.reload");

  public static final SoundEvent SNIPER_FIRE = registerSoundEvent("item.sniper.fire");
  public static final SoundEvent SNIPER_RELOAD = registerSoundEvent("item.sniper.reload");

  public static final SoundEvent PISTOL_FIRE = registerSoundEvent("item.pistol.fire");
  public static final SoundEvent PISTOL_RELOAD = registerSoundEvent("item.pistol.reload");

  public static final SoundEvent MINIGUN_FIRE = registerSoundEvent("item.minigun.fire");

  public static final SoundEvent SHOTGUN_FIRE = registerSoundEvent("item.shotgun.fire");
  public static final SoundEvent SHOTGUN_RELOAD = registerSoundEvent("item.shotgun.reload");

  public static final SoundEvent SMOKE_GRENADE_DETONATE = registerSoundEvent("entity.smoke_grenade.detonate");
  public static final SoundEvent BULLET_SUCCESS = registerSoundEvent("entity.bullet.success");

  public static final SoundEvent TANK_CANNON = registerSoundEvent("entity.tank.cannon");
  public static final SoundEvent TANK_MACHINE_GUN = registerSoundEvent("entity.tank.machine_gun");

  public static final SoundEvent FLASHBANG_DETONATE = registerSoundEvent("entity.flashbang.detonate");
  public static final SoundEvent GRENADE_PIN = registerSoundEvent("item.grenade.pin");

  public static SoundEvent registerSoundEvent(String name) {
    var id = America.id(name);
    return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
  }

  public static void registerModSounds() {
    America.LOGGER.info("Registering mod sounds");
  }
}