package domain;

import java.util.Set;

public class Aluno {
	public Aluno(String nome2) {
		// TODO Auto-generated constructor stub
	}
	Set<Disciplina> disciplinas;
	String nome;
	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
