package br.com.fiap;

import br.com.fiap.entity.*;

public class Main {
    public static void main(String[] args) {
        FuncionarioInterface func1 = new Funcionario("Augusto", 40, 20);
        FuncionarioInterface func2 = new FuncionarioSenior("Felipe", 45, 30);
        FuncionarioInterface func3 = new FuncionarioFreelancer("Vinicius", 30, 25);
        FuncionarioInterface func4 = new FuncionarioEstagiario("Gustavo", 20, 15);

        System.out.println("\n--- Funcionário Comum ---");
        func1.imprimirInformacao();

        System.out.println("\n--- Funcionário Sênior ---");
        func2.imprimirInformacao();

        System.out.println("\n--- Funcionário Freelancer ---");
        func3.imprimirInformacao();

        System.out.println("\n--- Funcionário Estagiário ---");
        func4.imprimirInformacao();
    }
}
