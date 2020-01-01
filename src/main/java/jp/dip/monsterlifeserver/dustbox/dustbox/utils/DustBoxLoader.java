package jp.dip.monsterlifeserver.dustbox.dustbox.utils;


import jp.dip.monsterlifeserver.dustbox.dustbox.listener.onOpenDustBox;

import java.util.ArrayList;

import static jp.dip.monsterlifeserver.dustbox.dustbox.DustBox.*;
import static org.bukkit.Bukkit.getServer;

public class DustBoxLoader {

    static public void loadAllDustBox() {
        config = new CustomConfig(plugin);
        msg_config = new CustomConfig(plugin, "message.yml");

        config.saveDefaultConfig();
        msg_config.saveDefaultConfig();

        loadMessageConfig(); // メッセージコンフィグをロード
        loadConfig();

        loadEvent();
    }

    static public void loadMessageConfig() {
        PLPrefix = DustBoxAPIs.replaceColorCode(msg_config.getConfig().getString("Prefix"));

        enablePlugin = DustBoxAPIs.replaceColorCode(msg_config.getConfig().getString("Message.enablePlugin"));
        disablePlugin = DustBoxAPIs.replaceColorCode(msg_config.getConfig().getString("Message.disablePlugin"));
        reloadPlugin = DustBoxAPIs.replaceColorCode(msg_config.getConfig().getString("Message.reloadPlugin"));
        reloadConfig = DustBoxAPIs.replaceColorCode(msg_config.getConfig().getString("Message.reloadConfig"));
        reloadMessage = DustBoxAPIs.replaceColorCode(msg_config.getConfig().getString("Message.reloadMessage"));

        DustBoxName = DustBoxAPIs.replaceColorCode(msg_config.getConfig().getString("GUIText.DustBoxName"));
        DustBoxNote = DustBoxAPIs.replaceColorCode(msg_config.getConfig().getString("GUIText.DustBoxNote"));

        helpCommandFormat1 = DustBoxAPIs.replaceColorCode(msg_config.getConfig().getString("Message.helpCommandFormat1"));
        helpCommandFormat2 = DustBoxAPIs.replaceColorCode(msg_config.getConfig().getString("Message.helpCommandFormat2"));
        noCommand = DustBoxAPIs.replaceColorCode(msg_config.getConfig().getString("Message.noCommand"));
    }

    static public void loadConfig() {
        IronDustBox = config.getConfig().getBoolean("IronDustBox.enabled");
        IronDustBoxSize = config.getConfig().getInt("IronDustBox.Size");

        WoodDustBox = config.getConfig().getBoolean("WoodDustBox.enabled");
        WoodDustBoxSize = config.getConfig().getInt("WoodDustBox.Size");

        DustBoxBanWorld = new ArrayList<>();
        DustBoxBanWorld = config.getConfig().getStringList("DustBoxBanWorld");
    }

    static public void loadEvent() {
        getServer().getPluginManager().registerEvents(new onOpenDustBox(), plugin);
    }

}
