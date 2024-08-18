package me.lukasabbe.dripfaster.config;

import me.lukasabbe.dripfaster.Dripfaster;
import net.fabricmc.loader.api.FabricLoader;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Config {
    public float lavaDrip = 0.17578125F;
    public float waterDrip = 0.05859375F;

    public Config(){
        loadConfig();
    }

    private void loadConfig() {
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve("drip-chances.yml");
        if(!Files.exists(configPath)) createConfig(configPath);
        Yaml yaml = new Yaml();
        try{
            Map<String, Object> configMap = yaml.load(new FileReader(configPath.toFile()));
            if(configMap.containsKey("lavaDrip")){
                lavaDrip = ((float)(double) configMap.get("lavaDrip"))/100;
            }
            if(configMap.containsKey("waterDrip")){
                waterDrip = ((float)(double)configMap.get("waterDrip"))/100;
            }
        } catch (FileNotFoundException | ClassCastException e) {
            Dripfaster.LOGGER.error("ERROR WHEN CONVERTING VALUES FROM CONFIG",e);
        }
    }

    private void createConfig(Path configPath) {
        FabricLoader.getInstance().getModContainer(Dripfaster.MOD_ID).ifPresent(modContainer -> {
            Path path = modContainer.findPath("drip-chances.yml").orElseThrow();
            try {
                Files.copy(path,configPath);
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        });
    }
    public void reloadConfig(){
        loadConfig();
    }
}
