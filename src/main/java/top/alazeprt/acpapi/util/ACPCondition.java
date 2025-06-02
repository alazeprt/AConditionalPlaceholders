package top.alazeprt.acpapi.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record ACPCondition(int period, @Nullable String condition, @NotNull String result) {
}
