package repository;

import model.CentroDistribuicao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CentroDistribuicaoRepository {
    private EntityManagerFactory emf;
    private EntityManager em;

    public CentroDistribuicaoRepository() {
        this.emf = Persistence.createEntityManagerFactory("flood-relief-backend");
        this.em = emf.createEntityManager();
    }

    public void create(CentroDistribuicao centroDistribuicao) {
        em.getTransaction().begin();
        em.persist(centroDistribuicao);
        em.getTransaction().commit();
    }

    public CentroDistribuicao read(int id) {
        return em.find(CentroDistribuicao.class, id);
    }

    public List<CentroDistribuicao> readAll() {
        return em.createQuery("SELECT c FROM CentroDistribuicao c", CentroDistribuicao.class).getResultList();
    }

    public void update(CentroDistribuicao centroDistribuicao) {
        em.getTransaction().begin();
        em.merge(centroDistribuicao);
        em.getTransaction().commit();
    }

    public void delete(int id) {
        em.getTransaction().begin();
        CentroDistribuicao centroDistribuicao = em.find(CentroDistribuicao.class, id);
        if (centroDistribuicao != null) {
            em.remove(centroDistribuicao);
        }
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
        emf.close();
    }
}
