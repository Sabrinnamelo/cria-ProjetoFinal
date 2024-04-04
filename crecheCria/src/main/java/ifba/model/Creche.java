package ifba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Creche {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String codigoInep;
	private String email;
	private String senha;
	private String telefone;
	private String cnpj;
	
	
	public Creche() {
		super();
	}


	public Creche(String nome, String codigoInep, String email, String senha, String telefone, String cnpj) {
		super();
		this.nome = nome;
		this.codigoInep = codigoInep;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.cnpj = cnpj;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCodigoInep() {
		return codigoInep;
	}


	public void setCodigoInep(String codigoInep) {
		this.codigoInep = codigoInep;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
