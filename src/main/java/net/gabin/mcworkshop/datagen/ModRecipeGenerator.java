package net.gabin.mcworkshop.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.gabin.mcworkshop.block.ModBlocks;
import net.gabin.mcworkshop.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET)
                .pattern("###")
                .pattern("#P#")
                .pattern("###")
                .input('#', Items.STONE)
                .input('P', ModItems.PINK_GARNET)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_PINK_GARNET) + "_"));

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.PINK_GARNET, RecipeCategory.MISC, ModBlocks.PINK_GARNET_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK);

        offerSmelting(exporter, List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE)
                , RecipeCategory.MISC,ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");
        offerBlasting(exporter, List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE)
                , RecipeCategory.MISC,ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");

    }
}
