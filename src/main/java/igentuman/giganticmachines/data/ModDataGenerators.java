package igentuman.giganticmachines.data;

import igentuman.giganticmachines.Main;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;

public final class ModDataGenerators {
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(event.includeClient(), new ModBlockStates(generator.getPackOutput(), event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ModItemModels(generator.getPackOutput(), event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ModLanguage(generator.getPackOutput()));
        generator.addProvider(event.includeServer(), new LootTableProvider(generator.getPackOutput(), Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLoot::new, LootContextParamSets.BLOCK))));
        ModBlockTags blockTags = new ModBlockTags(generator.getPackOutput(), event.getLookupProvider(), event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new ModItemTags(generator.getPackOutput(), event.getLookupProvider(), blockTags.contentsGetter(), event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new ModRecipes(generator.getPackOutput()));
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(Main.MODID, path);
    }

    private ModDataGenerators() {}
}
