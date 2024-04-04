package ifba.model;

import java.util.Date;

import jakarta.persistence.Entity;
@Entity
public class ResponsavelRetirada extends Pessoa{

	private Date validadeAutorizacao;
	private boolean status;
	private String observacoes;
	
	public ResponsavelRetirada() {
		super();
	}

	public ResponsavelRetirada(String nome, String cpf, Date dataNascimento, String email, String telefone, String rg,
			Endereco endereco, Date validadeAutorizacao, boolean status, String observacoes) {
		super(nome, cpf, dataNascimento, email, telefone, rg, endereco);
		this.validadeAutorizacao = validadeAutorizacao;
		this.status = status;
		this.observacoes = observacoes;
	}

	public Date getValidadeAutorizacao() {
		return validadeAutorizacao;
	}

	public void setValidadeAutorizacao(Date validadeAutorizacao) {
		this.validadeAutorizacao = validadeAutorizacao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}
