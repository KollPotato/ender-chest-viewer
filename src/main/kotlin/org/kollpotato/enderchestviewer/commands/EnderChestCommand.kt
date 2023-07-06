package org.kollpotato.enderchestviewer.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.kollpotato.enderchestviewer.Config
import org.kollpotato.enderchestviewer.utils.EnderChestUtils

class EnderChestCommand : CommandExecutor {
    private val logger = Bukkit.getLogger()

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender !is Player) {
            logger.info(Config.notConsoleCommand); return true
        }

        if (args == null) {
            return true
        }
            
        if (args.isEmpty()) {
            EnderChestUtils.openEnderChest(sender)
            return true
        }

        if (args.count() != 1) {
            return true
        }

        val targetUsername = args[0]
        val target = Bukkit.getPlayer(targetUsername)
        
        if (target == null) {
            sender.sendMessage("There is no player with name $targetUsername")
            return true
        }
        
        EnderChestUtils.openEnderChest(sender, target)
        return true
    }

}
