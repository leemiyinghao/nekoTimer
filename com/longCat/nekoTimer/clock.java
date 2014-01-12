package com.longCat.nekoTimer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class clock extends BukkitRunnable {
	 
    private final Player player;
    private final String name;
 
    public clock(String player,String name) {
        this.player = Bukkit.getServer().getPlayer(player);
        this.name = name;
    }
 
    public void run() {
    	player.sendMessage(ChatColor.GREEN + "Timer " + name + " is up!");
    }
}