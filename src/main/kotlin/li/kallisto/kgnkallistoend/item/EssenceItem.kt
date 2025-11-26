package li.kallisto.kgnkallistoend.item

import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack

class EssenceItem(properties: Properties) : Item(properties) {
    override fun isFoil(stack: ItemStack): Boolean {
        return true;
    }
}