package com.thearchitect.ai;

import com.thearchitect.entity.ArchitectEntity;

public class ArchitectBrain {

    // Understand Minecraft questions
    public static String think(String question) {

        if (question == null || question.isBlank()) {
            return "Please ask me something about Minecraft.";
        }

        return KnowledgeBase.getKnowledge(question);
    }

    // Make basic decisions
    public static String makeDecision(String situation) {
        return DecisionEngine.decide(situation);
    }

    // Inspect the Architect's condition and position
    public static String inspectWorld(ArchitectEntity entity) {

        int health = WorldAwareness.getHealth(entity);
        int maxHealth = WorldAwareness.getMaxHealth(entity);

        double x = WorldAwareness.getX(entity);
        double y = WorldAwareness.getY(entity);
        double z = WorldAwareness.getZ(entity);

        return "Health: " + health + "/" + maxHealth
                + " | Position: X=" + x
                + ", Y=" + y
                + ", Z=" + z;
    }

    // Evaluate health
    public static String evaluateCondition(ArchitectEntity entity) {

        int health = WorldAwareness.getHealth(entity);
        int maxHealth = WorldAwareness.getMaxHealth(entity);

        if (health <= maxHealth / 4) {
            return "CRITICAL_HEALTH";
        }

        if (health <= maxHealth / 2) {
            return "LOW_HEALTH";
        }

        return "HEALTHY";
    }
}