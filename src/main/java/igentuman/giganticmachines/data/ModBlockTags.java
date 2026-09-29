package igentuman.giganticmachines.data;

import igentuman.giganticmachines.Main;
import igentuman.giganticmachines.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModBlockTags extends BlockTagsProvider {
    public static final TagKey<Block> CASINGS = tagKey("casings");
    public static final TagKey<Block> CONTROLLERS = tagKey("controllers");
    public static final TagKey<Block> PORTS = tagKey("ports");

    public ModBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, ExistingFileHelper helper) {
        super(output, lookup, Main.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addAll(CASINGS, ModBlocks.CASINGS);
        addAll(CONTROLLERS, ModBlocks.CONTROLLERS);
        addAll(PORTS, ModBlocks.PORTS);
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.CONCRETE.get(), ModBlocks.FACTORY_BLOCK.get(), ModBlocks.IRON_CASING.get(), ModBlocks.COPPER_CASING.get());
        tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.WOODEN_CASING.get());
        addAll(BlockTags.MINEABLE_WITH_PICKAXE, ModBlocks.CONTROLLERS);
        addAll(BlockTags.MINEABLE_WITH_PICKAXE, ModBlocks.PORTS);
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.IRON_CASING.get(), ModBlocks.COPPER_CASING.get());
        addAll(BlockTags.NEEDS_STONE_TOOL, ModBlocks.CONTROLLERS);
        addAll(BlockTags.NEEDS_STONE_TOOL, ModBlocks.PORTS);
    }

    private void addAll(TagKey<Block> tag, List<RegistryObject<Block>> blocks) {
        blocks.forEach(block -> tag(tag).add(block.get()));
    }

    private static TagKey<Block> tagKey(String path) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(Main.MODID, path));
    }
}
