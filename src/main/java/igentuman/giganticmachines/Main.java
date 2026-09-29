package igentuman.giganticmachines;

import igentuman.giganticmachines.data.ModDataGenerators;
import igentuman.giganticmachines.registry.ModBlocks;
import igentuman.giganticmachines.registry.ModCreativeTabs;
import igentuman.giganticmachines.registry.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.MODID)
public class Main {
    public static final String MODID = "giganticmachines";

    public Main() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(bus);
        ModItems.ITEMS.register(bus);
        ModCreativeTabs.TABS.register(bus);
        bus.addListener(ModCreativeTabs::addToVanillaTabs);
        bus.addListener(ModDataGenerators::gatherData);
    }
}
