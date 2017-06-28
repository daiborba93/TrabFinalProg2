
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

    @Id
    private String cpf;

    @Column(name = "nome_funcionario")
    private String nomeFuncionario;

    public Funcionario(String cpf, String nomeFuncionario){
        this.cpf = cpf;
        this.nomeFuncionario=nomeFuncionario;
    }

    public Funcionario() {
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    @Override
    public String toString() {
        return getNomeFuncionario();
    }
}