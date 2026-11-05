package com.thearchitect.ai;

import java.util.HashMap;
import java.util.Map;

public class KnowledgeBase {

    private static final Map<String, String> KNOWLEDGE = new HashMap<>();

    static {
        // Crafting
        add("wooden_pickaxe", "Craft using 3 wooden planks and 2 sticks.");
        add("stone_pickaxe", "Craft using 3 cobblestone and 2 sticks.");
        add("iron_pickaxe", "Craft using 3 iron ingots and 2 sticks.");
        add("crafting_table", "Craft using 4 wooden planks.");
        add("furnace", "Craft using 8 cobblestone.");

        // Mining
        add("coal", "Coal ore can be mined to obtain coal.");
        add("iron", "Mine iron ore and smelt raw iron into iron ingots.");
        add("gold", "Mine gold ore and smelt raw gold into gold ingots.");
        add("diamond", "Diamond ore requires an iron pickaxe or better.");
        add("obsidian", "Obsidian requires a diamond pickaxe to collect.");

        // Survival
        add("bread", "Craft using 3 wheat in a horizontal row.");
        add("wheat", "Grow wheat from seeds on farmland.");
        add("armor", "Armor helps protect against incoming damage.");
        add("shield", "A shield can block many incoming attacks.");

        // Redstone
        add("redstone", "Redstone dust is used to create circuits.");
        add("repeater", "A repeater can delay and extend redstone signals.");
        add("piston", "A piston moves blocks when powered.");

        // Enchanting
        add("enchanting_table", "Craft using 4 obsidian, 2 diamonds and 1 book.");
        add("experience", "Experience is used for enchanting and repairing equipment.");

        // Exploration
        add("nether", "The Nether is a dangerous dimension accessed through a portal.");
        add("end", "The End is a dimension containing the Ender Dragon.");
        add("stronghold", "Strongholds contain End portals.");
    }

    private static void add(String topic, String information) {
        KNOWLEDGE.put(topic, information);
    }

    public static String getKnowledge(String topic) {
        return KNOWLEDGE.getOrDefault(
            topic.toLowerCase().trim(),
            "I don't know about that yet."
        );
    }
}