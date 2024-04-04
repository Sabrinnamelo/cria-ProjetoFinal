package ifba.model;

import java.util.Date;
import jakarta.persistence.Entity;

@Entity
public class Professora extends Pessoa {

    private String especializacao;
    private String cargaHoraria;

    public Professora() {
        super();
    }

    public Professora(String nome, String cpf, Date dataNascimento, String email, String telefone, String rg,
            Endereco endereco, String especializacao, String cargaHoraria) {
        super(nome, cpf, dataNascimento, email, telefone, rg, endereco);
        this.especializacao = especializacao;
        this.cargaHoraria = cargaHoraria;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
