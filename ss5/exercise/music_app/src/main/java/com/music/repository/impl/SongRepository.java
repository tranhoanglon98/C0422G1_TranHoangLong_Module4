package com.music.repository.impl;

import com.music.model.Song;
import com.music.repository.ISongRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class SongRepository implements ISongRepository {

    @Override
    public List<Song> findAll() {
        TypedQuery<Song> typedQuery =
                BaseRepository.entityManager.createQuery("select s from Song s", Song.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();

        BaseRepository.entityManager.persist(song);

        entityTransaction.commit();
    }
}
