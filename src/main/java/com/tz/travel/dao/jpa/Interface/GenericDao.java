package com.tz.travel.dao.jpa.Interface;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by tzjeefjalft on 12/10/2014.
 */
public interface GenericDao<T, K> {
    T find(K id);

    List<T> find(Collection<K> keys);

    void create(T entity);

    void update(T entity);

    T deleteByKey(K id);

    void delete(T entity);

    List<T> list(int firstResult, int maxResult);

    public List<T> findByParams(Map<String, Object> queryParams);
}
