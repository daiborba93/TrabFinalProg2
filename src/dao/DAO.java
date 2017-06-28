
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {

    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaChamadoJPAPU");
            entityManager = emf.createEntityManager();
        }

        return entityManager;
    }

    public static boolean salvar(Object obj) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

            return false;
        }
    }

    public static boolean atualizar(Object obj) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

            return false;
        }
    }

    public static boolean excluir(Object obj) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

            return false;
        }
    }

    public static void closeEntityManager() {
        getEntityManager().close();
    }
}
