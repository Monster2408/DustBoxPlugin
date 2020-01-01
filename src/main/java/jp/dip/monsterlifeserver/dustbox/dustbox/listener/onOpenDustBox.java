package jp.dip.monsterlifeserver.dustbox.dustbox.listener;

import jp.dip.monsterlifeserver.dustbox.dustbox.utils.DustBoxAPIs;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import static jp.dip.monsterlifeserver.dustbox.dustbox.DustBox.*;

public class onOpenDustBox implements Listener {

    @EventHandler
    public void onOpenDustBox(PlayerInteractEvent e) {
        Block block = e.getClickedBlock();
        Block under_block = DustBoxAPIs.getBlock(block, -1);
        Block above_block = DustBoxAPIs.getBlock(block, 1);
        Player player = e.getPlayer();
        Action action = e.getAction();

        if (DustBoxBanWorld.contains(player.getWorld().getName())) {
            return;
        }

        if (action == Action.RIGHT_CLICK_BLOCK) {
            if (block.getType() == Material.CAULDRON && under_block.getType() == Material.GOLD_BLOCK) {
                if (above_block.getType() == Material.IRON_TRAPDOOR) {
                    if (IronDustBox) {
                        e.setCancelled(true);
                        Inventory inventory = Bukkit.createInventory(null, 9 * IronDustBoxSize, DustBoxName + " " + DustBoxNote);
                        player.openInventory(inventory);
                    }
                    return;
                }
                if (above_block.getType() == Material.TRAP_DOOR) {
                    if (WoodDustBox) {
                        e.setCancelled(true);
                        Inventory inventory = Bukkit.createInventory(null, 9 * WoodDustBoxSize, DustBoxName + " " + DustBoxNote);
                        player.openInventory(inventory);
                    }
                    return;
                }
            }
        }


        if (WoodDustBox) {

        }
    }

}
