package li.kallisto.kgnkallistomusic.loot

import com.mojang.serialization.Codec
import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import it.unimi.dsi.fastutil.objects.ObjectArrayList
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.Enchantments
import net.minecraft.world.level.storage.loot.LootContext
import net.minecraft.world.level.storage.loot.parameters.LootContextParams
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition
import net.neoforged.neoforge.common.loot.IGlobalLootModifier
import net.neoforged.neoforge.common.loot.LootModifier

class AddEntityLootModifier(
    conditionsIn: Array<LootItemCondition?>,
    private val item: Item,
    private val baseChance: Float,
    private val lootingBonus: Float // extra chance per looting level
) : LootModifier(conditionsIn) {

    override fun doApply(
        generatedLoot: ObjectArrayList<ItemStack?>,
        lootContext: LootContext
    ): ObjectArrayList<ItemStack?> {

        if (conditions.any { !it.test(lootContext) }) return generatedLoot

        val enchantmentRegistry = lootContext.level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT)
        val lootingHolder = enchantmentRegistry.getOrThrow(Enchantments.LOOTING)
        val tool = lootContext.getOptionalParameter(LootContextParams.TOOL)
        val killer = lootContext.getOptionalParameter(LootContextParams.ATTACKING_ENTITY)
        val weapon = tool ?: (killer as? LivingEntity)?.mainHandItem
        val lootingLevel = weapon?.getEnchantmentLevel(lootingHolder)
            ?: 0

        val effectiveChance = baseChance + (lootingLevel * lootingBonus)
        if (lootContext.random.nextFloat() < effectiveChance) {
            generatedLoot.add(ItemStack(item))
        }

        return generatedLoot
    }

    override fun codec(): MapCodec<out IGlobalLootModifier> = CODEC

    companion object {
        val CODEC: MapCodec<AddEntityLootModifier> = RecordCodecBuilder.mapCodec { inst ->
            codecStart(inst)
                .and(BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter { it.item })
                .and(Codec.FLOAT.fieldOf("baseChance").forGetter { it.baseChance })
                .and(Codec.FLOAT.fieldOf("lootingBonus").forGetter { it.lootingBonus })
                .apply(inst, ::AddEntityLootModifier)
        }
    }
}