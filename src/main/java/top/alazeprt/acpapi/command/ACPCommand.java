package top.alazeprt.acpapi.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.alazeprt.acpapi.ACPPlugin;

import java.util.ArrayList;
import java.util.List;

public class ACPCommand implements CommandExecutor, TabCompleter {
    private final ACPPlugin plugin;

    public ACPCommand(ACPPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("acp.reload")) {
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                sender.sendMessage(ChatColor.GREEN + "正在重载插件配置文件...");
                plugin.configManager.loadConfig();
                plugin.matchers = plugin.configManager.getMatcherList();
                sender.sendMessage(ChatColor.GREEN + "插件配置文件重载成功!");
            } else {
                sender.sendMessage(ChatColor.YELLOW + "AConditionalPlaceholders v1.0");
                sender.sendMessage(ChatColor.GREEN + "/acp reload - 重载插件配置文件");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "你没有权限执行此命令!");
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return new ArrayList<>();
    }
}
