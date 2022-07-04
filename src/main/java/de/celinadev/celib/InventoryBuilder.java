package de.celinadev.celib;

import com.google.common.annotations.Beta;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder {

    private String title;
    private int rows;
    private Inventory inventory;

    public InventoryBuilder() {
        this("", 1);
    }

    public InventoryBuilder(String title, int rows) {
        this.title = title;
        if (rows < 1 || rows > 6) {
            throw new IllegalArgumentException("Rows has to be between 1-6.");
        } else this.rows = rows;
        this.inventory = new TaggedInventory(this.rows, this.title).getInventory();
    }

    public InventoryBuilder title(String title) {
        this.title = title;
        this.inventory = new TaggedInventory(this.rows, this.title).getInventory();
        return this;
    }

    public InventoryBuilder rows(int rows) {
        this.rows = rows;
        this.inventory = new TaggedInventory(this.rows, this.title).getInventory();
        return this;
    }

    public InventoryBuilder addItem(int slot, ItemStack item) {
        this.inventory.setItem(slot, item);
        return this;
    }

    /**
     * This is still in work! Don't use it, it won't work.
     *
     * @param slots
     * @param items
     * @return
     */
    @Beta
    public InventoryBuilder addItems(int[] slots, ItemStack[] items) {
        for (int i : slots) {
            try {
                for (ItemStack i1 : items) {
                    this.inventory.setItem(i, i1);
                }
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException("Count of slots have to match count of items.");
            }
        }
        return this;
    }

    public InventoryBuilder removeItems(int... slots) {
        for (int i : slots) {
            this.inventory.setItem(i, null);
        }
        return this;
    }

    public Inventory build() {
        return this.inventory;
    }

    public record TaggedInventory(int rows, String title) implements InventoryHolder {

        @Override
        public Inventory getInventory() {
            Inventory inventory = Bukkit.createInventory(this, rows * 9, title);
            return inventory;
        }
    }
}
