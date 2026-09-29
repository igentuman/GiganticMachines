package igentuman.giganticmachines.registry;

import igentuman.giganticmachines.Main;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);
    public static final RegistryObject<Item> WRENCH = ITEMS.register("wrench", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> DNA_SAMPLE = ITEMS.register("dna_sample", () -> new Item(new Item.Properties().stacksTo(1)));

    private ModItems() {}
}
