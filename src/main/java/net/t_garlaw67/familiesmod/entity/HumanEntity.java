package net.t_garlaw67.familiesmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.world.World;

public class HumanEntity extends VillagerEntity {

    public HumanEntity(EntityType<? extends VillagerEntity> entityType, World world) {
        super(entityType, world);
    }

    // You can override or add any custom behavior here, if needed
}