package net.t_garlaw67.familiesmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import net.t_garlaw67.familiesmod.interfaces.VillagerRomancePoints;

public class HumanEntity extends VillagerEntity implements VillagerRomancePoints {

    private int romancePoints = 0; // This will store the romance points
    private boolean isMarried = false; // This will store the marriage status
    private HumanProfession humanProfession; // This will store the human's profession

    public HumanEntity(EntityType<? extends VillagerEntity> entityType, World world) {
        super(entityType, world);
    }

    // Romance points handling
    @Override
    public int getRomancePoints() {
        return romancePoints;
    }

    @Override
    public void setRomancePoints(int points) {
        this.romancePoints = points;
    }

    // Marriage handling
    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        this.isMarried = married;
    }

    // Profession handling
    public HumanProfession getHumanProfession() {
        return humanProfession;
    }

    public void setHumanProfession(HumanProfession profession) {
        this.humanProfession = profession;
    }

    // Save romance points, marriage status, and profession to NBT
    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("RomancePoints", this.romancePoints);
        nbt.putBoolean("IsMarried", this.isMarried); // Save marriage status
        if (this.humanProfession != null) {
            nbt.putString("HumanProfession", this.humanProfession.name()); // Save profession
        }
    }

    // Load romance points, marriage status, and profession from NBT
    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("RomancePoints")) {
            this.romancePoints = nbt.getInt("RomancePoints");
        }
        if (nbt.contains("IsMarried")) {
            this.isMarried = nbt.getBoolean("IsMarried"); // Load marriage status
        }
        if (nbt.contains("HumanProfession")) {
            this.humanProfession = HumanProfession.valueOf(nbt.getString("HumanProfession")); // Load profession
        }
    }
}
