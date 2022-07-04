package de.celinadev.celib;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class ItemUtil {

    public static boolean isTagged(ItemStack item, String identifier) {
        if (item.getItemMeta() == null) {
            return false;
        }
        return item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(CeLib.getInstance().getPlugin(), identifier), PersistentDataType.STRING);
    }
}
