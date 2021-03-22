package dev.barfuzzle99.uhcmorepowereachmobkill.uhcmorepowereachmobkill;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class MobKillListener implements Listener {
    @EventHandler
    public void onMobKill(EntityDeathEvent event) {
        if (!UhcMorePowerEachMobKill.enabled) {
            return;
        }
        if (!(event.getEntity() instanceof Mob)) {
            return;
        }
        if (event.getEntity().getKiller() != null) {
            makeMorePowerful(event.getEntity().getKiller());
        }
    }

    public void makeMorePowerful(Player player) {
        for (ItemStack armorPiece : player.getInventory().getArmorContents()) {
            if (armorPiece == null) continue;
            if (armorPiece.containsEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)) {
                int protLevel = armorPiece.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL);
                armorPiece.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, protLevel + 1);
            } else {
                armorPiece.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
            }
        }

        for (ItemStack itemStack : player.getInventory().getContents()) {
            if (itemStack == null) continue;
            if (itemStack.getType().toString().contains("_SWORD") ||
                itemStack.getType().toString().contains("_AXE")) {
                if (itemStack.containsEnchantment(Enchantment.DAMAGE_ALL)) {
                    int sharpLevel = itemStack.getEnchantmentLevel(Enchantment.DAMAGE_ALL);
                    itemStack.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, sharpLevel + 1);
                } else {
                    itemStack.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                }
            }
        }
    }
}
