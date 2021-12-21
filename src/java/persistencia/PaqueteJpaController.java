package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Servicio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Paquete;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

public class PaqueteJpaController implements Serializable {

    public PaqueteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public PaqueteJpaController(){
        emf = Persistence.createEntityManagerFactory("EntregaPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paquete paquete) throws PreexistingEntityException, Exception {
        if (paquete.getListaServiciosIncluidos() == null) {
            paquete.setListaServiciosIncluidos(new ArrayList<Servicio>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Servicio> attachedListaServiciosIncluidos = new ArrayList<Servicio>();
            for (Servicio listaServiciosIncluidosServicioToAttach : paquete.getListaServiciosIncluidos()) {
                listaServiciosIncluidosServicioToAttach = em.getReference(listaServiciosIncluidosServicioToAttach.getClass(), listaServiciosIncluidosServicioToAttach.getCodigoServicio());
                attachedListaServiciosIncluidos.add(listaServiciosIncluidosServicioToAttach);
            }
            paquete.setListaServiciosIncluidos(attachedListaServiciosIncluidos);
            em.persist(paquete);
            for (Servicio listaServiciosIncluidosServicio : paquete.getListaServiciosIncluidos()) {
                listaServiciosIncluidosServicio.getListaPaquetes().add(paquete);
                listaServiciosIncluidosServicio = em.merge(listaServiciosIncluidosServicio);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPaquete(paquete.getCodigoPaquete()) != null) {
                throw new PreexistingEntityException("Paquete " + paquete + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paquete paquete) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paquete persistentPaquete = em.find(Paquete.class, paquete.getCodigoPaquete());
            List<Servicio> listaServiciosIncluidosOld = persistentPaquete.getListaServiciosIncluidos();
            List<Servicio> listaServiciosIncluidosNew = paquete.getListaServiciosIncluidos();
            List<Servicio> attachedListaServiciosIncluidosNew = new ArrayList<Servicio>();
            for (Servicio listaServiciosIncluidosNewServicioToAttach : listaServiciosIncluidosNew) {
                listaServiciosIncluidosNewServicioToAttach = em.getReference(listaServiciosIncluidosNewServicioToAttach.getClass(), listaServiciosIncluidosNewServicioToAttach.getCodigoServicio());
                attachedListaServiciosIncluidosNew.add(listaServiciosIncluidosNewServicioToAttach);
            }
            listaServiciosIncluidosNew = attachedListaServiciosIncluidosNew;
            paquete.setListaServiciosIncluidos(listaServiciosIncluidosNew);
            paquete = em.merge(paquete);
            for (Servicio listaServiciosIncluidosOldServicio : listaServiciosIncluidosOld) {
                if (!listaServiciosIncluidosNew.contains(listaServiciosIncluidosOldServicio)) {
                    listaServiciosIncluidosOldServicio.getListaPaquetes().remove(paquete);
                    listaServiciosIncluidosOldServicio = em.merge(listaServiciosIncluidosOldServicio);
                }
            }
            for (Servicio listaServiciosIncluidosNewServicio : listaServiciosIncluidosNew) {
                if (!listaServiciosIncluidosOld.contains(listaServiciosIncluidosNewServicio)) {
                    listaServiciosIncluidosNewServicio.getListaPaquetes().add(paquete);
                    listaServiciosIncluidosNewServicio = em.merge(listaServiciosIncluidosNewServicio);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = paquete.getCodigoPaquete();
                if (findPaquete(id) == null) {
                    throw new NonexistentEntityException("The paquete with id " + id + " no longer exists.");
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
            Paquete paquete;
            try {
                paquete = em.getReference(Paquete.class, id);
                paquete.getCodigoPaquete();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paquete with id " + id + " no longer exists.", enfe);
            }
            List<Servicio> listaServiciosIncluidos = paquete.getListaServiciosIncluidos();
            for (Servicio listaServiciosIncluidosServicio : listaServiciosIncluidos) {
                listaServiciosIncluidosServicio.getListaPaquetes().remove(paquete);
                listaServiciosIncluidosServicio = em.merge(listaServiciosIncluidosServicio);
            }
            em.remove(paquete);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paquete> findPaqueteEntities() {
        return findPaqueteEntities(true, -1, -1);
    }

    public List<Paquete> findPaqueteEntities(int maxResults, int firstResult) {
        return findPaqueteEntities(false, maxResults, firstResult);
    }

    private List<Paquete> findPaqueteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paquete.class));
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

    public Paquete findPaquete(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paquete.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaqueteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paquete> rt = cq.from(Paquete.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
