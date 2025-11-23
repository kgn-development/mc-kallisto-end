package li.kallisto.kgnkallistoend

import li.kallisto.kgnkallistoend.datagen.ModDataGenerator
import li.kallisto.kgnkallistoend.item.ModCreativeModeTabs
import li.kallisto.kgnkallistoend.item.ModItems
import li.kallisto.kgnkallistomusic.loot.ModLootModifiers
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.npc.VillagerProfession
import net.minecraft.world.entity.npc.VillagerTrades
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.item.trading.ItemCost
import net.minecraft.world.item.trading.MerchantOffer
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.common.NeoForge
import net.neoforged.neoforge.event.village.VillagerTradesEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.neoforge.forge.runForDist

@Mod(KGNKallistoEnd.ID)
object KGNKallistoEnd {
    const val ID = "kgnkallistoend"

    val LOGGER: Logger = LogManager.getLogger(ID)

    init {
        LOGGER.log(Level.INFO, "initializing ${ID}")

        ModItems.register(MOD_BUS)
        ModLootModifiers.register(MOD_BUS)
        ModCreativeModeTabs.register(MOD_BUS)

        MOD_BUS.addListener(ModDataGenerator::onGatherClientData)

        NeoForge.EVENT_BUS.addListener(::addCustomTrades)

        runForDist(clientTarget = {

        }, serverTarget = {

        })
    }

    fun addCustomTrades(event: VillagerTradesEvent) {
        if (event.getType() === VillagerProfession.CLERIC) {
            val trades = event.getTrades()

            trades.get(5).add(VillagerTrades.ItemListing { _, _ ->
                MerchantOffer(
                    ItemCost(Items.EMERALD, 32),
                    ItemStack(ModItems.WALLET_OF_HERMES.get(), 1), 1, 100, 0.05f
                )
            })
        }
    }

    fun locate(name: String): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(ID, name)
    }
}
