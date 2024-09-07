package mod.coder2195.america.item;

import mod.coder2195.america.component.ModComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;

public class Gun extends Item {
  public int AMMO_CAPACITY = 30;
  public double RELOAD_TIME = 2.5;
  //  public SoundEvent FIRE_SOUND = ModSounds.ASSAULT_RIFLE_FIRE;
  //  public SoundEvent RELOAD_SOUND = ModSounds.ASSAULT_RIFLE_RELOAD;
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
    return UseAction.CROSSBOW;
  }


}