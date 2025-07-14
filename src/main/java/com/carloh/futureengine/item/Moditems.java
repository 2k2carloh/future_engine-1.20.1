package com.carloh.futureengine.item;

import com.carloh.futureengine.FutureEngine;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {

    //test push

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

    //raws

    public static final RegistryObject<Item> URANIUM_RAW = ITEMS.register("uranium_raw",
            () -> new Item(new Item.Properties()));

    //ingots
    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot",
            () -> new Item(new Item.Properties()));

    //dusts

    public static final RegistryObject<Item> URANIUM_DUST = ITEMS.register("uranium_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLATINUM_DUST = ITEMS.register("platinum_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BRONZE_DUST = ITEMS.register("bronze_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TUNGSTEN_DUST = ITEMS.register("tungsten_dust",
            () -> new Item(new Item.Properties().stacksTo(1)));

    //3D
    public static final RegistryObject<Item> TREETAP = ITEMS.register("treetap",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
