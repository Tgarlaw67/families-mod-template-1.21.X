package net.t_garlaw67.familiesmod.events;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.text.Text;
import net.t_garlaw67.familiesmod.util.RomancePointsUtil;

public class GiftGivingLogic {

    // Register the gift-giving logic with Fabric's UseEntityCallback
    public static void registerEvents() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (entity instanceof VillagerEntity) {
                VillagerEntity villager = (VillagerEntity) entity;
                ItemStack stack = player.getStackInHand(hand);

                // Check if the player is giving a gift (e.g., emerald or flower)
                if (stack.getItem() == Items.EMERALD || stack.getItem() == Items.POPPY) {
                    if (!world.isClient()) {
                        // Add romance points to the villager
                        RomancePointsUtil.addRomancePoints(villager, 10);

                        // Decrease the item stack (the gift is consumed)
                        stack.decrement(1);

                        // Get the current romance points and send a message to the player
                        int currentPoints = RomancePointsUtil.getRomancePoints(villager);
                        player.sendMessage(Text.of("Villager received the gift! Current romance points: " + currentPoints), true);
                    }
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.PASS;
        });
    }
}
