package li.kallisto.kgnkallistoend.datagen.providers

import li.kallisto.kgnkallistoend.KGNKallistoEnd
import li.kallisto.kgnkallistoend.item.ModItems
import li.kallisto.kgnkallistoend.loot.AddContainerLootModifier
import li.kallisto.kgnkallistoend.loot.AddEntityLootModifier
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider
import net.neoforged.neoforge.common.loot.LootTableIdCondition
import net.neoforged.neoforge.registries.DeferredItem
import java.util.concurrent.CompletableFuture


class ModLootModifierProvider(
    output: PackOutput, lookup: CompletableFuture<HolderLookup.Provider>
) : GlobalLootModifierProvider(output, lookup, KGNKallistoEnd.ID) {

    override fun start() {
        addEntityLoot("entities/ravager", ModItems.RAID_SOUL, 0.33f, 0f)
        addEntityLoot("entities/wither", ModItems.NETHER_SOUL, 1f, 0f)
        addEntityLoot("entities/elder_guardian", ModItems.OCEAN_SOUL, 1f, 0f)

        addContainerLoot("chests/buried_treasure", ModItems.TREASURE_ARTEFACT, 0.2f)
        addEntityLoot("entities/creaking", ModItems.PETRIFIED_ARTEFACT, 1f)
        addContainerLoot("chests/igloo_chest", ModItems.FROZEN_ARTEFACT, 0.6f)
    }

    fun addContainerLoot(vanillaLootTable: String, item: DeferredItem<Item>, chance: Float) {
        add(
            "${vanillaLootTable}_${item.key?.location()?.path}", AddContainerLootModifier(
                arrayOf(
                    LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace(vanillaLootTable))
                        .build(),
                ),
                item.get(),
                chance
            )
        )
    }

    fun addEntityLoot(
        vanillaLootTable: String,
        item: DeferredItem<Item>,
        baseChance: Float,
        lootingBonus: Float? = null
    ) {
        add(
            "${vanillaLootTable}_${item.key?.location()?.path}", AddEntityLootModifier(
                arrayOf(
                    LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace(vanillaLootTable))
                        .build(),
                ),
                item.get(),
                baseChance,
                lootingBonus ?: baseChance
            )
        )
    }
}

