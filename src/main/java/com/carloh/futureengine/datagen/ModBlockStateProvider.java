package com.carloh.futureengine.datagen;

import com.carloh.futureengine.FutureEngine;
import com.carloh.futureengine.blocks.Modblock;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.resources.ResourceLocation;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FutureEngine.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        // Registra los bloques normales con item
        blockWithItem(Modblock.URANIUM_BLOCK);
        blockWithItem(Modblock.RAW_URANIUM_ORE);
        blockWithItem(Modblock.RAW_PLATINUM_ORE);
        blockWithItem(Modblock.RAW_TUNGSTEN_ORE);
        blockWithItem(Modblock.PINE_LOG);
        blockWithItem(Modblock.PINE_PLANKS);
        blockWithItem(Modblock.RESINE_PINE_LOG);
        blockWithItem(Modblock.URANIUM_ORE);

        orientableBlock(
                Modblock.SPRAYER,
                    new ResourceLocation(FutureEngine.MODID, "block/sprayer_front"),
                    new ResourceLocation(FutureEngine.MODID, "block/sprayer_sides"),
                    new ResourceLocation(FutureEngine.MODID, "block/sprayer")
        );

        orientableBlock(
                Modblock.STRIPPED_PINE_WOOD,
                new ResourceLocation(FutureEngine.MODID, "block/stripped_pine"),
                new ResourceLocation(FutureEngine.MODID, "block/stripped_pine"),
                new ResourceLocation(FutureEngine.MODID, "block/stripped_pine")
        );
    }

    public void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    public void orientableBlock(RegistryObject<Block> blockRegistryObject, ResourceLocation front, ResourceLocation side, ResourceLocation topBottom) {
        Block block = blockRegistryObject.get();

        this.models().orientable(
                name(blockRegistryObject),
                side,
                front,
                topBottom
        );

        this.horizontalBlock(block, models().orientable(name(blockRegistryObject), side, front, topBottom));

        itemModels().getBuilder(name(blockRegistryObject))
                .parent(models().getBuilder(name(blockRegistryObject)));
    }

    private String name(RegistryObject<Block> blockRegistryObject) {
        return blockRegistryObject.getId().getPath();
    }
}
