package com.carloh.futureengine.item;

import com.carloh.futureengine.FutureEngine;
import com.carloh.futureengine.blocks.Modblock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FutureEngine.MODID);

    public static final RegistryObject<CreativeModeTab> FUTUREENGINE_TAB = CREATIVE_MODE_TAB.register("futureengine_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Moditems.LOWRESISTANCECHIP.get()))
                    .title(Component.translatable("futureenginetab.futureengine_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Moditems.LOWRESISTANCECHIP.get());
                        output.accept(Moditems.COPPERWIRE.get());
                        output.accept(Moditems.RESINE.get());
                        output.accept(Moditems.RUBBER.get());

                        //raws
                        output.accept(Moditems.URANIUM_RAW.get());

                        //ingots
                        output.accept(Moditems.URANIUM_INGOT.get());
                        output.accept(Moditems.PLATINUM_INGOT.get());
                        output.accept(Moditems.BRONZE_INGOT.get());
                        output.accept(Moditems.TUNGSTEN_INGOT.get());

                        //dust
                        output.accept(Moditems.URANIUM_DUST.get());
                        output.accept(Moditems.PLATINUM_DUST.get());
                        output.accept(Moditems.BRONZE_DUST.get());
                        output.accept(Moditems.TUNGSTEN_DUST.get());

                        output.accept(Modblock.URANIUM_BLOCK.get());
                        output.accept(Modblock.URANIUM_ORE.get());

                        //raws
                        output.accept(Modblock.RAW_URANIUM_ORE.get());
                        output.accept(Modblock.RAW_PLATINUM_ORE.get());
                        output.accept(Modblock.RAW_TUNGSTEN_ORE.get());

                        //machines
                        output.accept(Modblock.SPRAYER.get());

                        //woods
                        output.accept(Modblock.PINE_LOG.get());
                        output.accept(Modblock.PINE_WOOD.get());
                        output.accept(Modblock.STRIPPED_PINE_LOG.get());
                        output.accept(Modblock.STRIPPED_PINE_WOOD.get());
                        output.accept(Modblock.PINE_PLANKS.get());
                        output.accept(Modblock.RESINE_PINE_LOG.get());

                        output.accept(Modblock.PINE_BUTTON.get());
                        output.accept(Modblock.PINE_STAIRS.get());
                        output.accept(Modblock.PINE_SLAB.get());
                        output.accept(Modblock.PINE_TRAPDOOR.get());
                        output.accept(Modblock.PINE_FENCE_GATE.get());
                        output.accept(Modblock.PINE_FENCE.get());
                        output.accept(Modblock.PINE_DOOR.get());
                        output.accept(Modblock.PINE_PRESSURE_PLATE.get());
                        output.accept(Modblock.PINE_WALL.get());

                        output.accept(Moditems.TREETAP.get());

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
