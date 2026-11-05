package com.thearchitect;

import com.thearchitect.entity.ArchitectEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.PathfinderMob;

public class ModEntities {

    public static final ResourceKey<EntityType<?>> ARCHITECT_KEY =
            ResourceKey.create(Registries.ENTITY_TYPE, TheArchitect.id("architect"));

    public static final EntityType<ArchitectEntity> ARCHITECT =
            Registry.register(
                    BuiltInRegistries.ENTITY_TYPE,
                    ARCHITECT_KEY,
                    EntityType.Builder.<ArchitectEntity>of(
                            ArchitectEntity::new,
                            MobCategory.CREATURE
                    ).sized(0.6f, 1.8f).build(ARCHITECT_KEY)
            );

    public static void initialize() {
        FabricDefaultAttributeRegistry.register(
                ARCHITECT,
                PathfinderMob.createMobAttributes()
                        .add(Attributes.MAX_HEALTH, 20.0)
                        .add(Attributes.MOVEMENT_SPEED, 0.25)
        );
    }
}