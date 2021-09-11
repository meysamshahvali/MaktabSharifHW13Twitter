package ir.maktab56.hw13.base.service;

import ir.maktab56.hw13.base.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService< E extends BaseEntity<ID>, ID extends Serializable> {
    E findById(ID id);
    List<E> findAll();
    boolean isExists(ID id);
    void remove(ID id);
    Long countAll();
    E sava(E e);
}
