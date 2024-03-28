package ifba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Turma {

	@Id
	@GeneratedValue
	private int id;
	
	private String horario;
	private String turno;
	private String sala;
	
	public Turma() {
		super();
	}

	public Turma(String horario, String turno, String sala) {
		super();
		this.horario = horario;
		this.turno = turno;
		this.sala = sala;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
	
	
}
