package jp.dip.monsterlifeserver.dustbox.dustbox;

import jp.dip.monsterlifeserver.dustbox.dustbox.utils.DustBoxAPIs;
import jp.dip.monsterlifeserver.dustbox.dustbox.utils.DustBoxLoader;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static jp.dip.monsterlifeserver.dustbox.dustbox.DustBox.*;

public class Command implements CommandExecutor {

    static private void sendHelpCommand(CommandSender sender) {
        sender.sendMessage(helpCommandFormat1);

        String text = DustBoxAPIs.getCommandDescription(
                "/DustBox help",
                "DustBoxコマンドのヘルプコマンド"
        );
        sender.sendMessage(text);
        text = DustBoxAPIs.getCommandDescription(
                "/DustBox reload",
                "プラグインを再起動します。"
        );
        sender.sendMessage(text);
        text = DustBoxAPIs.getCommandDescription(
                "/DustBox reload config",
                "コンフィグを再読み込みします。"
        );
        sender.sendMessage(text);
        text = DustBoxAPIs.getCommandDescription(
                "/DustBox reload message",
                "メッセージコンフィグを再読み込みします。"
        );
        sender.sendMessage(text);
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("DustBox")) {
            if (args.length == 0) {
                sendHelpCommand(sender);
                return true;
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("help")) {
                    sendHelpCommand(sender);
                    return true;
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    DustBoxLoader.loadAllDustBox();
                    sender.sendMessage(PLPrefix + reloadPlugin);
                    return true;
                }
                sender.sendMessage(PLPrefix + noCommand);
                return true;
            }
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (args[1].equalsIgnoreCase("message")) {
                        DustBoxLoader.loadMessageConfig();
                        sender.sendMessage(PLPrefix + reloadMessage);
                        return true;
                    }
                    if (args[1].equalsIgnoreCase("config")) {
                        DustBoxLoader.loadConfig();
                        sender.sendMessage(PLPrefix + reloadConfig);
                        return true;
                    }
                    sender.sendMessage(PLPrefix + noCommand);
                    return true;
                }

                sender.sendMessage(PLPrefix + noCommand);
                return true;
            }
            sender.sendMessage(PLPrefix + noCommand);
            return true;
        }
        return false;
    }
}
