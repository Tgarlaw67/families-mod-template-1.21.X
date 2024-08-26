package net.t_garlaw67.familiesmod.events;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.text.Text;
import net.t_garlaw67.familiesmod.item.ModItems;

public class WeddingRingEventHandler {

    public static void registerEvents() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            ItemStack stack = player.getStackInHand(hand);


                    // Toggle lead behavior
                    } else {
                    }
                }
                return ActionResult.SUCCESS;
            }

            return ActionResult.PASS;
        });
    }
}
