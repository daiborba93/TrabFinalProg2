
package controller;

import dao.DAOEquipamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.Equipamento;
import view.FCadEquipamento;
import view.FPesqEquipamento;
import model.ModelEquipamento;

public class ControlEquipamento {

    private FCadEquipamento fCadEquipamento;
    private FPesqEquipamento fPesqEquipamento;
    private DAOEquipamento DAOEquipamento;
    private ModelEquipamento modelEquipamento;
    private Equipamento equipamento;

    public ControlEquipamento() {
        this.fCadEquipamento = new FCadEquipamento(null, true);
        this.fPesqEquipamento = new FPesqEquipamento(null, true);
        this.DAOEquipamento = new DAOEquipamento();
        this.modelEquipamento = new ModelEquipamento();
        this.equipamento = null;
        inicializaComponentes();
    }

    private void inicializaComponentes() {
        fPesqEquipamento.tbEquipamentos.setModel(modelEquipamento);

        fCadEquipamento.btGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravar();
            }
        });

        fCadEquipamento.btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });

        fCadEquipamento.btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });

        fPesqEquipamento.btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarEquipamento();
            }
        });

        fPesqEquipamento.btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });
    }

    private void gravar() {
        Equipamento equipamento = new Equipamento();
        equipamento.setNomeEquipamento(fCadEquipamento.edNomeEquipamento.getText());

        if (this.equipamento == null) {

            if (DAOEquipamento.salvar(equipamento)) {
                JOptionPane.showMessageDialog(fCadEquipamento, "Equipamento inserido com sucesso");
                limpar();
            }
        } else {
            equipamento.setCodigo(Integer.parseInt(fCadEquipamento.edCodigo.getText()));

            if (DAOEquipamento.atualizar(equipamento)) {
                JOptionPane.showMessageDialog(fCadEquipamento, "Equipamento editado com sucesso");
                limpar();
                fCadEquipamento.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(fCadEquipamento, "Erro ao editar equipamento");
            }

            fCadEquipamento.edCodigo.setEditable(true);
            fCadEquipamento.btLimpar.setEnabled(true);
        }
    }

    private void editarEquipamento() {
        int posicao = fPesqEquipamento.tbEquipamentos.getSelectedRow();
        if (posicao >= 0) {
            equipamento = modelEquipamento.getEquipamento(posicao);
            fCadEquipamento.edCodigo.setText(Integer.toString(equipamento.getCodigo()));
            fCadEquipamento.edNomeEquipamento.setText(equipamento.getNomeEquipamento());

            fCadEquipamento.edCodigo.setEditable(false);
            fCadEquipamento.btLimpar.setEnabled(false);

            fCadEquipamento.setVisible(true);

            carregarEquipamentoModel();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um equipamento");
        }
    }

    private void excluir() {
        int posicao = fPesqEquipamento.tbEquipamentos.getSelectedRow();

        if (posicao >= 0) {
            equipamento = modelEquipamento.getEquipamento(posicao);

            if (DAOEquipamento.excluir(equipamento)) {
                JOptionPane.showMessageDialog(null, "Equipamento removido com sucesso");
                modelEquipamento.removeEquipamento(posicao);
                limpar();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao remover equipamento. O Equipamento pode estarassociado a um pedido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um equipamento");
        }
    }

    private void cancelar() {
        limpar();

        fCadEquipamento.edCodigo.setEditable(true);
        fCadEquipamento.btLimpar.setEnabled(true);
        
        fCadEquipamento.setVisible(false);
    }

    private void limpar() {
        fCadEquipamento.edCodigo.setText(null);
        fCadEquipamento.edNomeEquipamento.setText(null);
        equipamento = null;
    }

    private void carregarEquipamentoModel() {
        modelEquipamento.limpar();
        List<Equipamento> equipamentos = DAOEquipamento.listar();
        for (Equipamento e : equipamentos) {
            modelEquipamento.addEquipamento(e);
        }
    }

    public void cadastrarEquipamento() {
        limpar();
        fCadEquipamento.setVisible(true);
    }

    public void pesquisarEquipamento() {
        carregarEquipamentoModel();
        fPesqEquipamento.setVisible(true);
    }
}

