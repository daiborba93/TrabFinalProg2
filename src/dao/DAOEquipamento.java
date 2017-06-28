
package dao;

import static dao.DAO.getEntityManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Equipamento;

public class DAOEquipamento extends DAO {

    public static List<Equipamento> listar() {
        EntityManager em = getEntityManager();

        Query query = em.createQuery("Select e from Equipamento e");

        List<Equipamento> equipamentos = query.getResultList();

        return equipamentos;
    }
}
