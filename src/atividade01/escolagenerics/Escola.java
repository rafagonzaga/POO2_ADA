package atividade01.escolagenerics;

import java.util.Collections;

public class Escola {

    public static void main(String[] args) {

        /*
        Turma turma945 = new Turma();

        Professor professor = new Professor("Kadu");

        Aluno rafael = new Aluno("Rafael");
        Aluno helcius = new Aluno("Helcius");
        Aluno bruna = new Aluno("Bruna");

        turma945.adicionarProfessor(professor);
        turma945.adicionarAluno(rafael);
        turma945.adicionarAluno(helcius);
        turma945.adicionarAluno(bruna);

        System.out.println(turma945);
        */
        Turma<AlunoJava> turmaAlunosJava = new Turma<>();
        Professor professorJava = new Professor("Prof Java");
        AlunoJava joao = new AlunoJava("João");
        AlunoJava victor = new AlunoJava("Victor");
        AlunoJava luana = new AlunoJava("Luana");
        turmaAlunosJava.adicionarProfessor(professorJava);
        turmaAlunosJava.adicionarAluno(joao);
        turmaAlunosJava.adicionarAluno(victor);
        turmaAlunosJava.adicionarAluno(luana);
        System.out.println(turmaAlunosJava);
        Collections.sort(turmaAlunosJava.listaDeAlunos);
        System.out.println("Após a ordenação:");
        System.out.println(turmaAlunosJava);
        System.out.println();


        Turma<Aluno> turmaAlunosJS = new Turma<>();
        Professor professorJS = new Professor("Prof JS");
        AlunoJS gabriel = new AlunoJS("Gabriel");
        AlunoJS pedro = new AlunoJS("Pedro");
        AlunoJS eduardo = new AlunoJS("Eduardo");
        turmaAlunosJS.adicionarProfessor(professorJS);
        turmaAlunosJS.adicionarAluno(gabriel);
        turmaAlunosJS.adicionarAluno(pedro);
        turmaAlunosJS.adicionarAluno(eduardo);
        System.out.println(turmaAlunosJS);
        Collections.sort(turmaAlunosJS.listaDeAlunos);
        System.out.println("Após a ordenação:");
        System.out.println(turmaAlunosJS);

    }


}
