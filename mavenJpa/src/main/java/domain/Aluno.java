package domain;

import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Aluno {
	
	@OneToMany
	@JoinColumn
	private Set<Disciplina> listaDeDisciplinas;

	
	String nome;
	
	public Aluno(String nome2) {
		// TODO Auto-generated constructor stub
	}
	
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
