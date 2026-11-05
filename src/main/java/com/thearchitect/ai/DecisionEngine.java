package com.thearchitect.ai;

import com.thearchitect.entity.ArchitectEntity;

public class DecisionEngine {

    public static String decide(String situation) {

        if (situation.equalsIgnoreCase("hungry")) {
            return "FIND_FOOD";
        }

        if (situation.equalsIgnoreCase("danger")) {
            return "FIND_SAFETY";
        }

        if (situation.equalsIgnoreCase("need_resources")) {
            return "GATHER_RESOURCES";
        }

        return "IDLE";
    }

    public static String decideFromHealth(ArchitectEntity entity) {

        String condition = ArchitectBrain.evaluateCondition(entity);

        if (condition.equals("CRITICAL_HEALTH")) {
            return "FIND_SAFETY";
        }

        if (condition.equals("LOW_HEALTH")) {
            return "AVOID_DANGER";
        }

        return "CONTINUE_TASK";
    }
}