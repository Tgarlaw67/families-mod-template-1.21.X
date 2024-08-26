package net.t_garlaw67.familiesmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType.Builder;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.entity.EntityType;
import net.t_garlaw67.familiesmod.block.ModBlocks;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.Biome;
import net.minecraft.registry.tag.BiomeTags;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.t_garlaw67.familiesmod.entity.HumanEntity;
import net.t_garlaw67.familiesmod.events.EntitySpawnHandler;
import net.t_garlaw67.familiesmod.events.GiftGivingLogic;
import net.t_garlaw67.familiesmod.events.MarriageLicenseEventHandler;
import net.t_garlaw67.familiesmod.events.WeddingRingEventHandler;
import net.t_garlaw67.familiesmod.item.ModItemGroups;
import net.t_garlaw67.familiesmod.item.ModItems;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.server.world.ServerWorld;
import net.t_garlaw67.familiesmod.trade.CustomTradeOffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class FamiliesMod implements ModInitializer {
	public static final String MOD_ID = "familiesmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Register the Human entity type
	public static final EntityType<HumanEntity> HUMAN_ENTITY = EntityType.Builder.create(HumanEntity::new, SpawnGroup.CREATURE)
			.dimensions(0.6F, 1.95F)  // Same size as villagers
			.build("human");

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		CustomTradeOffer.registerTrades();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		WeddingRingEventHandler.registerEvents();
		GiftGivingLogic.registerEvents();
		EntitySpawnHandler.registerEvents();
		MarriageLicenseEventHandler.registerEvents();

// Register the Human entity
		Registry.register(Registries.ENTITY_TYPE, Identifier.of("familiesmod", "human"), HUMAN_ENTITY);


		// Register Human entity attributes (same as villagers)
		FabricDefaultAttributeRegistry.register(HUMAN_ENTITY, VillagerEntity.createVillagerAttributes());

		// Register Human spawns in biomes with plains, savanna, and taiga tags
		BiomeModifications.addSpawn(
				BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),  // This selects all overworld biomes
				SpawnGroup.CREATURE,
				HUMAN_ENTITY,
				10, 2, 5
		);
	}
}
