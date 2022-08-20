package com.music.service;

import com.music.model.Song;

import java.util.List;

public interface ISongService {

    List<Song> findAll();

    void save(Song song);
}
