# AConditionalPlaceholders

English | [简体中文](./README_zh.md)

---

## 📝 Introduction

**AConditionalPlaceholders** is a flexible Minecraft Spigot plugin designed to allow administrators to create custom placeholders based on existing placeholder data and display them in-game. By configuring simple rules, you can build diverse conditional judgment systems that return different content based on players' in-game status (other placeholders, such as player balance `%vault_eco_balance%`).

---

## 🌟 Features

- **Lightweight**: The plugin (including dependencies) is only about 2MB in size.
- **Simple**: Configuration file contains only 14 lines with detailed comments. Its structure (priority/conditions/results) is straightforward and suitable for absolute beginners.
- **Flexible**: Based on `SpEL` (`Spring Expression Language`), enabling complex logic implementation.

---

## ⚙️ Installation Guide

1. Download the prerequisite plugin [`PlaceholderAPI`](https://www.spigotmc.org/resources/placeholderapi.6245/) to your server's `plugins` folder, then restart the server to ensure it runs properly.
2. Download this plugin to your server's `plugins` folder and restart the server.
3. Open the custom placeholder configuration file `plugins/AConditionalPlaceholders/placeholders.yml` and configure as needed.
4. Execute `/acp reload` command to activate the configured custom placeholders.

Example configuration file (`placeholders.yml`):

```yaml
# 占位符名称 (%acpapi_你的名称%, 此处为test)
test:
  - priority: 50 # 匹配的优先级 (越高越先匹配)
    condition: "%vault_eco_balance% > 10000" # 通过匹配的条件 (支持PlaceholderAPI, 要求返回 Boolean (bool) 值) 若匹配则不会进行后面的匹配
    result: "贵族玩家" # 若匹配则返回的占位符的对应结果
  - priority: 10
    condition: "%vault_eco_balance% > 1000"
    result: "小康玩家"
  - priority: 2
    result: "if (%vault_eco_balance% == 0) '新玩家'" # 返回的结果支持表达式 (表达式中字符串要用''框住表示)
  - priority: 1
    result: "普通玩家"

```

---

## 📄 License

This plugin is open-sourced under the **LGPL-2.1** license. Please comply with the relevant regulations. All final interpretations belong to *alazeprt*.