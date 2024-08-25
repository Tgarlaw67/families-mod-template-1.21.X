package net.t_garlaw67.familiesmod.util;

import net.minecraft.entity.passive.VillagerEntity;
import net.t_garlaw67.familiesmod.mixin.VillagerRomancePoints;

public class RomancePointsUtil {

    // Get the romance points from the villager
    public static int getRomancePoints(VillagerEntity villager) {
        return ((VillagerRomancePoints) villager).getRomancePoints();
    }

    // Set the romance points for the villager
    public static void setRomancePoints(VillagerEntity villager, int points) {
        ((VillagerRomancePoints) villager).setRomancePoints(points);
    }

    // Add romance points to the villager
    public static void addRomancePoints(VillagerEntity villager, int points) {
        int currentPoints = getRomancePoints(villager);
        setRomancePoints(villager, currentPoints + points);
    }
}
