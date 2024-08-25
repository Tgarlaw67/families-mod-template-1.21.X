package net.t_garlaw67.familiesmod.events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.server.world.ServerWorld;

public class EntitySpawnHandler {

    public static void registerEvents() {
        ServerEntityEvents.ENTITY_LOAD.register((Entity entity, ServerWorld world) -> {
            // Check if the entity is a villager and prevent its spawn
            if (entity.getType() == EntityType.VILLAGER) {
                entity.remove(Entity.RemovalReason.DISCARDED); // Prevent the villager from spawning
            }
        });
    }
}