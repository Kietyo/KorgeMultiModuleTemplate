package com.xenotactic.korge.scenes

import com.soywiz.korev.Key
import com.soywiz.korge.input.keys
import com.soywiz.korge.view.*

class UIKey(
    gameWorld: GameWorld,
    val key: Key
) : Container() {
    init {
        val bg = solidRect(
            GameConstants.KEY_WIDTH,
            GameConstants.KEY_HEIGHT, color = GameConstants.UNPRESSED_COLOR
        )
        val text = text(key.upperCaseString) {
            scaleWhileMaintainingAspect(ScalingOption.ByHeight(GameConstants.KEY_TEXT_HEIGHT))
            centerOn(bg)
        }
        keys {
            down(key) {
                gameWorld.sfxClap.play()
                bg.color = GameConstants.PRESSED_COLOR
                gameWorld.recentlyPressedKeys.add(key)
            }
            up(key) {
                bg.color = GameConstants.UNPRESSED_COLOR
            }
        }
    }
}