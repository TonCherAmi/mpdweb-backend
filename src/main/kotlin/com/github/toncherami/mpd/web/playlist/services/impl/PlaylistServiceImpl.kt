package com.github.toncherami.mpd.web.playlist.services.impl

import com.github.toncherami.mpd.web.adapter.services.MpdService
import com.github.toncherami.mpd.web.database.dto.DatabaseFile
import com.github.toncherami.mpd.web.playlist.services.PlaylistService
import org.springframework.stereotype.Service

@Service
class PlaylistServiceImpl(private val mpdService: MpdService) : PlaylistService {

    override fun get(): List<DatabaseFile> {
        return mpdService.playlistinfo().map(DatabaseFile::of)
    }

    override fun add(uri: String) {
        return mpdService.add(uri)
    }

    override fun clear() {
        return mpdService.clear()
    }

}
