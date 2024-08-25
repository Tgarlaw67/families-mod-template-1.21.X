package net.t_garlaw67.familiesmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.world.World;
import net.t_garlaw67.familiesmod.interfaces.VillagerRomancePoints;

public class HumanEntity extends VillagerEntity implements VillagerRomancePoints {

    private int romancePoints = 0; // This will store the romance points

    public HumanEntity(EntityType<? extends VillagerEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public int getRomancePoints() {
        return romancePoints;
    }

    @Override
    public void setRomancePoints(int points) {
        this.romancePoints = points;

    }
}