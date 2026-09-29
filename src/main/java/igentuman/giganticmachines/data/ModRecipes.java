package igentuman.giganticmachines.data;

import igentuman.giganticmachines.registry.ModBlocks;
import igentuman.giganticmachines.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class ModRecipes extends RecipeProvider {
    public ModRecipes(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CONCRETE.get(), 4)
                .pattern("SG").pattern("GS")
                .define('S', Items.STONE).define('G', Items.GRAVEL)
                .unlockedBy("has_stone", has(Items.STONE)).save(output);
        casing(output, ModBlocks.IRON_CASING.get(), Items.IRON_INGOT);
        casing(output, ModBlocks.COPPER_CASING.get(), Items.COPPER_INGOT);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WOODEN_CASING.get(), 4)
                .pattern("PPP").pattern("PCP").pattern("PPP")
                .define('P', ItemTags.PLANKS).define('C', ModBlocks.CONCRETE.get())
                .unlockedBy("has_concrete", has(ModBlocks.CONCRETE.get())).save(output);

        controller(output, ModBlocks.BEDROCK_EXTRACTOR.get(), Items.DIAMOND_PICKAXE);
        controller(output, ModBlocks.TITANIC_CRUSHER.get(), Items.PISTON);
        controller(output, ModBlocks.SMELTING_COMPLEX.get(), Items.BLAST_FURNACE);
        controller(output, ModBlocks.MODULAR_FOUNDRY.get(), Items.CAULDRON);
        controller(output, ModBlocks.BIODOME.get(), Items.OAK_SAPLING);
        controller(output, ModBlocks.REPLICATION_BIOREACTOR.get(), Items.BREWING_STAND);
        controller(output, ModBlocks.HYDROELECTRIC_CASCADE.get(), Items.WATER_BUCKET);
        controller(output, ModBlocks.GENOME_ANALYZER.get(), Items.SPYGLASS);
        controller(output, ModBlocks.SINGULARITY_PRESS.get(), Items.ANVIL);

        port(output, ModBlocks.ITEM_INPUT_PORT.get(), Items.HOPPER, false);
        port(output, ModBlocks.ITEM_OUTPUT_PORT.get(), Items.HOPPER, true);
        port(output, ModBlocks.FLUID_INPUT_PORT.get(), Items.BUCKET, false);
        port(output, ModBlocks.FLUID_OUTPUT_PORT.get(), Items.BUCKET, true);
        port(output, ModBlocks.ENERGY_INPUT_PORT.get(), Items.REDSTONE_BLOCK, false);
        port(output, ModBlocks.REDSTONE_PORT.get(), Items.REPEATER, false);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WRENCH.get())
                .pattern("I I").pattern(" II").pattern("  S")
                .define('I', Items.IRON_INGOT).define('S', Items.STICK)
                .unlockedBy("has_iron", has(Items.IRON_INGOT)).save(output);
    }

    private void casing(Consumer<FinishedRecipe> output, Block result, Item material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 4)
                .pattern("MMM").pattern("MCM").pattern("MMM")
                .define('M', material).define('C', ModBlocks.CONCRETE.get())
                .unlockedBy("has_concrete", has(ModBlocks.CONCRETE.get())).save(output);
    }

    private void controller(Consumer<FinishedRecipe> output, Block result, ItemLike component) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern("ICI").pattern("CRC").pattern("ICI")
                .define('I', Items.IRON_INGOT).define('C', ModBlocks.IRON_CASING.get())
                .define('R', component)
                .unlockedBy("has_iron_casing", has(ModBlocks.IRON_CASING.get())).save(output);
    }

    private void port(Consumer<FinishedRecipe> output, Block result, ItemLike component, boolean outputPort) {
        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result)
                .requires(ModBlocks.IRON_CASING.get()).requires(component)
                .unlockedBy("has_iron_casing", has(ModBlocks.IRON_CASING.get()));
        if (outputPort) builder.requires(Items.REDSTONE);
        builder.save(output);
    }
}
