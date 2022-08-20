package com.product_management.repository.impl;

import com.product_management.model.Product;
import com.product_management.repository.IProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ProductRepository implements IProductRepository {
    private final String FIND_ALL = "select p from Product p where lower(p.name) like lower(:name)";
    private final String FIND_BY_ID = "select p from Product p where p.id = :productId";

    @Override
    public List<Product> findAll(String name) {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery(FIND_ALL, Product.class);
        typedQuery.setParameter("name", "%" + name + "%");
        return typedQuery.getResultList();

    }

    @Override
    public void add(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void update(int id, Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery(FIND_BY_ID, Product.class);
        typedQuery.setParameter("productId", id);
        return typedQuery.getSingleResult();
    }
}
