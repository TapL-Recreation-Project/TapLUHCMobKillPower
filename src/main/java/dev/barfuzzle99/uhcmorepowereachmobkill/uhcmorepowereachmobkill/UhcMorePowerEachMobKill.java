package dev.barfuzzle99.uhcmorepowereachmobkill.uhcmorepowereachmobkill;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import me.swipez.uhccore.api.UHCAPI;
import me.swipez.uhccore.api.UHCPlugin;

import java.util.ArrayList;
import java.util.List;

public final class UhcMorePowerEachMobKill extends JavaPlugin implements UHCPlugin {

    public static boolean enabled = false;

    @Override
    public void onEnable() {
        UHCAPI.registerPlugin(this);
        Bukkit.getPluginManager().registerEvents(new MobKillListener(), this);
    }

    @Override
    public void stop() {
        UhcMorePowerEachMobKill.enabled = false;
    }

    @Override
    public void start() {
        UhcMorePowerEachMobKill.enabled = true;
    }

    @Override
    public String getAuthor() {
        return "barfuzzle99";
    }

    @Override
    public ItemStack getDisplayStack() {
        ItemStack icon = new ItemStack(Material.WOODEN_SWORD);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "Every time you kill a mob, you get more powerful!");
        ItemMeta meta = icon.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "More power each mob kill");
        meta.setLore(lore);
        icon.setItemMeta(meta);
        return icon;
    }
}
