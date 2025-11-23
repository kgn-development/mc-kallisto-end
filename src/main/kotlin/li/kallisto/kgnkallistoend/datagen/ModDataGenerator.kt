package li.kallisto.kgnkallistoend.datagen

import li.kallisto.kgnkallistoend.datagen.providers.ModLootModifierProvider
import li.kallisto.kgnkallistoend.datagen.providers.ModModelProvider
import li.kallisto.kgnkallistoend.datagen.providers.ModRecipeProvider
import net.neoforged.neoforge.data.event.GatherDataEvent

object ModDataGenerator {
    fun onGatherClientData(event: GatherDataEvent.Client) {
        val generator = event.generator
        val packOutput = generator.packOutput
        val lookupProvider = event.lookupProvider

        generator.addProvider(true, ModModelProvider(packOutput))
        generator.addProvider(true, ModRecipeProvider.Runner(packOutput, lookupProvider))
        generator.addProvider(true, ModLootModifierProvider(packOutput, lookupProvider))
    }
}