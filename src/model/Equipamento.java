
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipamento")
public class Equipamento implements Serializable {

    @Id
    @GeneratedValue
    private int codigo;

    @Column (name = "nome_equipamento")
    private String nomeEquipamento;

    public Equipamento(int codigo, String nomeEquipamento){
        this.codigo = codigo;
        this.nomeEquipamento=nomeEquipamento;
    }

    public Equipamento() {
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    @Override
    public String toString() {
        return getNomeEquipamento();
    }
}