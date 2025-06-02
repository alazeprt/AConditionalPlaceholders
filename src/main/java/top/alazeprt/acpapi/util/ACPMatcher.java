package top.alazeprt.acpapi.util;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.List;

public record ACPMatcher(String name, @NotNull List<ACPCondition> conditions) {
    public String match(@NotNull OfflinePlayer player) {
        for (ACPCondition condition : conditions) {
            if (condition.condition() == null) {
                return parseResult(player, condition);
            }
            String conditionString = PlaceholderAPI.setPlaceholders(player, condition.condition());
            ExpressionParser parser = new SpelExpressionParser();
            try {
                Expression expression = parser.parseExpression(conditionString);
                Object result = expression.getValue(player);
                if (result instanceof Boolean booleanResult && booleanResult) {
                    return parseResult(player, condition);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String parseResult(@NotNull OfflinePlayer player, ACPCondition condition) {
        String originalResult = PlaceholderAPI.setPlaceholders(player, condition.result());
        ExpressionParser parser = new SpelExpressionParser();
        try {
            Expression expression = parser.parseExpression(originalResult);
            Object result = expression.getValue(player);
            if (result instanceof String stringResult) {
                return stringResult;
            }
        } catch (Exception ignored) {}
        return originalResult;
    }
}
