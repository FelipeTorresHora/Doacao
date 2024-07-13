package repository;

import model.Abrigo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AbrigoRepository {
    private EntityManagerFactory emf;
    private EntityManager em;

    public AbrigoRepository() {
        this.emf = Persistence.createEntityManagerFactory("flood-relief-backend");
        this.em = emf.createEntityManager();
    }

    public void create(Abrigo abrigo) {
        em.getTransaction().begin();
        em.persist(abrigo);
        em.getTransaction().commit();
    }

    public Abrigo read(int id) {
        return em.find(Abrigo.class, id);
    }

    public List<Abrigo> readAll() {
        return em.createQuery("SELECT a FROM Abrigo a", Abrigo.class).getResultList();
    }

    public void update(Abrigo abrigo) {
        em.getTransaction().begin();
        em.merge(abrigo);
        em.getTransaction().commit();
    }

    public void delete(int id) {
        em.getTransaction().begin();
        Abrigo abrigo = em.find(Abrigo.class, id);
        if (abrigo != null) {
            em.remove(abrigo);
        }
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
        emf.close();
    }
}
