package igentuman.giganticmachines.registry;

import igentuman.giganticmachines.Main;
import igentuman.giganticmachines.block.FacedBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    public static final RegistryObject<Block> CONCRETE = plain("concrete", MapColor.STONE, 2.0f);
    public static final RegistryObject<Block> FACTORY_BLOCK = plain("factory_block", MapColor.METAL, 4.0f);
    public static final RegistryObject<Block> IRON_CASING = plain("iron_casing", MapColor.METAL, 4.0f);
    public static final RegistryObject<Block> COPPER_CASING = plain("copper_casing", MapColor.COLOR_ORANGE, 3.0f);
    public static final RegistryObject<Block> WOODEN_CASING = plain("wooden_casing", MapColor.WOOD, 2.0f);

    public static final RegistryObject<Block> BEDROCK_EXTRACTOR = faced("bedrock_extractor");
    public static final RegistryObject<Block> TITANIC_CRUSHER = faced("titanic_crusher");
    public static final RegistryObject<Block> SMELTING_COMPLEX = faced("smelting_complex");
    public static final RegistryObject<Block> MODULAR_FOUNDRY = faced("modular_foundry");
    public static final RegistryObject<Block> BIODOME = faced("biodome");
    public static final RegistryObject<Block> REPLICATION_BIOREACTOR = faced("replication_bioreactor");
    public static final RegistryObject<Block> HYDROELECTRIC_CASCADE = faced("hydroelectric_cascade");
    public static final RegistryObject<Block> GENOME_ANALYZER = faced("genome_analyzer");
    public static final RegistryObject<Block> SINGULARITY_PRESS = faced("singularity_press");

    public static final RegistryObject<Block> ITEM_INPUT_PORT = faced("item_input_port");
    public static final RegistryObject<Block> ITEM_OUTPUT_PORT = faced("item_output_port");
    public static final RegistryObject<Block> FLUID_INPUT_PORT = faced("fluid_input_port");
    public static final RegistryObject<Block> FLUID_OUTPUT_PORT = faced("fluid_output_port");
    public static final RegistryObject<Block> ENERGY_INPUT_PORT = faced("energy_input_port");
    public static final RegistryObject<Block> REDSTONE_PORT = faced("redstone_port");

    public static final List<RegistryObject<Block>> CASINGS = List.of(CONCRETE, FACTORY_BLOCK, IRON_CASING, COPPER_CASING, WOODEN_CASING);
    public static final List<RegistryObject<Block>> CONTROLLERS = List.of(BEDROCK_EXTRACTOR, TITANIC_CRUSHER, SMELTING_COMPLEX,
            MODULAR_FOUNDRY, BIODOME, REPLICATION_BIOREACTOR, HYDROELECTRIC_CASCADE, GENOME_ANALYZER, SINGULARITY_PRESS);
    public static final List<RegistryObject<Block>> PORTS = List.of(ITEM_INPUT_PORT, ITEM_OUTPUT_PORT, FLUID_INPUT_PORT,
            FLUID_OUTPUT_PORT, ENERGY_INPUT_PORT, REDSTONE_PORT);

    private static RegistryObject<Block> plain(String name, MapColor color, float hardness) {
        return register(name, () -> new Block(BlockBehaviour.Properties.of().mapColor(color).strength(hardness, 6.0f).requiresCorrectToolForDrops()));
    }

    private static RegistryObject<Block> faced(String name) {
        return register(name, () -> new FacedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                .strength(4.0f, 6.0f).requiresCorrectToolForDrops()));
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> block) {
        RegistryObject<Block> result = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(result.get(), new Item.Properties()));
        return result;
    }

    private ModBlocks() {}
}
