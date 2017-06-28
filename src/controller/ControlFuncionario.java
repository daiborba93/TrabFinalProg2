
package controller;

import dao.DAOFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.Funcionario;
import view.FCadFuncionario;
import view.FPesqFuncionario;
import model.ModelFuncionario;

public class ControlFuncionario {
    private FCadFuncionario fCadFuncionario;
    private FPesqFuncionario fPesqFuncionario;
    private DAOFuncionario DAOFuncionario;
    private ModelFuncionario modelFuncionario;
    private Funcionario funcionario;

    public ControlFuncionario() {
        this.fCadFuncionario = new FCadFuncionario(null, true);
        this.fPesqFuncionario = new FPesqFuncionario(null, true);
        this.DAOFuncionario = new DAOFuncionario();
        this.modelFuncionario = new ModelFuncionario();
        this.funcionario = null;
        inicializaComponentes();
    }

    private void inicializaComponentes() {
        fPesqFuncionario.tbFuncionario.setModel(modelFuncionario);

        fCadFuncionario.btGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravar();
            }
        });

        fCadFuncionario.btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });

        fCadFuncionario.btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });

        fPesqFuncionario.btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarFuncionario();
            }
        });

        fPesqFuncionario.btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });
    }

    private void gravar() {
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf(fCadFuncionario.edCpf.getText());
        funcionario.setNomeFuncionario(fCadFuncionario.edNome.getText());

        if (this.funcionario == null) {
            if (DAOFuncionario.salvar(funcionario)) {
                JOptionPane.showMessageDialog(fCadFuncionario, "Funcionario inserido com sucesso");
                limpar();
            }
        } else {
            if (DAOFuncionario.atualizar(funcionario)) {
                JOptionPane.showMessageDialog(fCadFuncionario, "Funcionario editada com sucesso");
                limpar();

                fCadFuncionario.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(fCadFuncionario, "Erro ao editar funcionario");
            }

            fCadFuncionario.btLimpar.setEnabled(true);
            fCadFuncionario.edCpf.setEditable(true);
        }
    }

    private void editarFuncionario() {
        int posicao = fPesqFuncionario.tbFuncionario.getSelectedRow();

        if (posicao >= 0) {
            funcionario = modelFuncionario.getFuncionario(posicao);
            fCadFuncionario.edCpf.setText(funcionario.getCpf());
            fCadFuncionario.edNome.setText(funcionario.toString());

            fCadFuncionario.edCpf.setEditable(false);
            fCadFuncionario.btLimpar.setEnabled(false);

            fCadFuncionario.setVisible(true);

            carregarFuncionarioModel();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma funcionário");
        }
    }

    private void excluir() {
        int posicao = fPesqFuncionario.tbFuncionario.getSelectedRow();

        if (posicao >= 0) {
            funcionario = modelFuncionario.getFuncionario(posicao);
            if (DAOFuncionario.excluir(funcionario)) {
                JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso");
                modelFuncionario.removeFuncionario(posicao);
                limpar();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao remover funcionário");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma funcionário");
        }
    }

    private void cancelar() {
        limpar();

        fCadFuncionario.btLimpar.setEnabled(true);
        fCadFuncionario.edCpf.setEditable(true);
        
        fCadFuncionario.setVisible(false);
    }

    private void limpar() {
        fCadFuncionario.edCpf.setText(null);
        fCadFuncionario.edNome.setText(null);
        funcionario = null;
    }

    private void carregarFuncionarioModel() {
        modelFuncionario.limpar();
        List<Funcionario> funcionario = DAOFuncionario.listar();
        for (Funcionario e : funcionario) {
            modelFuncionario.addFuncionario(e);
        }
    }

    public void cadastrarFuncionario() {
        limpar();
        fCadFuncionario.setVisible(true);
    }

    public void pesquisarFuncionario() {
        carregarFuncionarioModel();
        fPesqFuncionario.setVisible(true);
    }
}