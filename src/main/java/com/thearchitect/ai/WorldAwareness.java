package com.thearchitect.ai;

import com.thearchitect.entity.ArchitectEntity;

public class WorldAwareness {

    public static int getHealth(ArchitectEntity entity) {
        return (int) entity.getHealth();
    }

    public static int getMaxHealth(ArchitectEntity entity) {
        return (int) entity.getMaxHealth();
    }

    public static boolean isAlive(ArchitectEntity entity) {
        return entity.isAlive();
    }

    public static boolean isOnGround(ArchitectEntity entity) {
        return entity.onGround();
    }

    public static double getX(ArchitectEntity entity) {
        return entity.getX();
    }

    public static double getY(ArchitectEntity entity) {
        return entity.getY();
    }

    public static double getZ(ArchitectEntity entity) {
        return entity.getZ();
    }
}