package li.kallisto.kgnkallistoend.item

import li.kallisto.kgnkallistoend.KGNKallistoEnd
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister

object ModCreativeModeTabs {
    val CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KGNKallistoEnd.ID)

    val KALLISTO_END_TAB = CREATIVE_MODE_TAB.register(
        "${KGNKallistoEnd.ID}_tab"
    ) { _ ->
        CreativeModeTab.builder()
            .icon { ItemStack(Items.ENDER_EYE) }
            .title(Component.translatable("creativetab.${KGNKallistoEnd.ID}.kallisto_end_tab"))
            .displayItems { _, output ->
                ModItems.ITEMS.entries.forEach {
                    output.accept(it.get())
                }
            }
            .build()
    }

    fun register(eventBus: IEventBus) {
        CREATIVE_MODE_TAB.register(eventBus)
    }
}