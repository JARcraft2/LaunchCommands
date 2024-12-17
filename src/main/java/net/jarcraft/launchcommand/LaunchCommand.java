package net.jarcraft.launchcommand;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LaunchCommand implements ModInitializer
{
	public static final String MOD_ID = "launchCommand";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		CommandRegistrationCallback.EVENT.register(ModCommands::register);
	}
}
