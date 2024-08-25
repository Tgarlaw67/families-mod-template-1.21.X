package net.t_garlaw67.familiesmod.util;

import net.t_garlaw67.familiesmod.entity.HumanEntity;
import net.t_garlaw67.familiesmod.interfaces.VillagerRomancePoints;

public class RomancePointsUtil {

    // Get the romance points from the human
    public static int getRomancePoints(HumanEntity human) {
        return ((VillagerRomancePoints) human).getRomancePoints();
    }

    // Set the romance points for the human
    public static void setRomancePoints(HumanEntity human, int points) {
        ((VillagerRomancePoints) human).setRomancePoints(points);
    }

    // Add romance points to the human
    public static void addRomancePoints(HumanEntity human, int points) {
        int currentPoints = getRomancePoints(human);
        setRomancePoints(human, currentPoints + points);
    }
}