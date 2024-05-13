package net.gabin.mcworkshop;

import net.fabricmc.api.ModInitializer;

import net.gabin.mcworkshop.block.ModBlocks;
import net.gabin.mcworkshop.datagen.ModWorldGenerator;
import net.gabin.mcworkshop.item.ModItemGroup;
import net.gabin.mcworkshop.item.ModItems;
import net.gabin.mcworkshop.util.ModRegistries;
import net.gabin.mcworkshop.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCWorkshopMod implements ModInitializer {
	public static final String MOD_ID = "mcworkshop";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();
		ModRegistries.registerModStuffs();
	}
}