package ifba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int anoLetivo;
	private String status;
	
	@ManyToOne
	private Crianca crianca;
	
	@ManyToOne
	private Professora professora;
	
	@ManyToOne
	private Turma turma;
	
	@ManyToOne
	private Creche creche;
	
	public Matricula() {
		super();
	}

	public Matricula(int anoLetivo, String status, Crianca crianca, Professora professora, Turma turma, Creche creche) {
		super();
		this.anoLetivo = anoLetivo;
		this.status = status;
		this.crianca = crianca;
		this.professora = professora;
		this.turma = turma;
		this.creche = creche;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(int anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}

	public Professora getProfessora() {
		return professora;
	}

	public void setProfessora(Professora professora) {
		this.professora = professora;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Creche getCreche() {
		return creche;
	}

	public void setCreche(Creche creche) {
		this.creche = creche;
	}
	
	
}
