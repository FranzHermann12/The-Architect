package com.thearchitect.render;

import com.thearchitect.entity.ArchitectEntity;
import com.thearchitect.model.ArchitectModel;
import com.thearchitect.model.ArchitectModelLayers;
import com.thearchitect.state.ArchitectRenderState;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public class ArchitectRenderer extends MobRenderer<
        ArchitectEntity,
        ArchitectRenderState,
        ArchitectModel> {

    private static final Identifier TEXTURE =
            Identifier.fromNamespaceAndPath(
                    "the-architect",
                    "textures/entity/architect.png"
            );

    public ArchitectRenderer(EntityRendererProvider.Context context) {
        super(
                context,
                new ArchitectModel(
                        context.bakeLayer(ArchitectModelLayers.ARCHITECT)
                ),
                0.5f
        );
    }

    @Override
    public ArchitectRenderState createRenderState() {
        return new ArchitectRenderState();
    }

    @Override
    public Identifier getTextureLocation(ArchitectRenderState state) {
        return TEXTURE;
    }
}