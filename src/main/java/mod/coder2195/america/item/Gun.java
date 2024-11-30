package mod.coder2195.america.item;

import mod.coder2195.america.component.ModComponents;
import mod.coder2195.america.sound.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class Gun extends Item {
  public int AMMO_CAPACITY = 30;
  public double RELOAD_TIME = 2.5;
  public SoundEvent FIRE_SOUND = ModSounds.ASSAULT_RIFLE_FIRE;
  public SoundEvent RELOAD_SOUND = ModSounds.ASSAULT_RIFLE_RELOAD;
  public float DAMAGE = 6;
  public float SPEED = 30;
  public int DEFAULT_MAX_USE_TIME = 0;
  public Item AMMO = ModItems.BULLET;
  public int FIRE_DELAY = 5;
  public boolean SCOPED = false;
  public float ZOOM_FOV = 0.75f;
  public float VARIANCE = 3f;

  public Gun(Settings settings) {
    super(settings);
  }

  public Gun() {
    super(new Item.Settings().maxCount(1).component(ModComponents.AMMO_COUNT, 0).component(ModComponents.LAST_USED, 0L).component(ModComponents.LAST_RELOADED, 0L));
  }

  @Override
  public UseAction getUseAction(ItemStack stack) {
    return UseAction.BOW;
  }

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    ItemStack item = user.getStackInHand(hand);

    long lastFire = item.getOrDefault(ModComponents.LAST_USED, 0L);
    long reloadTime = item.getOrDefault(ModComponents.LAST_RELOADED, 0L);
    long currentTime = world.getTime();
    int ammo = item.getOrDefault(ModComponents.AMMO_COUNT, 0);

    if (currentTime - lastFire < FIRE_DELAY || (ammo <= 0 && !user.isCreative())
        || currentTime - reloadTime < RELOAD_TIME * 20) {
      return TypedActionResult.fail(item);
    }

    if (!world.isClient) {
      world.playSound(
          null,
          user.getBlockPos(),
          FIRE_SOUND,
          SoundCategory.PLAYERS,
          1f,
          1f);

      action(world, user, hand);

      item.set(ModComponents.LAST_USED, currentTime);
      if (!user.isCreative()) {
        item.set(ModComponents.AMMO_COUNT, ammo - 1);
      }
    }

    return TypedActionResult.fail(item);

  }

  public void action(World world, PlayerEntity user, Hand hand) {
    // Implement
  }
}
