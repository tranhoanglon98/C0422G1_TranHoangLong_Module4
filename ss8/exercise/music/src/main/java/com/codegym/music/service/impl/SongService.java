package com.codegym.music.service.impl;

import com.codegym.music.model.Song;
import com.codegym.music.repository.ISongRepository;
import com.codegym.music.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> findAll() {
        return this.iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        this.iSongRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return this.iSongRepository.findById(id).get();
    }

    @Override
    public void update(Song song) {
        this.iSongRepository.save(song);
    }

    @Override
    public void delete(int id) {
        this.iSongRepository.delete(findById(id));
    }
}
