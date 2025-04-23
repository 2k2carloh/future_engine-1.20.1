package com.carloh.futureengine.datagen;

import com.carloh.futureengine.FutureEngine;
import com.carloh.futureengine.blocks.Modblock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FutureEngine.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Modblock.URANIUM_BLOCK.get(),
                        Modblock.URANIUM_ORE.get(),
                        Modblock.RAW_URANIUM_ORE.get(),
                        Modblock.RAW_PLATINUM_ORE.get(),
                        Modblock.RAW_TUNGSTEN_ORE.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(Modblock.RAW_PLATINUM_ORE.get(),
                            Modblock.RAW_TUNGSTEN_ORE.get()
                        );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(Modblock.URANIUM_BLOCK.get(),
                        Modblock.URANIUM_ORE.get(),
                        Modblock.RAW_URANIUM_ORE.get()
                );

        //this.tag(BlockTags.NEEDS_STONE_TOOL)

    }
}
