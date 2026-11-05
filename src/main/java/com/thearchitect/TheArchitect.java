
package com.thearchitect;

import com.thearchitect.entity.ArchitectEntity;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import net.minecraft.commands.Commands;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.network.chat.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheArchitect implements ModInitializer {

    public static final String MOD_ID = "the-architect";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        LOGGER.info("Hello Fabric world!");

        ModEntities.initialize();

        LOGGER.info("Architect entity registered!");

        LOGGER.info("Architect knowledge test: {}",
                com.thearchitect.ai.ArchitectBrain.think("bread"));

        // Register summon command
        CommandRegistrationCallback.EVENT.register(
                (dispatcher, registryAccess, environment) -> {

                    dispatcher.register(
                            Commands.literal("architect")
                                    .executes(context -> {

                                        var player = context.getSource()
                                                .getPlayerOrException();

                                        ArchitectEntity architect =
                                                ModEntities.ARCHITECT.create(
                                                        player.level(),
                                                        EntitySpawnReason.COMMAND
                                                );

                                        if (architect == null) {
                                            return 0;
                                        }

                                        architect.setPos(
                                                player.getX() + 2,
                                                player.getY(),
                                                player.getZ()
                                        );

                                        architect.setYRot(player.getYRot());
                                        architect.setYHeadRot(player.getYRot());

                                        player.level().addFreshEntity(architect);

                                        context.getSource().sendSuccess(
                                                () -> Component.literal(
                                                        "The Architect has arrived!"
                                                ),
                                                false
                                        );

                                        return 1;
                                    })
                    );
                }
        );
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
