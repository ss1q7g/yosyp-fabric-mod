package ua.yosyp.yosyp;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.network.chat.Component;

import java.util.Map;

public class YosypMod implements ModInitializer {
    private static final Map<EntityType<?>, String> NAMES = Map.ofEntries(
        Map.entry(EntityType.ENDERMAN, "Эндер Вася"),
        Map.entry(EntityType.WITCH, "Чаклун"),
        Map.entry(EntityType.VEX, "дрончик вася"),
        Map.entry(EntityType.BEE, "Бджилки"),
        Map.entry(EntityType.VILLAGER, "Торгаши"),
        Map.entry(EntityType.TROPICAL_FISH, "сашими"),
        Map.entry(EntityType.SILVERFISH, "Конфетки"),
        Map.entry(EntityType.BLAZE, "Ху#ня Бл#дь"),
        Map.entry(EntityType.ZOMBIE, "охранники"),
        Map.entry(EntityType.HUSK, "Пищевод"),
        Map.entry(EntityType.DROWNED, "Водяной"),
        Map.entry(EntityType.PHANTOM, "кажан"),
        Map.entry(EntityType.IRON_GOLEM, "Каменный Йосып"),
        Map.entry(EntityType.PILLAGER, "бригадиры"),
        Map.entry(EntityType.VINDICATOR, "бригадиры"),
        Map.entry(EntityType.EVOKER, "бригадиры"),
        Map.entry(EntityType.ILLUSIONER, "бригадиры"),
        Map.entry(EntityType.PIG, "Семья Свиней"),
        Map.entry(EntityType.PIGLIN, "Семья Свиней"),
        Map.entry(EntityType.PIGLIN_BRUTE, "Семья Свиней"),
        Map.entry(EntityType.HOGLIN, "Семья Свиней"),
        Map.entry(EntityType.ZOGLIN, "Семья Свиней"),
        Map.entry(EntityType.CAVE_SPIDER, "Ядовитови паук с и ядом"),
        Map.entry(EntityType.SPIDER, "паучара бл#дь"),
        Map.entry(EntityType.SHULKER, "козяки")
    );

    @Override
    public void onInitialize() {
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            for (Entity entity : world.getEntities()) {
                String name = NAMES.get(entity.getType());
                if (name != null) {
                    Component desired = Component.literal(name);
                    if (!desired.equals(entity.getCustomName())) {
                        entity.setCustomName(desired);
                    }
                    if (!entity.isCustomNameVisible()) {
                        entity.setCustomNameVisible(true);
                    }
                }
            }
        });
    }
}
