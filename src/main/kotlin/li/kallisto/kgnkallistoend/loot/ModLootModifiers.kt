package li.kallisto.kgnkallistoend.loot

import com.mojang.serialization.MapCodec
import li.kallisto.kgnkallistoend.KGNKallistoEnd
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.common.loot.IGlobalLootModifier
import net.neoforged.neoforge.registries.DeferredRegister
import net.neoforged.neoforge.registries.NeoForgeRegistries
import java.util.function.Supplier


object ModLootModifiers {
    val LOOT_MODIFIER_SERIALIZERS: DeferredRegister<MapCodec<out IGlobalLootModifier?>?> =
        DeferredRegister.create(
            NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS,
            KGNKallistoEnd.ID
        )

    val CONTAINER =
        LOOT_MODIFIER_SERIALIZERS.register("add_container", Supplier { AddContainerLootModifier.Companion.CODEC })
    val ENTITY = LOOT_MODIFIER_SERIALIZERS.register("add_entity", Supplier { AddEntityLootModifier.Companion.CODEC })

    fun register(eventBus: IEventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus)
    }
}