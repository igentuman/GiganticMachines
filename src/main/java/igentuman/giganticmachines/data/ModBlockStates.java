package igentuman.giganticmachines.data;

import igentuman.giganticmachines.Main;
import igentuman.giganticmachines.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStates extends BlockStateProvider {
    public ModBlockStates(PackOutput output, ExistingFileHelper helper) {
        super(output, Main.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModBlocks.CASINGS.forEach(entry -> {
            Block block = entry.get();
            String name = name(block);
            simpleBlockWithItem(block, models().cubeAll(name, texture(name)));
        });
        ModBlocks.CONTROLLERS.forEach(entry -> faced(entry, name(entry.get()) + "_controller_front"));
        ModBlocks.PORTS.forEach(entry -> faced(entry, name(entry.get()).split("_")[0] + "_port_front"));
    }

    private void faced(RegistryObject<Block> entry, String front) {
        Block block = entry.get();
        ModelFile model = models().orientable(name(block), texture("iron_casing"), texture(front), texture("iron_casing"));
        horizontalBlock(block, model);
        simpleBlockItem(block, model);
    }

    private ResourceLocation texture(String name) {
        return modLoc("block/" + name);
    }

    private String name(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }
}
