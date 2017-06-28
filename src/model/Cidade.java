
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {

    @Id
    @GeneratedValue
    private int codigo;

    @Column(name = "nome_cidade")
    private String nomeCidade;

    public Cidade(int codigo, String nomeCidade){
        this.codigo = codigo;
        this.nomeCidade = nomeCidade;
    }

    public Cidade() {
    }


    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    @Override
    public String toString() {
        return getNomeCidade();
    }
}
