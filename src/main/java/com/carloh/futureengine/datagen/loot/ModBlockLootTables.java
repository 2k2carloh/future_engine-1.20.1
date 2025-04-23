package com.carloh.futureengine.datagen.loot;

import com.carloh.futureengine.blocks.Modblock;
import com.carloh.futureengine.item.Moditems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(Modblock.URANIUM_BLOCK.get());
        this.dropSelf(Modblock.RAW_URANIUM_ORE.get());
        this.dropSelf(Modblock.RAW_PLATINUM_ORE.get());
        this.dropSelf(Modblock.RAW_TUNGSTEN_ORE.get());
        this.dropSelf(Modblock.PINE_LOG.get());
//        this.dropSelf(Modblock.PINE_WOOD.get());
//        this.dropSelf(Modblock.STRIPPED_PINE_LOG.get());
        this.dropSelf(Modblock.STRIPPED_PINE_WOOD.get());
        this.dropSelf(Modblock.RESINE_PINE_LOG.get());
        this.dropSelf(Modblock.PINE_PLANKS.get());
        this.dropSelf(Modblock.SPRAYER.get());
        this.add(Modblock.URANIUM_ORE.get(),
                block -> createCopperLikeOreDrops(Modblock.URANIUM_ORE.get(), Moditems.URANIUM_RAW.get()));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                (LootPoolEntryContainer.Builder)this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Modblock.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
