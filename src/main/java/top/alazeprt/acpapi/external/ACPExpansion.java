package top.alazeprt.acpapi.external;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.alazeprt.acpapi.ACPPlugin;

public class ACPExpansion extends PlaceholderExpansion {
    private final ACPPlugin plugin;

    public ACPExpansion(ACPPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "acpapi";
    }

    @Override
    public @NotNull String getAuthor() {
        return "alazeprt";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public @Nullable String onRequest(OfflinePlayer player, @NotNull String params) {
        for (var matcher : plugin.matchers) {
            if (matcher.name().equals(params)) {
                return matcher.match(player);
            }
        }
        return null;
    }
}
