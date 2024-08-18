package me.lukasabbe.dripfaster;

import me.lukasabbe.dripfaster.config.Config;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dripfaster implements ModInitializer {
    public static final String MOD_ID = "dripfaster";
    public static Config CONFIG;
    public static final Logger LOGGER = LoggerFactory.getLogger("MOD_ID");

    @Override
    public void onInitialize() {
        CONFIG = new Config();
    }
}
