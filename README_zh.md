# AConditionalPlaceholders

[English](./README.md) | 简体中文

---

## 📝 介绍

**AConditionalPlaceholders** 是一个灵活的Minecraft Spigot插件, 旨在让管理员基于已有占位符的数据创建自定义占位符, 并在游戏内呈现, 通过配置简单的规则, 你可以创建多样的条件判断系统, 根据玩家的游戏状态(其它占位符, 如玩家余额`%vault_eco_balance%`)来返回不同的内容

---

## 🌟 插件特点

- **轻量**: 插件本体(包括依赖库)大小仅2MB左右
- **简易**: 配置文件仅14行, 注释详细, 结构简单易懂 (优先级/条件/结果), 适合零基础新手学习
- **灵活**: 基于 `SpEL` (`Spring Expression Language`) 表达式语言, 可以编写复杂逻辑

---

## ⚙️ 安装指南

1. 下载前置插件 [`PlaceholderAPI`](https://www.spigotmc.org/resources/placeholderapi.6245/) 至服务器 `plugins` 文件夹, 并重启服务器, 确保插件正常运行
2. 下载 [本插件](https://github.com/alazeprt/AConditionalPlaceholders/releases/latest) 至服务器 `plugins` 文件夹, 并重启服务器
3. 打开自定义占位符文件 `plugins/AConditionalPlaceholders/placeholders.yml` 按需配置
4. 执行 `/acp reload` 指令后, 即可使用已配置的自定义占位符

---

## 📄 协议

本插件基于 **LGPL-2.1** 协议开源，请遵守相关规定。最终解释权归 *alazeprt* 所有。

