package li.kallisto.kgnkallistoend.datagen.providers

import li.kallisto.kgnkallistoend.KGNKallistoEnd
import li.kallisto.kgnkallistoend.item.ModItems
import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.ItemModelGenerators
import net.minecraft.client.data.models.ModelProvider
import net.minecraft.client.data.models.model.ModelTemplates
import net.minecraft.core.Holder
import net.minecraft.data.PackOutput
import net.minecraft.world.item.Item
import java.util.stream.Stream

class ModModelProvider(output: PackOutput) : ModelProvider(output, KGNKallistoEnd.ID) {

    override fun registerModels(blockModels: BlockModelGenerators, itemModels: ItemModelGenerators) {
        ModItems.ITEMS.entries.forEach {
            itemModels.generateFlatItem(it.get(), ModelTemplates.FLAT_ITEM)
        }
    }

    override fun getKnownItems(): Stream<out Holder<Item?>?> {
        return ModItems.ITEMS.entries.stream().filter { true }
    }
}