package com.carloh.futureengine.datagen;

import com.carloh.futureengine.FutureEngine;
import com.carloh.futureengine.blocks.Modblock;
import com.carloh.futureengine.item.Moditems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
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

        simpleBlockItem(Modblock.PINE_DOOR);
        fenceItem(Modblock.PINE_FENCE, Modblock.PINE_PLANKS);
        buttonItem(Modblock.PINE_BUTTON, Modblock.PINE_PLANKS);
        wallItem(Modblock.PINE_WALL, Modblock.PINE_PLANKS);

        evenSimplerBlockItem(Modblock.PINE_STAIRS);
        evenSimplerBlockItem(Modblock.PINE_SLAB);
        evenSimplerBlockItem(Modblock.PINE_PRESSURE_PLATE);
        evenSimplerBlockItem(Modblock.PINE_FENCE_GATE);

        trapdoorItem(Modblock.PINE_TRAPDOOR);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FutureEngine.MODID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(FutureEngine.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(FutureEngine.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(FutureEngine.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(FutureEngine.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FutureEngine.MODID,"item/" + item.getId().getPath()));
    }

}
