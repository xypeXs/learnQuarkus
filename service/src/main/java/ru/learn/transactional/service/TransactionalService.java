package ru.learn.transactional.service;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.function.UnaryOperator;

@ApplicationScoped
public class TransactionalService {

    public void saveTransactionalSameBeanInnerCall(PanacheEntity entity) {
        saveTransactional(entity);
    }

    @Transactional
    public void saveTransactionalWithSameBeanInnerCallNewTransactionRollback(PanacheEntity entity, UnaryOperator<PanacheEntity> entityUpdateFunction) {
        entity.persist();
        PanacheEntity updatedEntity = entityUpdateFunction.apply(entity);
        saveTransactionalAndRollBack(updatedEntity);
    }

    @Transactional
    private void saveTransactional(PanacheEntity entity) {
        entity.persist();
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    private void saveTransactionalAndRollBack(PanacheEntity entity) {
        entity.persist();
        throw new IllegalStateException();
    }

}
