
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Pedido;

public class ModelPedido extends AbstractTableModel {

    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    @Override
    public int getRowCount() {
        return pedidos.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido pedido = pedidos.get(rowIndex);
        switch (columnIndex) {
            case 0: {
                return pedido.getCodigo();
            }
            case 1: {
                return pedido.getNomeCliente();
            }
            case 2: {
                return pedido.getCpf();
            }
            case 3: {
                return pedido.getRua();
            }
            case 4: {
                return pedido.getNumero();
            }
            case 5: {
                return pedido.getCidade();
            }
            case 6: {
                return pedido.getEquipamento();   
            }
            case 7: {
                return pedido.getDescricao();
            }
            case 8: {
                return pedido.getFuncionario();
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        switch (column) {
               case 0: {
                   return "ID";
               }
               case 1: {
                   return "Nome";
               }
               case 2: {
                   return "CPF";
               }
               case 3: {
                   return "Rua";
               }
               case 4: {
                   return "Númeo";
               }
                case 5: {
                   return "Cidade";
               }
               case 6: {
                   return "Equipamento";
               }
               case 7: {
                   return "Descricao";
               }
               case 8: {
                   return "Funcionário";
               }

           }
        return null;
    }

    public void limpar() {
        pedidos.clear();
    }

    public void removePedido(int posicao) {
        pedidos.remove(posicao);
        fireTableRowsDeleted(posicao, posicao);
    }

    public Pedido getPedido(int posicao) {
        return pedidos.get(posicao);
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
        fireTableRowsInserted(pedidos.size() - 1, pedidos.size() - 1);
    }
}