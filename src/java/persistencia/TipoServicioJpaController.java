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
import logica.TipoServicio;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

public class TipoServicioJpaController implements Serializable {

    public TipoServicioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public TipoServicioJpaController(){
        emf = Persistence.createEntityManagerFactory("EntregaPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoServicio tipoServicio) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoServicio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoServicio(tipoServicio.getCodTipoServicio()) != null) {
                throw new PreexistingEntityException("TipoServicio " + tipoServicio + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoServicio tipoServicio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoServicio = em.merge(tipoServicio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipoServicio.getCodTipoServicio();
                if (findTipoServicio(id) == null) {
                    throw new NonexistentEntityException("The tipoServicio with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoServicio tipoServicio;
            try {
                tipoServicio = em.getReference(TipoServicio.class, id);
                tipoServicio.getCodTipoServicio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoServicio with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoServicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoServicio> findTipoServicioEntities() {
        return findTipoServicioEntities(true, -1, -1);
    }

    public List<TipoServicio> findTipoServicioEntities(int maxResults, int firstResult) {
        return findTipoServicioEntities(false, maxResults, firstResult);
    }

    private List<TipoServicio> findTipoServicioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoServicio.class));
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

    public TipoServicio findTipoServicio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoServicio.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoServicioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoServicio> rt = cq.from(TipoServicio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
