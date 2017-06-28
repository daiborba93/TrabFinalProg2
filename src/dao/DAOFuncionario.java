
package dao;

import static dao.DAO.getEntityManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Funcionario;

public class DAOFuncionario extends DAO {

    public static List<Funcionario> listar() {
        EntityManager em = getEntityManager();

        Query query = em.createQuery("Select f from Funcionario f");

        List<Funcionario> funcionarios = query.getResultList();

        return funcionarios;
    }
}
