package com.codegym.music.repository;

import com.codegym.music.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Integer> {
}
