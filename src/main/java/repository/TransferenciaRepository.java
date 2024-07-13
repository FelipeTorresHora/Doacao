package repository;

import model.Transferencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class TransferenciaRepository {
    private EntityManager entityManager;

    public TransferenciaRepository() {
        this.entityManager = Persistence.createEntityManagerFactory("floodReliefPU").createEntityManager();
    }

    public void save(Transferencia transferencia) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(transferencia);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Transferencia findById(int id) {
        return entityManager.find(Transferencia.class, id);
    }

    public List<Transferencia> findAll() {
        return entityManager.createQuery("from Transferencia", Transferencia.class).getResultList();
    }

    public void update(Transferencia transferencia) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(transferencia);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(Transferencia transferencia) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(entityManager.contains(transferencia) ? transferencia : entityManager.merge(transferencia));
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
