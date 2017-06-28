
package dao;

import static dao.DAO.getEntityManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Cidade;

public class DAOCidade extends DAO {

    public static List<Cidade> listar() {
        EntityManager em = getEntityManager();

        Query query = em.createQuery("Select c from Cidade c");

        List<Cidade> cidades = query.getResultList();

        return cidades;
    }
}
