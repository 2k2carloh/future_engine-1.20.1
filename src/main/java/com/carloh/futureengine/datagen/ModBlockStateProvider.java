package com.carloh.futureengine.datagen;

import com.carloh.futureengine.FutureEngine;
import com.carloh.futureengine.blocks.Modblock;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FutureEngine.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(Modblock.URANIUM_BLOCK);
        blockWithItem(Modblock.RAW_URANIUM_ORE);
        blockWithItem(Modblock.RAW_PLATINUM_ORE);
        blockWithItem(Modblock.RAW_TUNGSTEN_ORE);
        blockWithItem(Modblock.PINE_PLANKS);
        blockWithItem(Modblock.URANIUM_ORE);

        stairsBlock(((StairBlock) Modblock.PINE_STAIRS.get()), blockTexture(Modblock.PINE_PLANKS.get()));
        slabBlock(((SlabBlock) Modblock.PINE_SLAB.get()), blockTexture(Modblock.PINE_PLANKS.get()), blockTexture(Modblock.PINE_PLANKS.get()));
        buttonBlock(((ButtonBlock) Modblock.PINE_BUTTON.get()), blockTexture(Modblock.PINE_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) Modblock.PINE_PRESSURE_PLATE.get()), blockTexture(Modblock.PINE_PLANKS.get()));
        fenceBlock(((FenceBlock) Modblock.PINE_FENCE.get()), blockTexture(Modblock.PINE_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) Modblock.PINE_FENCE_GATE.get()), blockTexture(Modblock.PINE_PLANKS.get()));
        wallBlock(((WallBlock) Modblock.PINE_WALL.get()), blockTexture(Modblock.PINE_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) Modblock.PINE_DOOR.get()), modLoc("block/pine_door_bottom"), modLoc("block/pine_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) Modblock.PINE_TRAPDOOR.get()), modLoc("block/pine_trapdoor"), true,"cutout");

        logBlock(Modblock.PINE_LOG, modLoc("block/pine_log"), modLoc("block/up_pine_log"));
        logBlock(Modblock.RESINE_PINE_LOG, modLoc("block/resine_pine_log"), modLoc("block/up_pine_log"));
        logBlock(Modblock.STRIPPED_PINE_WOOD, modLoc("block/stripped_pine"), modLoc("block/stripped_pine"));
        logBlock(Modblock.STRIPPED_PINE_LOG, modLoc("block/stripped_pine"), modLoc("block/up_pine_log"));
        logBlock(Modblock.PINE_WOOD, modLoc("block/pine_log"), modLoc("block/pine_log"));

        orientableBlock(
                Modblock.SPRAYER,
                modLoc("block/sprayer_front"),
                modLoc("block/sprayer_sides"),
                modLoc("block/sprayer")
        );
    }

    public void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    public void orientableBlock(RegistryObject<Block> blockRegistryObject, ResourceLocation front, ResourceLocation side, ResourceLocation topBottom) {
        Block block = blockRegistryObject.get();
        ModelFile model = models().orientable(name(blockRegistryObject), side, front, topBottom);
        horizontalBlock(block, model);

        itemModels().getBuilder(name(blockRegistryObject)).parent(model);
    }

    public void axisBlock(RotatedPillarBlock block, ModelFile model) {
        getVariantBuilder(block).forAllStates(state -> {
            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationX(state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? 0 : 90)
                    .rotationY(state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.X ? 90 : 0)
                    .build();
        });
    }

    public void logBlock(RegistryObject<Block> blockRegistryObject, ResourceLocation side, ResourceLocation end) {
        String name = name(blockRegistryObject);
        ModelFile model = models().cubeColumn(name, side, end);

        axisBlock((RotatedPillarBlock) blockRegistryObject.get(), model);

        itemModels().getBuilder(name).parent(model);
    }

    private String name(RegistryObject<Block> blockRegistryObject) {
        return blockRegistryObject.getId().getPath();
    }
}
