
package dao;

import static dao.DAO.getEntityManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Pedido;

public class DAOPedido extends DAO {

    public static List<Pedido> listar() {
        EntityManager em = getEntityManager();

        Query query = em.createQuery("Select p from Pedido p");

        List<Pedido> funcionarios = query.getResultList();

        return funcionarios;
    }
}
