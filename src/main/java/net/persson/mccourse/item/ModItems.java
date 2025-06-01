package net.persson.mccourse.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.persson.mccourse.MCCourseMod;

public class ModItems
{

    public static final Item REFINED_BESKAR = RegisterItem("refined_beskar", new Item(new FabricItemSettings()));
    public static final Item UNREFINED_BESKAR = RegisterItem("unrefined_beskar", new Item(new FabricItemSettings()));

    private static Item RegisterItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(MCCourseMod.MOD_ID, name), item);
    }

    private static void ItemGroupIngredients(FabricItemGroupEntries entries)
    {
        entries.add(REFINED_BESKAR);
        entries.add(UNREFINED_BESKAR);
    }

    public static void RegisterModItems()
    {
        MCCourseMod.LOGGER.info("Registering Mod Items for " + MCCourseMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::ItemGroupIngredients);
    }
}
