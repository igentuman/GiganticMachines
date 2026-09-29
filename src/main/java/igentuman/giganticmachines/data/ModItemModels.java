package igentuman.giganticmachines.data;

import igentuman.giganticmachines.Main;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModels extends ItemModelProvider {
    public ModItemModels(PackOutput output, ExistingFileHelper helper) {
        super(output, Main.MODID, helper);
    }

    @Override
    protected void registerModels() {
        singleTexture("wrench", mcLoc("item/generated"), "layer0", modLoc("item/wrench"));
        singleTexture("dna_sample", mcLoc("item/generated"), "layer0", modLoc("item/dna_sample"));
    }
}
