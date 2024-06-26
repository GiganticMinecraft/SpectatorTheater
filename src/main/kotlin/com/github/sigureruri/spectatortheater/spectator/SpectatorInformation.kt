package com.github.sigureruri.spectatortheater.spectator

import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.entity.Player
import java.time.LocalDateTime

/**
 * スペクテイターモードのプレイヤーの情報を表す
 *
 * @property player スペクテイターモードを継続しているプレイヤー
 * @property startedAt スペクテイターモードを開始した時刻
 * @property gameModeBeforeStart スペクテイターモードを開始する前のゲームモード
 */
// startedAtが時間と位置どちらを示すか分かりづらく良い命名ではない
data class SpectatorInformation(
    val player: Player,
    val startedAt: LocalDateTime,
    val gameModeBeforeStart: GameMode
)
