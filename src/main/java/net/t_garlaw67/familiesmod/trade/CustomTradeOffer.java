package net.t_garlaw67.familiesmod.trade;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.t_garlaw67.familiesmod.item.ModItems;

import java.util.Optional;

public class CustomTradeOffer {

    public static void registerTrades() {
        // Add a trade to the cleric for the marriage license
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 1, factories -> {
            System.out.println("Registering marriage license trade for cleric");
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.WEDDING_RING, 1),
                    Optional.empty(),
                    new ItemStack(ModItems.MARRIAGE_LICENSE, 1),
                    10,
                    5,
                    0.05F
            ));
        });
    }
}
