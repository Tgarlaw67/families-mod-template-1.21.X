package net.t_garlaw67.familiesmod.events;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.t_garlaw67.familiesmod.entity.HumanEntity;
import net.t_garlaw67.familiesmod.item.ModItems;
import net.t_garlaw67.familiesmod.util.RomancePointsUtil;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.util.Identifier;

public class MarriageLicenseEventHandler {

    public static void registerEvents() {
        // UseEntityCallback listens for the player interacting with an entity
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            ItemStack stack = player.getStackInHand(hand);

            // Check if the player is holding the Marriage License and interacting with a human
            if (stack.getItem() == ModItems.MARRIAGE_LICENSE && entity instanceof HumanEntity) {
                HumanEntity human = (HumanEntity) entity;

                // Check if the human has enough romance points
                if (RomancePointsUtil.getRomancePoints(human) >= 100 && !human.isMarried()) {
                    // Mark the player and the human as married
                    human.setMarried(true);
                    player.sendMessage(Text.of("You are now married to " + human.getName().getString() + "!"), true);

                    // Apply buffs to the player
                    applyMarriageBuffs(player);

                    return ActionResult.SUCCESS;
                } else if (human.isMarried()) {
                    player.sendMessage(Text.of("This human is already married!"), true);
                    return ActionResult.FAIL;
                } else {
                    player.sendMessage(Text.of("The human does not have enough romance points to marry."), true);
                    return ActionResult.FAIL;
                }
            }

            return ActionResult.PASS;
        });
    }

    // Marriage Buffs (15% increase to stats)
    private static void applyMarriageBuffs(PlayerEntity player) {
        // Apply Luck effect
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, Integer.MAX_VALUE, 0, true, false));

        // Apply a 15% speed increase using an attribute modifier
        player.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)
                .addTemporaryModifier(new EntityAttributeModifier(
                        net.minecraft.util.Identifier.of("familiesmod:marriage_speed_boost"),
                        0.15,
                        EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

        player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)
                .addTemporaryModifier(new EntityAttributeModifier(
                        net.minecraft.util.Identifier.of("familiesmod:marriage_health_boost"),
                        0.15,
                        EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

        // Apply a slight strength boost
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, Integer.MAX_VALUE, 0, true, false));
    }
}
