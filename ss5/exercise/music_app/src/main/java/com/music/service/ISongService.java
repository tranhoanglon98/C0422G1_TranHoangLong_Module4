package com.music.service;

import com.music.model.Song;

import java.util.List;

public interface ISongService {

    List<Song> findAll();

    void save(Song song);

    Song findById(int id);

    void update(Song song);

    void delete(int id);
}
