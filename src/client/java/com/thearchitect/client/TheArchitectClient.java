
package com.thearchitect.client;

import com.thearchitect.ModEntities;
import com.thearchitect.model.ArchitectModelLayers;
import com.thearchitect.render.ArchitectRenderer;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class TheArchitectClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        // Register the model layer
        ArchitectModelLayers.registerModelLayers();

        // Register The Architect's renderer
        EntityRenderers.register(
                ModEntities.ARCHITECT,
                ArchitectRenderer::new
        );
    }
}
