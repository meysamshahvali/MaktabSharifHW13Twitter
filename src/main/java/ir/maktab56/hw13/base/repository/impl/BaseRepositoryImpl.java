package ir.maktab56.hw13.base.repository.impl;

import ir.maktab56.hw13.base.domain.BaseEntity;
import ir.maktab56.hw13.base.repository.BaseRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<E, ID> {

    protected final EntityManager entityManager;

    public BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    abstract Class<E> getEntityClass();

    @Override
    public E findById(ID id) {
        return entityManager.createQuery("from "+getEntityClass().getSimpleName()+" where id=:id",getEntityClass()).setParameter("id",id).getSingleResult();
    }

    @Override
    public List<E> findAll() {
        return entityManager.createQuery("from "+getEntityClass().getSimpleName(),getEntityClass()).getResultList();
    }

    @Override
    public boolean isExists(ID id) {
        return entityManager.createQuery("select count(id) from "+getEntityClass().getSimpleName(),Long.class).setParameter("id",id).getSingleResult()==1l;
    }

    @Override
    public void remove(ID id) {
        entityManager.remove(findById(id));

    }

    @Override
    public Long countAll() {
        return entityManager.createQuery("select count(*) from "+getEntityClass().getSimpleName(),Long.class).getSingleResult();
    }

    @Override
    public E sava(E e) {
        if(e.getId()==null){
            entityManager.persist(e);
        }
        else
            entityManager.merge(e);
        return e;
    }
}
