package com.thearchitect.model;

import com.thearchitect.state.ArchitectRenderState;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class ArchitectModel extends EntityModel<ArchitectRenderState> {

    public ArchitectModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        // Head
        root.addOrReplaceChild("head",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-4, -8, -4, 8, 8, 8),
                PartPose.ZERO);

        // Body
        root.addOrReplaceChild("body",
                CubeListBuilder.create()
                        .texOffs(16, 16)
                        .addBox(-4, 0, -2, 8, 12, 4),
                PartPose.ZERO);

        // Arms
        root.addOrReplaceChild("left_arm",
                CubeListBuilder.create()
                        .texOffs(40, 16)
                        .addBox(-2, -2, -2, 4, 12, 4),
                PartPose.offset(-5, 2, 0));

        root.addOrReplaceChild("right_arm",
                CubeListBuilder.create()
                        .texOffs(40, 16)
                        .addBox(-2, -2, -2, 4, 12, 4),
                PartPose.offset(5, 2, 0));

        // Legs
        root.addOrReplaceChild("left_leg",
                CubeListBuilder.create()
                        .texOffs(0, 16)
                        .addBox(-2, 0, -2, 4, 12, 4),
                PartPose.offset(-2, 12, 0));

        root.addOrReplaceChild("right_leg",
                CubeListBuilder.create()
                        .texOffs(0, 16)
                        .addBox(-2, 0, -2, 4, 12, 4),
                PartPose.offset(2, 12, 0));

        return LayerDefinition.create(mesh, 64, 64);
    }
}