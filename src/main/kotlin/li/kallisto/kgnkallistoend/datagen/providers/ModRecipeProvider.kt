package li.kallisto.kgnkallistoend.datagen.providers

import li.kallisto.kgnkallistoend.item.ModItems
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.tags.ItemTags
import net.minecraft.world.item.Items
import java.util.concurrent.CompletableFuture

class ModRecipeProvider(registries: HolderLookup.Provider, output: RecipeOutput) : RecipeProvider(registries, output) {
    override fun buildRecipes() {
        shaped(RecipeCategory.DECORATIONS, Items.ENDER_CHEST)
            .define('O', Items.OBSIDIAN)
            .define('B', Items.BLAZE_POWDER)
            .define('P', Items.ENDER_PEARL)
            .pattern("OBO")
            .pattern("OPO")
            .pattern("OOO")
            .unlockedBy("has_blaze_powder", has(Items.BLAZE_POWDER))
            .unlockedBy("has_ender_pearl", has(Items.ENDER_PEARL))
            .save(output)

        shaped(RecipeCategory.MISC, Items.ENDER_EYE, 16)
            .define('S', ModItems.ESSENCE_OF_SOUL)
            .define('W', ModItems.ESSENCE_OF_WISDOM)
            .define('M', ModItems.ESSENCE_OF_MIGHT)
            .define('H', ModItems.ESSENCE_OF_HEARTH)
            .define('E', ModItems.EXTINGUISHED_EYE_OF_ENDER)
            .pattern("S W")
            .pattern(" E ")
            .pattern("M H")
            .unlockedBy("has_essence_of_soul", has(ModItems.ESSENCE_OF_SOUL))
            .unlockedBy("has_essence_of_wisdom", has(ModItems.ESSENCE_OF_WISDOM))
            .unlockedBy("has_essence_of_might", has(ModItems.ESSENCE_OF_MIGHT))
            .unlockedBy("has_essence_of_hearth", has(ModItems.ESSENCE_OF_HEARTH))
            .save(output)

        shaped(RecipeCategory.MISC, ModItems.ESSENCE_OF_SOUL)
            .define('T', ModItems.TRIAL_SOUL)
            .define('R', ModItems.RAID_SOUL)
            .define('N', ModItems.NETHER_SOUL)
            .define('O', ModItems.OCEAN_SOUL)
            .pattern(" T ")
            .pattern("R N")
            .pattern(" O ")
            .unlockedBy("has_trial_soul", has(ModItems.TRIAL_SOUL))
            .unlockedBy("has_raid_soul", has(ModItems.RAID_SOUL))
            .unlockedBy("has_nether_soul", has(ModItems.NETHER_SOUL))
            .unlockedBy("has_ocean_soul", has(ModItems.OCEAN_SOUL))
            .save(output)

        shaped(RecipeCategory.MISC, ModItems.ESSENCE_OF_WISDOM)
            .define('T', ModItems.TREASURE_ARTEFACT)
            .define('A', ModItems.ANCIENT_ARTEFACT)
            .define('P', ModItems.PETRIFIED_ARTEFACT)
            .define('F', ModItems.FROZEN_ARTEFACT)
            .pattern(" T ")
            .pattern("A P")
            .pattern(" F ")
            .unlockedBy("has_treasure_artefact", has(ModItems.TREASURE_ARTEFACT))
            .unlockedBy("has_ancient_artefact", has(ModItems.ANCIENT_ARTEFACT))
            .unlockedBy("has_petrified_artefact", has(ModItems.PETRIFIED_ARTEFACT))
            .unlockedBy("has_frozen_artefact", has(ModItems.FROZEN_ARTEFACT))
            .save(output)

        addEssenceOfMight()
        addEssenceOfHearth()
    }

    private fun addEssenceOfMight() {
        shaped(RecipeCategory.MISC, ModItems.ESSENCE_OF_MIGHT)
            .define('W', ModItems.WALLET_OF_HERMES)
            .define('M', ModItems.MEAL_OF_CERES)
            .define('L', ModItems.LANTERN_OF_HEL)
            .define('S', ModItems.SEEDBAG_OF_OSIRIS)
            .pattern(" W ")
            .pattern("M L")
            .pattern(" S ")
            .unlockedBy("has_wallet_of_hermes", has(ModItems.WALLET_OF_HERMES))
            .unlockedBy("has_meal_of_ceres", has(ModItems.MEAL_OF_CERES))
            .unlockedBy("has_lantern_of_hel", has(ModItems.LANTERN_OF_HEL))
            .unlockedBy("has_seedbag_of_osiris", has(ModItems.SEEDBAG_OF_OSIRIS))
            .save(output)

        shapeless(RecipeCategory.MISC, ModItems.MEAL_OF_CERES)
            .requires(Items.CAKE)
            .requires(Items.COOKIE)
            .requires(Items.MUSHROOM_STEW)
            .requires(Items.GOLDEN_APPLE)
            .requires(Items.GOLDEN_CARROT)
            .requires(Items.COOKED_BEEF)
            .requires(Items.PUMPKIN_PIE)
            .requires(Items.RABBIT_STEW)
            .requires(Items.HONEY_BOTTLE)
            .unlockedBy("has_cooked_beef", has(Items.COOKED_BEEF))
            .save(output)

        shaped(RecipeCategory.MISC, ModItems.LANTERN_OF_HEL)
            .define('L', Items.LANTERN)
            .define('O', Items.OCHRE_FROGLIGHT)
            .define('V', Items.VERDANT_FROGLIGHT)
            .define('P', Items.PEARLESCENT_FROGLIGHT)
            .pattern(" O ")
            .pattern("VLP")
            .unlockedBy("has_lantern", has(Items.LANTERN))
            .save(output)

        shapeless(RecipeCategory.MISC, ModItems.SEEDBAG_OF_OSIRIS)
            .requires(Items.WHEAT_SEEDS)
            .requires(Items.CARROT)
            .requires(Items.BEETROOT)
            .requires(Items.POTATO)
            .requires(Items.SWEET_BERRIES)
            .requires(Items.MELON_SEEDS)
            .requires(Items.PUMPKIN_SEEDS)
            .requires(Items.GLOW_BERRIES)
            .requires(Items.COCOA_BEANS)
            .unlockedBy("has_wheat_seeds", has(Items.WHEAT_SEEDS))
            .save(output)
    }

    private fun addEssenceOfHearth() {
        shaped(RecipeCategory.MISC, ModItems.ESSENCE_OF_HEARTH)
            .define('S', ModItems.SHEPHERDS_HEARTH)
            .define('M', ModItems.MINERS_HEARTH)
            .define('N', ModItems.NETHERS_HEARTH)
            .define('W', ModItems.WORLDS_HEARTH)
            .pattern(" S ")
            .pattern("M N")
            .pattern(" W ")
            .unlockedBy("has_shepherds_hearth", has(ModItems.SHEPHERDS_HEARTH))
            .unlockedBy("has_miners_hearth", has(ModItems.MINERS_HEARTH))
            .unlockedBy("has_nethers_hearth", has(ModItems.NETHERS_HEARTH))
            .unlockedBy("has_worlds_hearth", has(ModItems.WORLDS_HEARTH))
            .save(output)

        shaped(RecipeCategory.MISC, ModItems.SHEPHERDS_HEARTH)
            .define('A', Items.TORCHFLOWER)
            .define('B', Items.HONEYCOMB)
            .define('C', Items.TURTLE_SCUTE)
            .define('D', ItemTags.WOOL)
            .define('E', Items.ARMADILLO_SCUTE)
            .define('F', Items.AXOLOTL_BUCKET)
            .pattern("A B")
            .pattern("CDE")
            .pattern(" F ")
            .unlockedBy("has_ancient_artefact", has(ModItems.ANCIENT_ARTEFACT))
            .save(output)

        shaped(RecipeCategory.MISC, ModItems.MINERS_HEARTH)
            .define('A', Items.DEEPSLATE_IRON_ORE)
            .define('B', Items.DEEPSLATE_COAL_ORE)
            .define('C', Items.DEEPSLATE_REDSTONE_ORE)
            .define('D', Items.DEEPSLATE_EMERALD_ORE)
            .define('E', Items.DEEPSLATE_GOLD_ORE)
            .define('F', Items.DEEPSLATE_DIAMOND_ORE)
            .pattern("A B")
            .pattern("CDE")
            .pattern(" F ")
            .unlockedBy("has_treasure_artefact", has(ModItems.TREASURE_ARTEFACT))
            .save(output)

        shaped(RecipeCategory.MISC, ModItems.NETHERS_HEARTH)
            .define('A', Items.WARPED_FUNGUS)
            .define('B', Items.CRIMSON_FUNGUS)
            .define('C', Items.WITHER_SKELETON_SKULL)
            .define('D', Items.DRIED_GHAST)
            .define('E', Items.ANCIENT_DEBRIS)
            .pattern("A B")
            .pattern("CDC")
            .pattern(" E ")
            .unlockedBy("has_petrified_artefact", has(ModItems.PETRIFIED_ARTEFACT))
            .save(output)

        shaped(RecipeCategory.MISC, ModItems.WORLDS_HEARTH)
            .define('A', Items.BIG_DRIPLEAF)
            .define('B', Items.FLOWERING_AZALEA)
            .define('C', Items.BLUE_ICE)
            .define('D', Items.CACTUS)
            .define('E', Items.POWDER_SNOW_BUCKET)
            .define('F', Items.TROPICAL_FISH_BUCKET)
            .pattern("A B")
            .pattern("CDE")
            .pattern(" F ")
            .unlockedBy("has_frozen_artefact", has(ModItems.FROZEN_ARTEFACT))
            .save(output)
    }

    class Runner(packOutput: PackOutput, provider: CompletableFuture<HolderLookup.Provider?>) :
        RecipeProvider.Runner(packOutput, provider) {
        override fun createRecipeProvider(
            provider: HolderLookup.Provider,
            recipeOutput: RecipeOutput
        ): RecipeProvider {
            return ModRecipeProvider(provider, recipeOutput)
        }

        override fun getName(): String {
            return "Kallisto End Recipes"
        }
    }
}