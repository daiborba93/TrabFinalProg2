
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FPrincipal;

public class ControlPrincipal {

    private FPrincipal fPrincipal;
    private ControlPedido controlPedido;
    private ControlEquipamento controlEquipamento;
    private ControlCidade controlCidade;
    private ControlFuncionario controlFuncionario;

    public ControlPrincipal() {
        fPrincipal = new FPrincipal();
        controlPedido = new ControlPedido();
        controlEquipamento = new ControlEquipamento();
        controlCidade = new ControlCidade();
        controlFuncionario = new ControlFuncionario();
        inicializaComponentes();
    }

    private void inicializaComponentes() {
        fPrincipal.mCadastroPedido.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarPedido();
            }
        });

        fPrincipal.mPesquisarPedido.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisarPedido();
            }
        });

        fPrincipal.mCadastroEquipamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarEquipamento();
            }
        });

        fPrincipal.mPesquisarEquipamento.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisarEquipamento();
            }
        });

        fPrincipal.mCadastroCidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCidade();
            }
        });

        fPrincipal.mPesquisarCidade.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisarCidade();
            }
        });

        fPrincipal.mCadastroFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarFuncionario();
            }
        });

        fPrincipal.mPesquisarFuncionario.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisarFuncionario();
            }
        });


    }

    private void cadastrarPedido() {
        controlPedido.cadastrarPedido();
    }

    private void pesquisarPedido() {
        controlPedido.pesquisarPedido();
    }

    private void cadastrarEquipamento() {
        controlEquipamento.cadastrarEquipamento();
    }

     private void pesquisarEquipamento(){
        controlEquipamento.pesquisarEquipamento();
    }

    private void cadastrarCidade() {
        controlCidade.cadastrarCidade();
    }

     private void pesquisarCidade(){
        controlCidade.pesquisarCidade();
    }

    private void cadastrarFuncionario() {
        controlFuncionario.cadastrarFuncionario();
    }

     private void pesquisarFuncionario(){
        controlFuncionario.pesquisarFuncionario();
    }

    public void executar() {
        fPrincipal.setVisible(true);
    }
}


