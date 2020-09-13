package com.github.toncherami.mpd.web.utils

import java.lang.IllegalStateException

enum class MpdCommand(val value: String) {

    PLAY("play"),
    STOP("stop"),
    PAUSE("pause"),
    STATUS("status"),
    PLAYLISTINFO("playlistinfo");

}

enum class MpdBoolean(val value: String) {

    TRUE("1"),
    FALSE("0")

}

class MpdCommandBuilder {

    private var command: MpdCommand? = null
    private val arguments: MutableList<String> = mutableListOf()

    fun command(mpdCommand: MpdCommand): MpdCommandBuilder = this.apply {
        command = mpdCommand
    }

    fun argument(argument: String): MpdCommandBuilder = this.apply {
        arguments.add(argument)
    }

    fun build(): String {
        val commandCode = command?.value
            ?: throw IllegalStateException("MPD command must be specified before calling build")

        return "$commandCode " + arguments.joinToString(" ") {
            "\"$it\""
        }
    }

}
