
package com.thearchitect.entity;

import com.thearchitect.ai.ArchitectBrain;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class ArchitectEntity extends PathfinderMob {

    public ArchitectEntity(EntityType<? extends ArchitectEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {

        if (this.level().isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        String response = ArchitectBrain.think("bread");

        player.sendSystemMessage(
                Component.literal("The Architect: " + response)
        );

        return InteractionResult.SUCCESS;
    }

    public String askBrain(String question) {
        return ArchitectBrain.think(question);
    }
}
