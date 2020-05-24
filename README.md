# Registro de Alunos em Java

# JUnit - Turma

```java

public class TestTurma {
	private Turma turma = new Turma(20);

	private Prova prova1 = Prova.builder().nota((double) 10).peso((double) 2.5).build();
	private Prova prova2 = Prova.builder().nota((double) 10).peso((double) 2.5).build();
	private Prova prova3 = Prova.builder().nota((double) 10).peso((double) 2.5).build();
	private Prova prova4 = Prova.builder().nota((double) 10).peso((double) 2.5).build();

	private Aluno aluno = Aluno.builder().curso("Banco de Dados").nome("Gabriel").matricula(123)
			.provas(new Prova[] { prova1, prova2, prova3, prova4 }).build();

	@Test
	public void testQuantidadeAlunos() {
		Assert.assertEquals(20, turma.getQtdAlunos(), 0.01);
	}

	@Test
	public void testAluno() {
		Assert.assertEquals("Banco de Dados", aluno.getCurso());
		Assert.assertEquals("Gabriel", aluno.getNome());
	}

	@Test
	public void testProva() {
		Assert.assertEquals(10, prova1.getNota(), 0.01);
		Assert.assertEquals(2.5, prova1.getPeso(), 0.01);
		prova1.setNota((double)9);
		prova1.setPeso((double)2);
		Assert.assertEquals(9, prova1.getNota(), 0.01);
		Assert.assertEquals(2, prova1.getPeso(), 0.01);
	}

	@Test
	public void testConsultarAlunoPorNome() {
		testInserirAluno();
		Assert.assertEquals(aluno, turma.consultarAlunoPorNome(aluno.getNome()));
		Assert.assertEquals(null, turma.consultarAlunoPorNome(null));
	}

	@Test
	public void testConsultarAlunoPorMatricula() {
		testInserirAluno();
		Assert.assertEquals(aluno, turma.consultarAlunoPorMatricula(aluno.getMatricula()));
		Assert.assertEquals(null, turma.consultarAlunoPorMatricula(null));
	}

	@Test
	public void testInserirAluno() {
		Assert.assertEquals(true, turma.incluirAluno(aluno));
		Assert.assertEquals(false, turma.incluirAluno(aluno));
	}

	@Test
	public void testExcluirAluno() {
		testInserirAluno();
		Assert.assertEquals(true, turma.excluirAluno(aluno.getNome()));
		Assert.assertEquals(false, turma.excluirAluno(aluno.getNome()));
	}

	@Test
	public void testImprimirAlunos() {
		testInserirAluno();
		turma.imprimirAlunos();
	}

	@Test
	public void testAlterarAluno() {
		testInserirAluno();
		Aluno aluno = Aluno.builder().curso("Banco de Dados").nome("Gabriel Fernandes Giraud").matricula(123)
				.provas(new Prova[] { prova1, prova2, prova3, prova4 }).build();

		Aluno aluno2 = new Aluno(1234, "Gabriel Fernandes Giraud", "Banco de Dados");

		Assert.assertEquals(true, turma.alterarAluno(aluno));
		Assert.assertEquals(false, turma.alterarAluno(aluno2));
	}

}
```
