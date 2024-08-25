package net.t_garlaw67.familiesmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.VillagerEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.EntityType;


public class FamiliesModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Register the entity renderer for HumanEntity
        EntityRendererRegistry.register(FamiliesMod.HUMAN_ENTITY, (EntityRendererFactory.Context context) ->
                new VillagerEntityRenderer(context));

    }
}
