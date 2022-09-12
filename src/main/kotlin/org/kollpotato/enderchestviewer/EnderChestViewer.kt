package org.kollpotato.enderchestviewer

import org.bukkit.plugin.java.JavaPlugin
import org.kollpotato.enderchestviewer.commands.EnderChestCommand

class EnderChestViewer : JavaPlugin() {

    override fun onEnable() {
        getCommand("enderchest")?.setExecutor(EnderChestCommand())
    }

    override fun onDisable() {

    }

}