package top.alazeprt.acpapi;

import org.bukkit.plugin.java.JavaPlugin;
import top.alazeprt.acpapi.bstats.Metrics;
import top.alazeprt.acpapi.command.ACPCommand;
import top.alazeprt.acpapi.config.ACPConfig;
import top.alazeprt.acpapi.external.ACPExpansion;
import top.alazeprt.acpapi.util.ACPMatcher;

import java.util.ArrayList;
import java.util.List;

public class ACPPlugin extends JavaPlugin {

    public List<ACPMatcher> matchers = new ArrayList<>();
    public ACPConfig configManager;

    @Override
    public void onEnable() {
        configManager = new ACPConfig(this);
        configManager.loadConfig();
        matchers = configManager.getMatcherList();
        new ACPExpansion(this).register();
        Metrics metrics = new Metrics(this, 26065);
        getCommand("aconditionalplaceholders").setExecutor(new ACPCommand(this));
    }

    @Override
    public void onDisable() {

    }


}
