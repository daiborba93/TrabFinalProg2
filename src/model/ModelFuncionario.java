package model;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import model.Funcionario;


public class ModelFuncionario extends AbstractTableModel {

    private ArrayList<Funcionario> pedidos = new ArrayList<Funcionario>();

    @Override
    public int getRowCount() {
        return pedidos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario funcionario = pedidos.get(rowIndex);
        switch (columnIndex) {
            case 0: {
                return funcionario.getCpf();
            }

            default: {
                return funcionario.getNomeFuncionario();
            }

        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: {
                return "CPF";
            }
            case 1: {
                return "Nome da Funcionario";
            }

        }
        return null;
    }

    public void limpar() {
        pedidos.clear();
    }

    public void removeFuncionario(int posicao) {
        pedidos.remove(posicao);
        fireTableRowsDeleted(posicao, posicao);
    }

    public Funcionario getFuncionario(int posicao) {
        return pedidos.get(posicao);
    }

    public void addFuncionario(Funcionario funcionario) {
        pedidos.add(funcionario);
        fireTableRowsInserted(pedidos.size() - 1, pedidos.size() - 1);
    }

}
