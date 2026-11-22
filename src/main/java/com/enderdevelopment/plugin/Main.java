package com.enderdevelopment.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onCreeperExplode(EntityExplodeEvent event) {
        if (event.getEntity() instanceof Creeper) {
            event.setCancelled(true);
            Location location = event.getEntity().getLocation();
            Firework firework = (Firework) location.getWorld().spawn(location, Firework.class);
            FireworkMeta meta = firework.getFireworkMeta();
            meta.addEffect(FireworkEffect.builder()
                    .withColor(Color.fromRGB(11743532), Color.fromRGB(16738740), Color.fromRGB(16711935), Color.fromRGB(16753920), Color.fromRGB(4657967))
                    .with(FireworkEffect.Type.BALL)
                    .flicker(true)
                    .trail(true)
                    .build());
            meta.setPower(1);
            firework.setFireworkMeta(meta);
        }
    }
}