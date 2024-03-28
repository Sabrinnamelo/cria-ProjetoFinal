package ifba.model;

public class Matricula {

	private int id;
	private String status;
	private String alergia;
	private String laudo;
	private Crianca crianca;
	private Professora professora;
	private Turma turma;
	
	public Matricula() {
		super();
	}

	public Matricula(String status, String alergia, String laudo, Crianca crianca, Professora professora, Turma turma) {
		super();
		this.status = status;
		this.alergia = alergia;
		this.laudo = laudo;
		this.crianca = crianca;
		this.professora = professora;
		this.turma = turma;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public String getLaudo() {
		return laudo;
	}

	public void setLaudo(String laudo) {
		this.laudo = laudo;
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
	
	
}
