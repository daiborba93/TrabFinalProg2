package model;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import model.Cidade;


public class ModelCidade extends AbstractTableModel {

    private ArrayList<Cidade> pedidos = new ArrayList<Cidade>();

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
        Cidade cidade = pedidos.get(rowIndex);
        switch (columnIndex) {
            case 0: {
                return cidade.getCodigo();
            }

            default: {
                return cidade.getNomeCidade();
            }

        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: {
                return "Codigo";
            }
            case 1: {
                return "Nome da Cidade";
            }

        }
        return null;
    }

    public void limpar() {
        pedidos.clear();
    }

    public void removeCidade(int posicao) {
        pedidos.remove(posicao);
        fireTableRowsDeleted(posicao, posicao);
    }

    public Cidade getCidade(int posicao) {
        return pedidos.get(posicao);
    }

    public void addCidade(Cidade cidade) {
        pedidos.add(cidade);
        fireTableRowsInserted(pedidos.size() - 1, pedidos.size() - 1);
    }

}
