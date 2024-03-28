package ifba.model;

import java.util.Date;

public class Responsavel extends Pessoa {

	private String profissao;
	private String estadoCivil;
	
	public Responsavel() {
		super();
	}

	public Responsavel(String nome, String cpf, Date dataNascimento, String email, String telefone, String rg,
			Endereco endereco, String profissao, String estadoCivil) {
		super(nome, cpf, dataNascimento, email, telefone, rg, endereco);
		this.profissao = profissao;
		this.estadoCivil = estadoCivil;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	
	
}
