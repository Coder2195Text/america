package mod.coder2195.america.block;

import mod.coder2195.america.America;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks {
  public enum ItemType {
    NONE,
    ITEM,
    ITEM_TEXTURE,
  }

  public static final Block URANIUM_ORE = register(new Block(Block.Settings.copy(Blocks.DIAMOND_ORE)), "uranium_ore", ItemType.ITEM);

  public static final Block LANDMINE = register(new Landmine(), "landmine", ItemType.ITEM_TEXTURE);

  public static Block register(Block block, String name, ItemType register) {
    var id = America.id(name);

    if (!register.equals(ItemType.NONE)) {
      var item = register.equals(ItemType.ITEM) ?
          new BlockItem(block, new Item.Settings()) : new AliasedBlockItem(block, new Item.Settings());
      Registry.register(Registries.ITEM, id, item);
    }

    return Registry.register(Registries.BLOCK, id, block);
  }


  public static void registerBlocks() {
    America.LOGGER.info("Registering Blocks");
  }

  @Environment(EnvType.CLIENT)
  public static void registerClient() {
    BlockRenderLayerMap.INSTANCE.putBlock(LANDMINE, RenderLayer.getCutout());
  }
}
