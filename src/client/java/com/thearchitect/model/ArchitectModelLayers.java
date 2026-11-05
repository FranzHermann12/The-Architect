package com.thearchitect.model;

import com.thearchitect.TheArchitect;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;

public class ArchitectModelLayers {

    public static final ModelLayerLocation ARCHITECT =
            new ModelLayerLocation(
                    Identifier.fromNamespaceAndPath(
                            TheArchitect.MOD_ID, "architect"
                    ),
                    "main"
            );

    public static void registerModelLayers() {
        ModelLayerRegistry.registerModelLayer(
                ARCHITECT,
                ArchitectModel::createBodyLayer
        );
    }
}