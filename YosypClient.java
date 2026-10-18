package ua.yosyp.yosyp;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;

public class YosypClient implements ClientModInitializer {
    private static final String WATER_BUCKET_LORE = "изза этой воды вся вода здесь? щас я ее перекрою и воды больше не будет, и ее щас не будет? угу бл#дь в голове с#rf у меня мозги осушаться осушиться";

    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((stack, context, tooltipType, lines) -> {
            if (stack.is(Items.WATER_BUCKET)) {
                lines.add(Component.literal(WATER_BUCKET_LORE));
            }
        });
    }
}
