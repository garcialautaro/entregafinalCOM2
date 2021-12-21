package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Vendedor;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

public class VendedorJpaController implements Serializable {

    public VendedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public VendedorJpaController(){
        emf = Persistence.createEntityManagerFactory("EntregaPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vendedor vendedor) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vendedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVendedor(vendedor.getIdVendedor()) != null) {
                throw new PreexistingEntityException("Vendedor " + vendedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vendedor vendedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            vendedor = em.merge(vendedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vendedor.getIdVendedor();
                if (findVendedor(id) == null) {
                    throw new NonexistentEntityException("The vendedor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vendedor vendedor;
            try {
                vendedor = em.getReference(Vendedor.class, id);
                vendedor.getIdVendedor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vendedor with id " + id + " no longer exists.", enfe);
            }
            em.remove(vendedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vendedor> findVendedorEntities() {
        return findVendedorEntities(true, -1, -1);
    }

    public List<Vendedor> findVendedorEntities(int maxResults, int firstResult) {
        return findVendedorEntities(false, maxResults, firstResult);
    }

    private List<Vendedor> findVendedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vendedor.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Vendedor findVendedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vendedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getVendedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vendedor> rt = cq.from(Vendedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
