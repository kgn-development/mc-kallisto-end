package li.kallisto.kgnkallistoend.item

import li.kallisto.kgnkallistoend.KGNKallistoEnd
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.Item
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister

object ModItems {
    val ITEMS = DeferredRegister.createItems(KGNKallistoEnd.ID)

    val EXTINGUISHED_EYE_OF_ENDER =
        ITEMS.registerItem("extinguished_eye_of_ender") { properties -> Item(properties.setItemModId("extinguished_eye_of_ender")) }

    val ESSENCE_OF_SOUL =
        ITEMS.registerItem("essence_of_soul") { properties -> Item(properties.setItemModId("essence_of_soul")) }
    val TRIAL_SOUL = ITEMS.registerItem("trial_soul") { properties -> Item(properties.setItemModId("trial_soul")) }
    val RAID_SOUL = ITEMS.registerItem("raid_soul") { properties -> Item(properties.setItemModId("raid_soul")) }
    val NETHER_SOUL = ITEMS.registerItem("nether_soul") { properties -> Item(properties.setItemModId("nether_soul")) }
    val OCEAN_SOUL = ITEMS.registerItem("ocean_soul") { properties -> Item(properties.setItemModId("ocean_soul")) }

    val ESSENCE_OF_WISDOM =
        ITEMS.registerItem("essence_of_wisdom") { properties -> Item(properties.setItemModId("essence_of_wisdom")) }
    val TREASURE_ARTEFACT =
        ITEMS.registerItem("treasure_artefact") { properties -> Item(properties.setItemModId("treasure_artefact")) }
    val ANCIENT_ARTEFACT =
        ITEMS.registerItem("ancient_artefact") { properties -> Item(properties.setItemModId("ancient_artefact")) }
    val PETRIFIED_ARTEFACT =
        ITEMS.registerItem("petrified_artefact") { properties -> Item(properties.setItemModId("petrified_artefact")) }
    val FROZEN_ARTEFACT =
        ITEMS.registerItem("frozen_artefact") { properties -> Item(properties.setItemModId("frozen_artefact")) }

    val ESSENCE_OF_MIGHT =
        ITEMS.registerItem("essence_of_might") { properties -> Item(properties.setItemModId("essence_of_might")) }
    val WALLET_OF_HERMES =
        ITEMS.registerItem("wallet_of_hermes") { properties -> Item(properties.setItemModId("wallet_of_hermes")) }
    val MEAL_OF_CERES =
        ITEMS.registerItem("meal_of_ceres") { properties -> Item(properties.setItemModId("meal_of_ceres")) }
    val LANTERN_OF_HEL =
        ITEMS.registerItem("lantern_of_hel") { properties -> Item(properties.setItemModId("lantern_of_hel")) }
    val SEEDBAG_OF_OSIRIS =
        ITEMS.registerItem("seedbag_of_osiris") { properties -> Item(properties.setItemModId("seedbag_of_osiris")) }

    val ESSENCE_OF_HEARTH =
        ITEMS.registerItem("essence_of_hearth") { properties -> Item(properties.setItemModId("essence_of_hearth")) }
    val SHEPHERDS_HEARTH =
        ITEMS.registerItem("shepherds_hearth") { properties -> Item(properties.setItemModId("shepherds_hearth")) }
    val MINERS_HEARTH =
        ITEMS.registerItem("miners_hearth") { properties -> Item(properties.setItemModId("miners_hearth")) }
    val NETHERS_HEARTH =
        ITEMS.registerItem("nethers_hearth") { properties -> Item(properties.setItemModId("nethers_hearth")) }
    val WORLDS_HEARTH =
        ITEMS.registerItem("worlds_hearth") { properties -> Item(properties.setItemModId("worlds_hearth")) }


    fun Item.Properties.setItemModId(name: String): Item.Properties {
        return this.setId(ResourceKey.create(Registries.ITEM, KGNKallistoEnd.locate(name)))
    }

    fun register(eventBus: IEventBus) {
        ITEMS.register(eventBus)
    }
}

