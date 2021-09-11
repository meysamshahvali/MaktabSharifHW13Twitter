package ir.maktab56.hw13.base.service.impl;

import ir.maktab56.hw13.base.domain.BaseEntity;
import ir.maktab56.hw13.base.repository.BaseRepository;
import ir.maktab56.hw13.base.service.BaseService;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<E extends BaseEntity<ID>,ID extends Serializable,R extends BaseRepository<E,ID>> implements BaseService<E,ID> {
    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    public R getRepository() {
        return repository;
    }

    @Override
    public E findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean isExists(ID id) {
        return repository.isExists(id);
    }

    @Override
    public void remove(ID id) {
        repository.remove(id);

    }

    @Override
    public Long countAll() {
        return repository.countAll();
    }

    @Override
    public E sava(E e) {
        return null;
    }
}
