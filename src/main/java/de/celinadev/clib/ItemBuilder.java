package de.celinadev.clib;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Utilities for the Generation of Items
 *
 * @author Cxlina
 */
public class ItemBuilder {

    private String name;
    private String[] description;
    private Material type;
    private int amount;
    private ItemStack item;

    public ItemBuilder() {
        this.name = "";
        this.description = new String[]{};
        this.type = Material.AIR;
        this.amount = 1;
    }

    public ItemBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder description(String[] description) {
        this.description = description;
        return this;
    }

    public ItemBuilder type(Material type) {
        this.type = type;
        return this;
    }

    public ItemBuilder amount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemStack build() {
        ItemStack item = new ItemStack(this.type, this.amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(this.name);
        meta.setLore(List.of(this.description));
        item.setItemMeta(meta);
        return this.item = item;
    }
}
