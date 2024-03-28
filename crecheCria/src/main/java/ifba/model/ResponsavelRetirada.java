package ifba.model;

import java.util.Date;

public class ResponsavelRetirada extends Pessoa{

	private String validadeAutorizacao;
	private String status;
	private String prioridade;
	private String observacoes;
	
	public ResponsavelRetirada() {
		super();
	}

	public ResponsavelRetirada(String nome, String cpf, Date dataNascimento, String email, String telefone, String rg,
			Endereco endereco, String validadeAutorizacao, String status, String prioridade, String observacoes) {
		super(nome, cpf, dataNascimento, email, telefone, rg, endereco);
		this.validadeAutorizacao = validadeAutorizacao;
		this.status = status;
		this.prioridade = prioridade;
		this.observacoes = observacoes;
	}

	public String getValidadeAutorizacao() {
		return validadeAutorizacao;
	}

	public void setValidadeAutorizacao(String validadeAutorizacao) {
		this.validadeAutorizacao = validadeAutorizacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	
	
}
