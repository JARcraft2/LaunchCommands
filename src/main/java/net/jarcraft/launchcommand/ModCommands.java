package net.jarcraft.launchcommand;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.Vec3ArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class ModCommands
{
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess dedicated, CommandManager.RegistrationEnvironment environment)
    {
        dispatcher.register(
                CommandManager.literal("launchfacing")
                        .requires(source -> source.hasPermissionLevel(2))
                        .then(CommandManager.argument("target", EntityArgumentType.entity())
                                .then(CommandManager.argument("strength", DoubleArgumentType.doubleArg())
                                        .executes( context -> launchTowards(context.getSource(), EntityArgumentType.getEntity(context, "target"), getTargetPointFromEntityDirection(EntityArgumentType.getEntity(context, "target")), DoubleArgumentType.getDouble(context, "strength"), Boolean.FALSE))
                                        .then(CommandManager.argument("overwrite", BoolArgumentType.bool())
                                                .executes( context -> launchTowards(context.getSource(), EntityArgumentType.getEntity(context, "target"), getTargetPointFromEntityDirection(EntityArgumentType.getEntity(context, "target")), DoubleArgumentType.getDouble(context, "strength"), BoolArgumentType.getBool(context, "overwrite")))
                                        ))));

        dispatcher.register(
                CommandManager.literal("launchtopoint")
                        .requires(source -> source.hasPermissionLevel(2))
                        .then(CommandManager.argument("target", EntityArgumentType.entity())
                                .then(CommandManager.argument("destination", Vec3ArgumentType.vec3())
                                        .then(CommandManager.argument("strength", DoubleArgumentType.doubleArg())
                                                .executes( context -> launchTowards(context.getSource(), EntityArgumentType.getEntity(context, "target"), Vec3ArgumentType.getVec3(context, "destination"), DoubleArgumentType.getDouble(context, "strength"), Boolean.FALSE))
                                                .then(CommandManager.argument("overwrite", BoolArgumentType.bool())
                                                        .executes( context -> launchTowards(context.getSource(), EntityArgumentType.getEntity(context, "target"), Vec3ArgumentType.getVec3(context, "destination"), DoubleArgumentType.getDouble(context, "strength"), BoolArgumentType.getBool(context, "overwrite")))
                                                )))));

        dispatcher.register(
                CommandManager.literal("launchtoentity")
                        .requires(source -> source.hasPermissionLevel(2))
                        .then(CommandManager.argument("target", EntityArgumentType.entity())
                                .then(CommandManager.argument("destination", EntityArgumentType.entity())
                                        .then(CommandManager.argument("strength", DoubleArgumentType.doubleArg())
                                                .executes( context -> launchTowards(context.getSource(), EntityArgumentType.getEntity(context, "target"), EntityArgumentType.getEntity(context, "destination").getPos(), DoubleArgumentType.getDouble(context, "strength"), Boolean.FALSE))
                                                .then(CommandManager.argument("overwrite", BoolArgumentType.bool())
                                                        .executes( context -> launchTowards(context.getSource(), EntityArgumentType.getEntity(context, "target"), EntityArgumentType.getEntity(context, "destination").getPos(), DoubleArgumentType.getDouble(context, "strength"), BoolArgumentType.getBool(context, "overwrite")))
                                                )))));
    }

    public static int launchTowards(ServerCommandSource source, Entity target, Vec3d targetPoint, Double strength, Boolean overwriteVelocity)
    {
        Vec3d launchDirection = targetPoint.subtract(target.getPos()).normalize();
        Vec3d velocity = launchDirection.multiply(strength);

        if (overwriteVelocity)
        {
            target.setVelocity(velocity);
        }
        else
        {
            target.addVelocity(velocity);
        }

        target.velocityModified = true;

        source.sendFeedback(() -> Text.translatable("commands.launch.success", target.getDisplayName()), true);

        return 1;
    }

    public static Vec3d getTargetPointFromEntityDirection(Entity entity)
    {
        return entity.getPos().add(entity.getRotationVector());
    }
}
