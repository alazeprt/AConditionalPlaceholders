package top.alazeprt.acpapi;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.plugin.java.JavaPlugin;
import top.alazeprt.acpapi.config.ACPConfig;
import top.alazeprt.acpapi.external.ACPExpansion;
import top.alazeprt.acpapi.util.ACPMatcher;

import java.util.ArrayList;
import java.util.List;

public class ACPPlugin extends JavaPlugin {

    public List<ACPMatcher> matchers = new ArrayList<>();

    @Override
    public void onEnable() {
        ACPConfig configManager = new ACPConfig(this);
        configManager.loadConfig();
        matchers = configManager.getMatcherList();
        new ACPExpansion(this).register();
    }

    @Override
    public void onDisable() {

    }


}
