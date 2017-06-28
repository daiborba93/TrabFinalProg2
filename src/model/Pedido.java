
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue
    private int codigo;

    @Column(name = "nome_cliente")
    private String nomeCliente;

    @Column
    private String cpf;

    @Column
    private String rua;

    @Column
    private int numero;

    @ManyToOne()
    private Cidade cidade;

    @ManyToOne
    private Equipamento equipamento;

    @ManyToOne
    private Funcionario funcionario;

    @Column
    private String descricao;


    public Pedido(int codigo, String nomeCliente, String cpf, String rua, int numero, Cidade cidade, Equipamento equipamento, Funcionario funcionario, String descricao) {
        this.codigo = codigo;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.equipamento = equipamento;
        this.funcionario = funcionario;
        this.descricao = descricao;

    }

    public Pedido() {
    }



    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public void setNomeCliente(String nome) {
        this.nomeCliente = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cidade getCidade() {
        return this.cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Equipamento getEquipamento() {
        return this.equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return getDescricao();
    }
}
