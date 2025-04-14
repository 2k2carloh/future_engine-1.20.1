package com.carloh.futureengine.item;

import com.carloh.futureengine.FutureEngine;
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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Moditems.TESTING.get()))
                    .title(Component.translatable("futureenginetab.futureengine_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Moditems.TESTING.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
