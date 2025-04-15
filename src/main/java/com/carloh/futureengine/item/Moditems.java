package com.carloh.futureengine.item;

import com.carloh.futureengine.FutureEngine;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FutureEngine.MODID);

    public static final RegistryObject<Item> LOWRESISTANCECHIP = ITEMS.register("low_resistance_chip",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COPPERWIRE = ITEMS.register("copper_wire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RESINE = ITEMS.register("resine",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RUBBER = ITEMS.register("rubber",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
