package top.alazeprt.acpapi.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ACPCondition {
    private int period;
    private String condition;
    private String result;

    public ACPCondition(int period, @Nullable String condition, @NotNull String result) {
        this.period = period;
        this.condition = condition;
        this.result = result;
    }

    public int period() {
        return period;
    }

    public String condition() {
        return condition;
    }

    public String result() {
        return result;
    }
}
