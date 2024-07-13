package repository;


import model.Doacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DoacaoRepository {
    private EntityManagerFactory emf;
    private EntityManager em;

    public DoacaoRepository() {
        this.emf = Persistence.createEntityManagerFactory("flood-relief-backend");
        this.em = emf.createEntityManager();
    }

    public void create(Doacao doacao) {
        em.getTransaction().begin();
        em.persist(doacao);
        em.getTransaction().commit();
    }

    public Doacao read(int id) {
        return em.find(Doacao.class, id);
    }

    public List<Doacao> readAll() {
        return em.createQuery("SELECT d FROM Doacao d", Doacao.class).getResultList();
    }

    public void update(Doacao doacao) {
        em.getTransaction().begin();
        em.merge(doacao);
        em.getTransaction().commit();
    }

    public void delete(int id) {
        em.getTransaction().begin();
        Doacao doacao = em.find(Doacao.class, id);
        if (doacao != null) {
            em.remove(doacao);
        }
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
        emf.close();
    }
}
