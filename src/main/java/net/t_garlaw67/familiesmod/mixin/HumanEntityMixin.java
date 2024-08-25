package net.t_garlaw67.familiesmod.mixin;

import net.t_garlaw67.familiesmod.entity.HumanEntity;
import net.t_garlaw67.familiesmod.interfaces.VillagerRomancePoints;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(HumanEntity.class)
public class HumanEntityMixin implements VillagerRomancePoints {

    // This will store the romance points in the HumanEntity
    @Unique
    private int romancePoints = 0;

    @Override
    public int getRomancePoints() {
        return romancePoints;
    }

    @Override
    public void setRomancePoints(int points) {
        this.romancePoints = points;
    }
}
