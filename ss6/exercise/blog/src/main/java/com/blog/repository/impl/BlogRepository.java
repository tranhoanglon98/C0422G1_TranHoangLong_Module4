package com.blog.repository.impl;

import com.blog.model.Blog;
import com.blog.repository.IBlogRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepository implements IBlogRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> typedQuery =
                entityManager.createQuery("select b from Blog  b", Blog.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() != 0) {
            entityManager.merge(blog);
        } else {
            entityManager.persist(blog);
        }
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }

    @Override
    public Blog findById(int id) {
        TypedQuery typedQuery =
                entityManager.createQuery("select b from Blog b where b.id = :id", Blog.class);
        typedQuery.setParameter("id", id);
        return null;
    }


}
