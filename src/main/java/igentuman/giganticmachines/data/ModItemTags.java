package igentuman.giganticmachines.data;

import igentuman.giganticmachines.Main;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModItemTags extends ItemTagsProvider {
    public ModItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup,
                       CompletableFuture<TagsProvider.TagLookup<net.minecraft.world.level.block.Block>> blockTags, ExistingFileHelper helper) {
        super(output, lookup, blockTags, Main.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        copy(ModBlockTags.CASINGS, TagKey.create(Registries.ITEM, ModDataGenerators.id("casings")));
        copy(ModBlockTags.CONTROLLERS, TagKey.create(Registries.ITEM, ModDataGenerators.id("controllers")));
        copy(ModBlockTags.PORTS, TagKey.create(Registries.ITEM, ModDataGenerators.id("ports")));
    }
}
