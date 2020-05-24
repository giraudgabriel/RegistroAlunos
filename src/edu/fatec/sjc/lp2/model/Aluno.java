package edu.fatec.sjc.lp2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Aluno {
	private Integer matricula;
	private String nome;
	private String curso;
	private Prova[] provas;

	public Aluno(Integer matricula, String nome, String curso) {
		setProvas(new Prova[4]);
		setMatricula(matricula);
		setNome(nome);
		setCurso(curso);
	}
}
