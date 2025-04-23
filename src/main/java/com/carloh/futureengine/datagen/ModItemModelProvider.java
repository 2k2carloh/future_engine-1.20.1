package com.carloh.futureengine.datagen;

import com.carloh.futureengine.FutureEngine;
import com.carloh.futureengine.item.Moditems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FutureEngine.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(Moditems.LOWRESISTANCECHIP);
        simpleItem(Moditems.COPPERWIRE);
        simpleItem(Moditems.RESINE);
        simpleItem(Moditems.RUBBER);
        simpleItem(Moditems.URANIUM_RAW);
        simpleItem(Moditems.URANIUM_INGOT);
        simpleItem(Moditems.PLATINUM_INGOT);
        simpleItem(Moditems.BRONZE_INGOT);
        simpleItem(Moditems.TUNGSTEN_INGOT);
        simpleItem(Moditems.URANIUM_DUST);
        simpleItem(Moditems.PLATINUM_DUST);
        simpleItem(Moditems.BRONZE_DUST);
        simpleItem(Moditems.TUNGSTEN_DUST);


    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FutureEngine.MODID, "item/" + item.getId().getPath()));
    }
}
