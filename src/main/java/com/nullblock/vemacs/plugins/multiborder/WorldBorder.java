package com.nullblock.vemacs.plugins.multiborder;

// Sorry guys, I couldn't think of a better name

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldBorder {

    private List<Border> borders;

    public WorldBorder(List<Border> borders) {
        this.borders = borders;
    }

    public String getWorld() {
        return borders.get(0).getCenter().getWorld().getName();
    }

    public void setWorld(String world) {
        for (Border border : borders) {
            border.getCenter().setWorld(Bukkit.getWorld(world));
        }
    }

    public boolean isInside(Location location) {
        if (!location.getWorld().getName().equals(this.getWorld())) {
            return false;
        }
        for (Border border : borders) {
            if (!border.contains(location)) {
                return false;
            }
        }
        return true;
    }

    public Border getClosest(Location location) {
        HashMap<Border, Long> distances = new HashMap<Border, Long>();
        for (Border border : borders) {
            distances.put(border, (long) location.distance(border.getCenter()) - border.getRadius());
        }
        Long mindistance = Collections.min(distances.values());
        for (Map.Entry<Border, Long> distance : distances.entrySet()) {
            if (distance.getValue().equals(mindistance)) {
                return distance.getKey();
            }
        }
        return null;
    }

}
