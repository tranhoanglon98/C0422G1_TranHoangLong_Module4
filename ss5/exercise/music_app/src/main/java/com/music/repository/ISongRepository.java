package com.music.repository;

import com.music.model.Song;

import java.util.List;

public interface ISongRepository {

    List<Song> findAll();

    void save(Song song);
}
