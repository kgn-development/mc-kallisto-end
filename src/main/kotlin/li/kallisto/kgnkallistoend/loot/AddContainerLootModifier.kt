package li.kallisto.kgnkallistomusic.loot

import com.mojang.serialization.Codec
import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import it.unimi.dsi.fastutil.objects.ObjectArrayList
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.storage.loot.LootContext
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition
import net.neoforged.neoforge.common.loot.IGlobalLootModifier
import net.neoforged.neoforge.common.loot.LootModifier

class AddContainerLootModifier(
    conditionsIn: Array<LootItemCondition?>,
    private val item: Item,
    private val chance: Float
) :
    LootModifier(conditionsIn) {
    override fun doApply(
        generatedLoot: ObjectArrayList<ItemStack?>, lootContext: LootContext
    ): ObjectArrayList<ItemStack?> {
        if (conditions.any { !it.test(lootContext) }) return generatedLoot

        if (lootContext.random.nextFloat() < chance) {
            generatedLoot.add(ItemStack(this.item))
        }

        return generatedLoot
    }

    override fun codec(): MapCodec<out IGlobalLootModifier?> {
        return CODEC
    }

    companion object {
        val CODEC: MapCodec<AddContainerLootModifier?> = RecordCodecBuilder.mapCodec { inst ->
            codecStart(inst)
                .and(BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter { it?.item })
                .and(Codec.FLOAT.fieldOf("chance").forGetter { it?.chance ?: 0.0f })
                .apply(inst) { conditionsIn, item, chance -> AddContainerLootModifier(conditionsIn, item, chance) }
        }
    }
}