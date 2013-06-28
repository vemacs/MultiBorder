package com.nullblock.vemacs.plugins.multiborder;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MultiBorder extends JavaPlugin implements Listener {
    public void onDisable() {
    }

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
    }


}

