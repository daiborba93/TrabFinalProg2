/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import dao.DAOCidade;
import dao.DAOEquipamento;
import dao.DAOFuncionario;
import dao.DAOPedido;
import java.util.List;
import model.Cidade;
import model.Equipamento;
import model.Funcionario;
import model.Pedido;
import view.FCadPedido;
import view.FPesqPedido;
import model.ModelPedido;


public class ControlPedido {

    private FCadPedido fCadPedido;
    private FPesqPedido fPesqPedido;
    private DAOPedido DAOPedido;
    private DAOEquipamento DAOEquipamento;
    private DAOCidade DAOCidade;
    private DAOFuncionario DAOFuncionario;
    private ModelPedido modelPedido;
    private Pedido pedido;
    private List<Equipamento> equipamentos = new ArrayList<>();
    private List<Cidade> cidades = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();

    public ControlPedido() {
        fCadPedido = new FCadPedido(null, true);
        fPesqPedido = new FPesqPedido(null, true);
        DAOPedido = new DAOPedido();
        DAOEquipamento = new DAOEquipamento();
        DAOCidade = new DAOCidade();
        DAOFuncionario = new DAOFuncionario();
        modelPedido = new ModelPedido();
        pedido = null;
        inicializaComponentes();
    }

    private void inicializaComponentes() {
        fPesqPedido.tbPedido.setModel(modelPedido);
        carregarEquipamento();
        carregarCidade();

        fCadPedido.btGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravar();
            }
        });

        fCadPedido.btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });

        fCadPedido.btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });

        fPesqPedido.btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarPedido();
            }
        });

        fPesqPedido.btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });
    }

    private void gravar() {
        Pedido pedido = new Pedido();
        pedido.setNomeCliente(fCadPedido.edNome.getText());
        pedido.setCpf(fCadPedido.edCpf.getText());
        pedido.setRua(fCadPedido.edRua.getText());
        pedido.setNumero(Integer.parseInt(fCadPedido.edNumero.getText()));
        pedido.setDescricao(fCadPedido.edDescricao.getText());
        pedido.setEquipamento((Equipamento) fCadPedido.cbEquipamento.getSelectedItem());
        pedido.setCidade((Cidade) fCadPedido.cbCidade.getSelectedItem());
        pedido.setFuncionario((Funcionario) fCadPedido.cbFuncionario.getSelectedItem());

        if (this.pedido == null)  {
            if (DAOPedido.salvar(pedido)) {
                JOptionPane.showMessageDialog(fCadPedido, "Pedido inserido com sucesso");
                limpar();
            }
        } else {
            pedido.setCodigo(Integer.parseInt(fCadPedido.edCodigo.getText()));

            if (DAOPedido.atualizar(pedido)) {
                JOptionPane.showMessageDialog(fCadPedido, "Pedido editado com sucesso");
                limpar();

                fCadPedido.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(fCadPedido, "Erro ao editar pedido");
            }

            fCadPedido.edCodigo.setEditable(true);
            fCadPedido.btLimpar.setEnabled(true);
        }
    }

    private void editarPedido() {
        int posicao = fPesqPedido.tbPedido.getSelectedRow();
        if (posicao >= 0) {
            pedido = modelPedido.getPedido(posicao);
            fCadPedido.edCodigo.setText(Integer.toString(pedido.getCodigo()));
            fCadPedido.edNome.setText(pedido.getNomeCliente());
            fCadPedido.edCpf.setText((pedido.getCpf()));
            fCadPedido.cbCidade.setSelectedItem(pedido.getCidade());
            fCadPedido.edRua.setText(pedido.getRua());
            fCadPedido.edNumero.setText(Integer.toString(pedido.getNumero()));
            fCadPedido.cbEquipamento.setSelectedItem(pedido.getEquipamento());
            fCadPedido.cbCidade.setSelectedItem(pedido.getCidade());
            fCadPedido.cbFuncionario.setSelectedItem(pedido.getFuncionario());
            fCadPedido.edDescricao.setText(pedido.getDescricao());

            fCadPedido.edCodigo.setEditable(false);
            fCadPedido.btLimpar.setEnabled(false);

            fCadPedido.setVisible(true);

            carregarPedidoModel();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Pedido");
        }
    }

    private void excluir() {
        int posicao = fPesqPedido.tbPedido.getSelectedRow();
        if (posicao >= 0) {
            pedido = modelPedido.getPedido(posicao);
            if (DAOPedido.excluir(pedido)) {
                JOptionPane.showMessageDialog(null, "Pedido removido com sucesso");
                modelPedido.removePedido(posicao);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao remover Pedido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Pedido");
        }
    }

    private void cancelar() {
        limpar();

        fCadPedido.edCodigo.setEditable(true);
        fCadPedido.btLimpar.setEnabled(true);

        fCadPedido.setVisible(false);
    }

        private void limpar() {
            fCadPedido.edCodigo.setText(null);
            fCadPedido.edNome.setText(null);
            fCadPedido.edCpf.setText(null);
            fCadPedido.edNumero.setText(null);
            fCadPedido.edRua.setText(null);
            fCadPedido.cbEquipamento.setSelectedItem(0);
            fCadPedido.cbCidade.setSelectedItem(0);
            fCadPedido.cbFuncionario.setSelectedItem(0);
            fCadPedido.edDescricao.setText(null);
            pedido = null;
    }

    private void carregarPedidoModel() {
        modelPedido.limpar();
        List<Pedido> pedidos = DAOPedido.listar();
        for (Pedido p : pedidos) {
            modelPedido.addPedido(p);
        }
    }

    private void carregarEquipamento() {
        fCadPedido.cbEquipamento.removeAllItems();

        equipamentos = DAOEquipamento.listar();
        for (Equipamento euipamento : equipamentos) {
            fCadPedido.cbEquipamento.addItem(euipamento);
        }
    }

    private void carregarCidade() {
        fCadPedido.cbCidade.removeAllItems();

        cidades = DAOCidade.listar();
        for (Cidade cidade : cidades) {
            fCadPedido.cbCidade.addItem(cidade);
        }
    }
    
    private void carregarFuncionario() {
        fCadPedido.cbFuncionario.removeAllItems();

        funcionarios = DAOFuncionario.listar();
        for (Funcionario funcionario : funcionarios) {
            fCadPedido.cbFuncionario.addItem(funcionario);
        }
    }

    public void cadastrarPedido() {
        limpar();
        carregarEquipamento();
        carregarCidade();
        carregarFuncionario();
        
        boolean visible = true;
        
        if(equipamentos.size() == 0){
            visible = false;
            JOptionPane.showMessageDialog(fCadPedido, "Sem equipamento cadastrado");
        }
        
        if(cidades.size() == 0){
            visible = false;
            JOptionPane.showMessageDialog(fCadPedido, "Sem cidade cadastrada");
        }
        
        if(funcionarios.size() == 0){
            visible = false;
            JOptionPane.showMessageDialog(fCadPedido, "Sem funcionário cadastrado");
        }
        
        fCadPedido.setVisible(visible);
    }

    public void pesquisarPedido() {
        carregarPedidoModel();
        fPesqPedido.setVisible(true);
    }
}
