package igentuman.giganticmachines.data;

import igentuman.giganticmachines.Main;
import igentuman.giganticmachines.registry.ModBlocks;
import igentuman.giganticmachines.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguage extends LanguageProvider {
    public ModLanguage(PackOutput output) {
        super(output, Main.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.giganticmachines.gigantic_machines", "Gigantic Machines");
        add(ModBlocks.CONCRETE.get(), "Concrete");
        add(ModBlocks.FACTORY_BLOCK.get(), "Factory Block");
        add(ModBlocks.IRON_CASING.get(), "Iron Casing");
        add(ModBlocks.COPPER_CASING.get(), "Copper Casing");
        add(ModBlocks.WOODEN_CASING.get(), "Wooden Casing");
        add(ModBlocks.BEDROCK_EXTRACTOR.get(), "Bedrock Extractor");
        add(ModBlocks.TITANIC_CRUSHER.get(), "Titanic Crusher");
        add(ModBlocks.SMELTING_COMPLEX.get(), "Smelting Complex");
        add(ModBlocks.MODULAR_FOUNDRY.get(), "Modular Foundry");
        add(ModBlocks.BIODOME.get(), "Biodome");
        add(ModBlocks.REPLICATION_BIOREACTOR.get(), "Replication Bioreactor");
        add(ModBlocks.HYDROELECTRIC_CASCADE.get(), "Hydroelectric Cascade");
        add(ModBlocks.GENOME_ANALYZER.get(), "Genome Analyzer");
        add(ModBlocks.SINGULARITY_PRESS.get(), "Singularity Press");
        add(ModBlocks.ITEM_INPUT_PORT.get(), "Item Input Port");
        add(ModBlocks.ITEM_OUTPUT_PORT.get(), "Item Output Port");
        add(ModBlocks.FLUID_INPUT_PORT.get(), "Fluid Input Port");
        add(ModBlocks.FLUID_OUTPUT_PORT.get(), "Fluid Output Port");
        add(ModBlocks.ENERGY_INPUT_PORT.get(), "Energy Input Port");
        add(ModBlocks.REDSTONE_PORT.get(), "Redstone Port");
        add(ModItems.WRENCH.get(), "Wrench");
        add(ModItems.DNA_SAMPLE.get(), "DNA Sample");
    }
}
