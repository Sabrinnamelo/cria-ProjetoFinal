package ifba.model;

import java.util.Date;
import java.util.List;

public class Creche {

	private int id;
	private String nome;
	private String codigoInep;
	private String email;
	private String registro;
	private Date dataFundacao;
	private String telefone;
	private String cnpj;
	private Endereco enderecoCreche;
	private List<Matricula> matricula;
	
	public Creche() {
		super();
	}

	public Creche(String nome, String codigoInep, String email, String registro, Date dataFundacao, String telefone,
			String cnpj, Endereco enderecoCreche, List<Matricula> matricula) {
		super();
		this.nome = nome;
		this.codigoInep = codigoInep;
		this.email = email;
		this.registro = registro;
		this.dataFundacao = dataFundacao;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.enderecoCreche = enderecoCreche;
		this.matricula = matricula;
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

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
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

	public Endereco getEnderecoCreche() {
		return enderecoCreche;
	}

	public void setEnderecoCreche(Endereco enderecoCreche) {
		this.enderecoCreche = enderecoCreche;
	}

	public List<Matricula> getMatricula() {
		return matricula;
	}

	public void setMatricula(List<Matricula> matricula) {
		this.matricula = matricula;
	}
	
	
	
}
