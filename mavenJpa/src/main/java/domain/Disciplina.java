package domain;

public class Disciplina {
	
	String designacao;
	String sigla;
	int semestre;
	
	public Disciplina(String designacao, String sigla, int semestre) {
		// TODO Auto-generated constructor stub
		this.designacao = designacao;
		this.sigla = sigla;
		this.semestre = semestre;
	}

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getCodigoDeDisciplina() {
		// TODO Auto-generated method stub
		return 0;
	}
}
