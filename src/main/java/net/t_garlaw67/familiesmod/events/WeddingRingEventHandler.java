package net.t_garlaw67.familiesmod.events;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.text.Text;
import net.t_garlaw67.familiesmod.item.ModItems;

public class WeddingRingEventHandler {

    public static void registerEvents() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            ItemStack stack = player.getStackInHand(hand);

            // Check if the player is holding the wedding ring and clicked a Villager
            if (stack.getItem() == ModItems.WEDDING_RING && entity instanceof VillagerEntity) {
                if (!world.isClient()) {
                    VillagerEntity villager = (VillagerEntity) entity;

                    // Toggle lead behavior
                    if (!villager.isLeashed()) {
                        villager.attachLeash(player, true);
                        player.sendMessage(Text.of("You are now leading the villager!"), true);
                    } else {
                        villager.detachLeash(true, false);
                        player.sendMessage(Text.of("You released the villager."), true);
                    }
                }
                return ActionResult.SUCCESS;
            }

            return ActionResult.PASS;
        });
    }
}
