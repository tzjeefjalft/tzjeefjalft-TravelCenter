package com.tz.travel.dao.jpa.impl;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.tz.travel.dao.jpa.Interface.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tzjeefjalft on 12/10/2014.
 */
public class AbstractGenericDao<T, K> implements GenericDao<T, K> {
    private final Class<T> persistentClass;
    private final Class<K> idClass;

//    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
//    private EntityManager entityManager = emf.createEntityManager();
    @PersistenceContext
    protected EntityManager entityManager;

    public AbstractGenericDao(Class<T> persistentClass, Class<K> idClass) {
        this.persistentClass = persistentClass;
        this.idClass = idClass;
    }

    @Override
    public T find(K id) {
        return entityManager.find(persistentClass, id);
    }

    @Override
    public List<T> find(Collection<K> keys) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(persistentClass);
        Root<T> root = cq.from(persistentClass);
        EntityType<T> typeT = root.getModel();
        cq.select(root);

        cq.where(root.get(typeT.getDeclaredId(idClass)).in(keys));
        TypedQuery<T> query = entityManager.createQuery(cq);

        return query.getResultList();
    }

    @Override
    public void create(T entity) {
        entityManager.persist(entity);

    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);

    }

    @Override
    public T deleteByKey(K id) {
        T entity = find(id);
        if (entity != null) {
            entityManager.remove(entity);
            return entity;
        }
        return null;

    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);

    }

    @Override
    public List<T> findByParams(Map<String, Object> queryParams) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(persistentClass);
        Root<T> entityRoot = cq.from(persistentClass);

        List<Predicate> predicates = new ArrayList<Predicate>();

        cq.select(entityRoot);
        for (String paramName : queryParams.keySet()) {
            Object paramValue = queryParams.get(paramName);
            if (paramValue != null) {
                predicates.add(cb.equal(entityRoot.get(paramName), paramValue));
            }
        }
        cq.select(entityRoot).where(predicates.toArray(new Predicate[] {}));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Override
    public List<T> list(int firstResult, int maxResult) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(persistentClass);
        Root<T> root = cq.from(persistentClass);
        cq.select(root);
        TypedQuery<T> query = entityManager.createQuery(cq);
        return query.setFirstResult(firstResult).setMaxResults(maxResult).getResultList();
    }

    protected List<T> query(String qryStr, Map<String, Object> parameterMap, int firstResult, int maxResult) {
        return createQuery(qryStr, parameterMap).setFirstResult(firstResult).setMaxResults(maxResult).getResultList();
    }

    protected List<T> query(String qry, Map<String, Object> parameterMap) {
        return query(qry, parameterMap, 0, Integer.MAX_VALUE);
    }

    protected List<T> findByNamedQuery(String name, Map<String, Object> parameterMap, int firstResult, int maxResult) {
        return createNamedQuery(name, parameterMap).setFirstResult(firstResult).setMaxResults(maxResult)
                .getResultList();
    }

    protected List<T> findByNamedQuery(String name, Map<String, Object> parameterMap) {
        return findByNamedQuery(name, parameterMap, 0, Integer.MAX_VALUE);
    }

    protected T findUniqueObjectByNamedQuery(String name, Map<String, Object> parameterMap) {
        TypedQuery<T> query = createNamedQuery(name, parameterMap);
        return getUniqueResult(query);
    }

    protected T queryUniqueObject(String qryStr, Map<String, Object> parameterMap) {

        TypedQuery<T> query = createQuery(qryStr, parameterMap);
        return getUniqueResult(query);
    }

    protected TypedQuery<T> createQuery(String qry, Map<String, Object> parameterMap) {
        TypedQuery<T> query = entityManager.createQuery(qry, persistentClass);
        setParameters(query, parameterMap);
        return query;
    }

    protected TypedQuery<T> createNamedQuery(String name, Map<String, Object> parameterMap) {
        TypedQuery<T> query = entityManager.createNamedQuery(name, persistentClass);
        setParameters(query, parameterMap);
        return query;
    }

    protected TypedQuery<T> createQuery(String qry) {
        return createQuery(qry, null);

    }

    protected TypedQuery<T> createNamedQUery(String name) {
        return createNamedQuery(name, null);
    }

    protected void setParameters(TypedQuery<T> query, Map<String, Object> parameterMap) {
        if (parameterMap != null) {
            for (String paramName : parameterMap.keySet()) {
                Object paramValue = parameterMap.get(paramName);
                query.setParameter(paramName, paramValue);
            }
        }
    }

    protected List<T> query(String qryStr) {
        return query(qryStr, null);
    }

    private T getUniqueResult(TypedQuery<T> query) {
        List<T> results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        if (results.size() > 1) {
        }
        return results.get(0);
    }
}
