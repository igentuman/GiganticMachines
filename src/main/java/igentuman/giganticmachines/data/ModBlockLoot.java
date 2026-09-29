package igentuman.giganticmachines.data;

import igentuman.giganticmachines.registry.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Stream;
import java.util.Set;

public class ModBlockLoot extends BlockLootSubProvider {
    public ModBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        getKnownBlocks().forEach(this::dropSelf);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Stream.of(ModBlocks.CASINGS, ModBlocks.CONTROLLERS, ModBlocks.PORTS)
                .flatMap(java.util.Collection::stream).map(RegistryObject::get).toList();
    }
}
