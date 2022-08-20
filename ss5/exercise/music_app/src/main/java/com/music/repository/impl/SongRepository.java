package com.music.repository.impl;

import com.music.model.Song;
import com.music.repository.ISongRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class SongRepository implements ISongRepository {
    private final String FIND_ALL = "select s from Song s";
    private final String FIND_BY_ID = "select s from Song s where s.id = :id";

    @Override
    public List<Song> findAll() {
        TypedQuery<Song> typedQuery =
                BaseRepository.entityManager.createQuery(FIND_ALL, Song.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();

        BaseRepository.entityManager.persist(song);

        entityTransaction.commit();
    }

    @Override
    public Song findById(int id) {
        TypedQuery<Song> typedQuery =
                BaseRepository.entityManager.createQuery(FIND_BY_ID, Song.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void update(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();

        BaseRepository.entityManager.merge(song);

        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();

        BaseRepository.entityManager.remove(findById(id));

        entityTransaction.commit();
    }


}
