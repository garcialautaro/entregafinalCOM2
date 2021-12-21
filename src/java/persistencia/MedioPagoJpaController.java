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
import logica.MedioPago;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

public class MedioPagoJpaController implements Serializable {

    public MedioPagoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public MedioPagoJpaController(){
        emf = Persistence.createEntityManagerFactory("EntregaPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MedioPago medioPago) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(medioPago);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMedioPago(medioPago.getCodMedioPago()) != null) {
                throw new PreexistingEntityException("MedioPago " + medioPago + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MedioPago medioPago) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            medioPago = em.merge(medioPago);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = medioPago.getCodMedioPago();
                if (findMedioPago(id) == null) {
                    throw new NonexistentEntityException("The medioPago with id " + id + " no longer exists.");
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
            MedioPago medioPago;
            try {
                medioPago = em.getReference(MedioPago.class, id);
                medioPago.getCodMedioPago();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The medioPago with id " + id + " no longer exists.", enfe);
            }
            em.remove(medioPago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MedioPago> findMedioPagoEntities() {
        return findMedioPagoEntities(true, -1, -1);
    }

    public List<MedioPago> findMedioPagoEntities(int maxResults, int firstResult) {
        return findMedioPagoEntities(false, maxResults, firstResult);
    }

    private List<MedioPago> findMedioPagoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MedioPago.class));
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

    public MedioPago findMedioPago(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MedioPago.class, id);
        } finally {
            em.close();
        }
    }

    public int getMedioPagoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MedioPago> rt = cq.from(MedioPago.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
