package jp.dip.monsterlifeserver.dustbox.dustbox.utils;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;

import static jp.dip.monsterlifeserver.dustbox.dustbox.DustBox.*;

public class DustBoxAPIs {

    /**
     * @param block
     * @param i -> +1 is 1 above | -1 is 1 under
     * @return
     */
    public static Block getBlock(Block block, double i) {
        Location loc = block.getLocation().clone();
        loc.setY(loc.getY() + i);
        Block _block = loc.getBlock();
        return _block;
    }

    public static String replaceColorCode(String source) {
        if (source == null)
            return null;
        return ChatColor.translateAlternateColorCodes('&', source);
    }

    public static String getCommandDescription(String command, String description) {
        String text = helpCommandFormat2;
        text = text.replace("%COMMAND%", command);
        return text.replace("%DESCRIPTION%", command);
    }

}
