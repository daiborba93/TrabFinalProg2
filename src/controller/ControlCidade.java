
package controller;

import dao.DAOCidade;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cidade;
import view.FCadCidade;
import view.FPesqCidade;
import model.ModelCidade;

public class ControlCidade {
    private FCadCidade fCadCidade;
    private FPesqCidade fPesqCidade;
    private DAOCidade DAOCidade;
    private ModelCidade modelCidade;
    private Cidade cidade;

    public ControlCidade() {
        this.fCadCidade = new FCadCidade(null, true);
        this.fPesqCidade = new FPesqCidade(null, true);
        this.DAOCidade = new DAOCidade();
        this.modelCidade = new ModelCidade();
        this.cidade = null;
        inicializaComponentes();
    }

    private void inicializaComponentes() {
        fPesqCidade.tbCidade.setModel(modelCidade);

        fCadCidade.btGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravar();
            }
        });

        fCadCidade.btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });

        fCadCidade.btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });

        fPesqCidade.btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarCidade();
            }
        });

        fPesqCidade.btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });
    }

    private void gravar() {
        Cidade cidade = new Cidade();
        cidade.setNomeCidade(fCadCidade.edNome.getText());

        if (this.cidade == null) {

            if (DAOCidade.salvar(cidade)) {
                JOptionPane.showMessageDialog(fCadCidade, "Cidade inserida com sucesso");
                limpar();
            } else {
                JOptionPane.showMessageDialog(fCadCidade, "Erro ao inserir cidade");
            }
        } else {
            cidade.setCodigo(Integer.parseInt(fCadCidade.edCodigo.getText()));

            if (DAOCidade.atualizar(cidade)) {
                JOptionPane.showMessageDialog(fCadCidade, "Cidade editada com sucesso");
                limpar();
                fCadCidade.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(fCadCidade, "Erro ao editar cidade");
            }
            
            fCadCidade.edCodigo.setEditable(true);
            fCadCidade.btLimpar.setEnabled(true);
        }
    }

    private void editarCidade() {
        int posicao = fPesqCidade.tbCidade.getSelectedRow();
        if (posicao >= 0) {
            cidade = modelCidade.getCidade(posicao);

            fCadCidade.edCodigo.setText(Integer.toString(cidade.getCodigo()));
            fCadCidade.edNome.setText(cidade.getNomeCidade());
            fCadCidade.btLimpar.setEnabled(false);

            fCadCidade.edCodigo.setEditable(false);
            fCadCidade.setVisible(true);

            carregarCidadeModel();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma cidade");
        }
    }

    private void excluir() {
        int posicao = fPesqCidade.tbCidade.getSelectedRow();
        if (posicao >= 0) {
            cidade = modelCidade.getCidade(posicao);
            if (DAOCidade.excluir(cidade)) {
                JOptionPane.showMessageDialog(null, "Cidade removida com sucesso");
                modelCidade.removeCidade(posicao);
                limpar();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao remover cidade. Cidade pode estar associada a um pedido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma cidade");
        }
    }

    private void cancelar() {
        limpar();
        fCadCidade.edCodigo.setEditable(true);
        fCadCidade.btLimpar.setEnabled(true);
        fCadCidade.setVisible(false);
    }

    private void limpar() {
        fCadCidade.edCodigo.setText(null);
        fCadCidade.edNome.setText(null);
        cidade = null;
    }

    private void carregarCidadeModel() {
        modelCidade.limpar();
        List<Cidade> cidades = DAOCidade.listar();
        for (Cidade cidade : cidades) {
            modelCidade.addCidade(cidade);
        }
    }

    public void cadastrarCidade() {
        limpar();
        fCadCidade.setVisible(true);
    }

    public void pesquisarCidade() {
        carregarCidadeModel();
        fPesqCidade.setVisible(true);
    }
}
