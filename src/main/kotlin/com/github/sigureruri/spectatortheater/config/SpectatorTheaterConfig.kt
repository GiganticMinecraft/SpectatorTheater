package com.github.sigureruri.spectatortheater.config

import org.bukkit.Bukkit
import org.bukkit.configuration.file.FileConfiguration

// TODO: cache
class SpectatorTheaterConfig(config: FileConfiguration) {

    val enabledWorlds = config.getStringList("enabled-worlds").mapNotNull { Bukkit.getWorld(it) }

    val coolTime = config.getLong("cool-time")

    val durationTime = config.getLong("duration-time")

}