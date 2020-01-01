package jp.dip.monsterlifeserver.dustbox.dustbox;

import com.sun.org.apache.xerces.internal.xs.StringList;
import jp.dip.monsterlifeserver.dustbox.dustbox.utils.CustomConfig;
import jp.dip.monsterlifeserver.dustbox.dustbox.utils.DustBoxLoader;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class DustBox extends JavaPlugin {

    public static CustomConfig config;
    public static CustomConfig msg_config;

    public static Plugin plugin;

    public static String PLPrefix;

    public static String enablePlugin;
    public static String disablePlugin;
    public static String reloadPlugin;
    public static String reloadConfig;
    public static String reloadMessage;

    public static String DustBoxName;
    public static String DustBoxNote;

    public static boolean IronDustBox;
    public static int IronDustBoxSize;

    public static boolean WoodDustBox;
    public static int WoodDustBoxSize;

    public static List<String> DustBoxBanWorld;

    public static String helpCommandFormat1;
    public static String helpCommandFormat2;
    public static String noCommand;

    @Override
    public void onEnable() {
        plugin = this;
        DustBoxLoader.loadAllDustBox();

        getCommand("DustBox").setExecutor(new Command());

        getLogger().info(enablePlugin);
    }

    @Override
    public void onDisable() {
        getLogger().info(disablePlugin);
    }
}
