package net.t_garlaw67.familiesmod.events;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.text.Text;
import net.t_garlaw67.familiesmod.entity.HumanEntity;
import net.t_garlaw67.familiesmod.item.ModItems;
import net.t_garlaw67.familiesmod.util.RomancePointsUtil;

public class WeddingRingEventHandler {

    public static void registerEvents() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            ItemStack stack = player.getStackInHand(hand);

            // Check if the player is holding the wedding ring and clicked a HumanEntity
            if (stack.getItem() == ModItems.WEDDING_RING && entity instanceof HumanEntity) {
                HumanEntity human = (HumanEntity) entity;

                // Get the romance points
                int romancePoints = RomancePointsUtil.getRomancePoints(human);

                // Debugging output for the player's convenience
                player.sendMessage(Text.of("Human has " + romancePoints + " romance points."), true);

                // Check if the human has enough romance points (100 required)
                if (romancePoints >= 100) {
                    // Toggle lead behavior
                    if (!human.isLeashed()) {
                        human.attachLeash(player, true);
                        player.sendMessage(Text.of("You are now leading the human!"), true);
                    } else {
                        human.detachLeash(true, false);
                        player.sendMessage(Text.of("You released the human."), true);
                    }
                } else {
                    player.sendMessage(Text.of("The human does not have enough romance points to follow you."), true);
                }

                return ActionResult.SUCCESS;
            }

            return ActionResult.PASS;
        });
    }
}
