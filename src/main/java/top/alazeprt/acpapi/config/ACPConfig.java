package top.alazeprt.acpapi.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.alazeprt.acpapi.ACPPlugin;
import top.alazeprt.acpapi.util.ACPCondition;
import top.alazeprt.acpapi.util.ACPMatcher;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

public class ACPConfig {
    private final ACPPlugin plugin;
    private final List<ACPMatcher> matcherList = new ArrayList<>();

    public ACPConfig(ACPPlugin plugin) {
        this.plugin = plugin;
    }

    public void loadConfig() {
        matcherList.clear();
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            plugin.saveResource("config.yml", false);
        }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
        File placeholdersFile = new File(plugin.getDataFolder(), "placeholders.yml");
        if (!placeholdersFile.exists()) {
            plugin.saveResource("placeholders.yml", false);
        }
        FileConfiguration placeholders = YamlConfiguration.loadConfiguration(placeholdersFile);
        loadPlaceholders(placeholders);
    }

    public void loadPlaceholders(@NotNull FileConfiguration placeholders) {
        placeholders.getKeys(false).forEach(key -> {
            List<ACPCondition> conditions = new ArrayList<>();
            placeholders.getList(key).forEach(value -> {
                var section = (LinkedHashMap<String, Object>) value;
                int priority = Integer.parseInt(section.get("priority").toString());
                @Nullable String condition = section.get("condition") == null ? null : section.get("condition").toString();
                String result = section.get("result").toString();
                ACPCondition condition1 = new ACPCondition(priority, condition, result);
                conditions.add(condition1);
            });
            conditions.sort(Comparator.comparingInt(ACPCondition::period).reversed());
            ACPMatcher matcher = new ACPMatcher(key, conditions);
            matcherList.add(matcher);
        });
    }

    public List<ACPMatcher> getMatcherList() {
        return matcherList;
    }
}
