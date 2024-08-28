package ifba.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class Crianca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String genero;
	private String cpf;
	private int sus;
	private int certidaoNascimento;
	private int nis;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	@ManyToOne
	private Responsavel responsavel;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Saude saudeCrianca;

	@ManyToAny
	private List<ResponsavelRetirada> responsavelRetirada;
	
	public Crianca() {
		super();
	}

	public Crianca(String nome, String genero, String cpf, int sus, int certidaoNascimento, int nis,
			Date dataNascimento, Responsavel responsavel, Saude saudeCrianca,
			List<ResponsavelRetirada> responsavelRetirada) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.cpf = cpf;
		this.sus = sus;
		this.certidaoNascimento = certidaoNascimento;
		this.nis = nis;
		this.dataNascimento = dataNascimento;
		this.responsavel = responsavel;
		this.saudeCrianca = saudeCrianca;
		this.responsavelRetirada = responsavelRetirada;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getSus() {
		return sus;
	}

	public void setSus(int sus) {
		this.sus = sus;
	}

	public int getCertidaoNascimento() {
		return certidaoNascimento;
	}

	public void setCertidaoNascimento(int certidaoNascimento) {
		this.certidaoNascimento = certidaoNascimento;
	}

	public int getNis() {
		return nis;
	}

	public void setNis(int nis) {
		this.nis = nis;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public Saude getSaudeCrianca() {
		return saudeCrianca;
	}

	public void setSaudeCrianca(Saude saudeCrianca) {
		this.saudeCrianca = saudeCrianca;
	}

	public List<ResponsavelRetirada> getResponsavelRetirada() {
		return responsavelRetirada;
	}

	public void setResponsavelRetirada(List<ResponsavelRetirada> responsavelRetirada) {
		this.responsavelRetirada = responsavelRetirada;
	}
	public void addResponsavelRetirada(ResponsavelRetirada responsavelRetirada) {
		this.responsavelRetirada.add(responsavelRetirada);
	}

}
