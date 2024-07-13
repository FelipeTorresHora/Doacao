package repository;


import model.OrdemPedido;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class OrdemPedidoRepository {
    private EntityManagerFactory emf;
    private EntityManager em;

    public OrdemPedidoRepository() {
        this.emf = Persistence.createEntityManagerFactory("flood-relief-backend");
        this.em = emf.createEntityManager();
    }

    public void create(OrdemPedido ordemPedido) {
        em.getTransaction().begin();
        em.persist(ordemPedido);
        em.getTransaction().commit();
    }

    public OrdemPedido read(int id) {
        return em.find(OrdemPedido.class, id);
    }

    public List<OrdemPedido> readAll() {
        return em.createQuery("SELECT o FROM OrdemPedido o", OrdemPedido.class).getResultList();
    }

    public void update(OrdemPedido ordemPedido) {
        em.getTransaction().begin();
        em.merge(ordemPedido);
        em.getTransaction().commit();
    }

    public void delete(int id) {
        em.getTransaction().begin();
        OrdemPedido ordemPedido = em.find(OrdemPedido.class, id);
        if (ordemPedido != null) {
            em.remove(ordemPedido);
        }
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
        emf.close();
    }
}
