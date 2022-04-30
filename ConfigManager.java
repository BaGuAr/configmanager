package com.github.baguar.manager;

import org.bukkit.configuration.file.*;

import java.io.File;

public class ConfigManager {

    public FileConfiguration config;
    public File file;
    public String fileName;

    public ConfigManager(String fileName) {
        file = new File(Main.instance.getDataFolder(),fileName);
        //System.out.println("(!) Try creating file: " + fileName + ".yml");
        if(!file.exists()){
            try {
                file.createNewFile();
                //System.out.println("(!) Created file: " + fileName + ".yml");
            } catch (Exception e) {
                System.out.println("(!) Error creating file: " + fileName);
            }
        }
        this.fileName = fileName + ".yml";
        config = YamlConfiguration.loadConfiguration(file);
    }

    public void update(String path,String value){
        config.set(path,value);
        save();
    }

    public void update(String path,Integer value){
        config.set(path,value);
        save();
    }

    public void update(String path,Long value){
        config.set(path,value);
        save();
    }


    public void save(){
        //System.out.println("(!) Try saving file: " + fileName);
        try{
            config.save(file);
            //System.out.println("(!) Saved file: " + fileName);
        } catch (Exception e) {
            System.out.println("(!) Error saving file: " + fileName);
        }
    }

    public FileConfiguration getConfig(){
        return config;
    }
}
