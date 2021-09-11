package ir.maktab56.hw13.base.repository;

import ir.maktab56.hw13.base.domain.BaseEntity;
import ir.maktab56.hw13.base.service.BaseService;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface BaseRepository<E extends BaseEntity<ID>,ID extends Serializable> extends BaseService<E,ID> {
    EntityManager getEntityManager();
    E findById(ID id);
    List<E> findAll();
    boolean isExists(ID id);
    void remove(ID id);
    Long countAll();
    E sava(E e);

}
