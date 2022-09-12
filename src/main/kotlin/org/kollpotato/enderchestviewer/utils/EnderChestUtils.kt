package org.kollpotato.enderchestviewer.utils

import org.bukkit.entity.Player
import org.kollpotato.enderchestviewer.Config

object EnderChestUtils {

    fun openEnderChest(sender: Player): Boolean {
        val enderChest = sender.enderChest

        return if (sender.hasPermission("ecv.enderchest.view")) {
            sender.openInventory(enderChest)
            true
        } else {
            sender.sendMessage(Config.openEnderChestNoPermission)
            false
        }

    }

    fun openEnderChest(sender: Player, target: Player): Boolean {
        val enderChest = target.enderChest

        return if (sender.hasPermission("ecv.enderchest.view.other")) {
            sender.openInventory(enderChest)
            true
        } else {
            sender.sendMessage(Config.openOtherEnderChestNoPermission)
            false
        }

    }

}