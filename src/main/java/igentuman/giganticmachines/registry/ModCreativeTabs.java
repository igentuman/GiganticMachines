package igentuman.giganticmachines.registry;

import igentuman.giganticmachines.Main;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Main.MODID);
    public static final RegistryObject<CreativeModeTab> GIGANTIC_MACHINES = TABS.register("gigantic_machines", () ->
            CreativeModeTab.builder().withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.giganticmachines.gigantic_machines"))
                    .icon(() -> ModBlocks.BEDROCK_EXTRACTOR.get().asItem().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        ModBlocks.CASINGS.forEach(block -> output.accept(block.get()));
                        ModBlocks.CONTROLLERS.forEach(block -> output.accept(block.get()));
                        ModBlocks.PORTS.forEach(block -> output.accept(block.get()));
                        output.accept(ModItems.WRENCH.get());
                        output.accept(ModItems.DNA_SAMPLE.get());
                    }).build());

    public static void addToVanillaTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            ModBlocks.CASINGS.forEach(event::accept);
        } else if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            ModBlocks.CONTROLLERS.forEach(event::accept);
            ModBlocks.PORTS.forEach(event::accept);
        } else if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.WRENCH);
            event.accept(ModItems.DNA_SAMPLE);
        }
    }

    private ModCreativeTabs() {}
}
