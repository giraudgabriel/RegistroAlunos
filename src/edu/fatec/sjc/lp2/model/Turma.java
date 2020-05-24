package edu.fatec.sjc.lp2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Turma {
	private Aluno[] alunos;
	private Integer indice = 0;
	private Integer qtdAlunos;

	public Turma(Integer qtdAlunos) {
		setAlunos(new Aluno[qtdAlunos]);
		setQtdAlunos(qtdAlunos);
	}

	public Aluno consultarAlunoPorMatricula(Integer matricula) {
		for (int i = 0; i < (getIndice()); i++) {
			Aluno alunoConsultado = alunos[i];
			if (alunoConsultado.getMatricula().equals(matricula)) {
				return alunoConsultado;
			}
		}
		return null;
	}

	public Aluno consultarAlunoPorNome(String nome) {
		for (int i = 0; i < (getIndice()); i++) {
			Aluno alunoConsultado = alunos[i];
			if (alunoConsultado.getNome().equals(nome)) {
				return alunoConsultado;
			}
		}
		return null;
	}

	public Boolean incluirAluno(Aluno aluno) {
		if (getAlunoIndice(aluno.getMatricula()).equals(-1) && getQtdAlunos() > getIndice()) {
			getAlunos()[getIndice()] = aluno;
			setIndice(getIndice() + 1);
			return true;
		}
		return false;
	}

	public Integer getAlunoIndice(Integer matricula) {
		for (int i = 0; i < (getIndice()); i++) {
			if (matricula.equals(getAlunos()[i].getMatricula()))
				return i;
		}
		return -1;
	}

	public Integer getAlunoIndice(String nome) {
		for (int i = 0; i < getIndice(); i++) {
			if (nome.equals(getAlunos()[i].getNome()))
				return i;
		}
		return -1;
	}

	public Boolean alterarAluno(Aluno aluno) {
		Integer i = getAlunoIndice(aluno.getMatricula());
		if (i == -1)
			return false;
		else {
			alunos[i] = aluno;
			return true;
		}
	}

	public Boolean excluirAluno(String nome) {
		Integer indiceAluno = getAlunoIndice(nome);
		if (indiceAluno != -1) {
			for (int i = indiceAluno; i < (getIndice()); i++) {
				alunos[i] = alunos[i + 1];
			}
			setIndice(getIndice() - 1);
			return true;
		} else {
			return false;
		}
	}
	
	public void imprimirAlunos() {
		for (int i = 0; i < (getIndice()); i++) {
			Aluno aluno = getAlunos()[i];
			System.out.println((i+1)+"-"+aluno.getNome());
		}
	}
}
