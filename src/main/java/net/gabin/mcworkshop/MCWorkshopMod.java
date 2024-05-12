package net.gabin.mcworkshop;

import net.fabricmc.api.ModInitializer;

import net.gabin.mcworkshop.block.ModBlocks;
import net.gabin.mcworkshop.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCWorkshopMod implements ModInitializer {
	public static final String MOD_ID = "mcworkshop";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}