package br.com.fiap.view;

import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.dao.FuncionarioDaoImpl;
import br.com.fiap.entity.*;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNaoEncontradoException;
import br.com.fiap.service.FuncionarioService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao;

        Scanner scanner = new Scanner(System.in);

        // Criando a fábrica
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        // Criando o Entity Manager
        EntityManager em = fabrica.createEntityManager();
        // Instanciando o DAO
        FuncionarioDAO dao = new FuncionarioDaoImpl(em);

        // Instanciando o FuncionarioService
        FuncionarioService service = new FuncionarioService(dao, scanner);

        while (true) {
            System.out.println("============================");
            System.out.println("|  CRUD de Funcionários    |");
            System.out.println("============================");
            System.out.println("1. Selecionar um Funcionário");
            System.out.println("2. Cadastrar um Funcionário");
            System.out.println("3. Alterar um Funcionário");
            System.out.println("4. Remover um Funcionário");
            System.out.println("5. Sair");
            System.out.println("============================");
            System.out.print("Selecione uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 1) {
                    service.listarFuncionario();

                } else if (opcao == 2) {
                    service.cadastrarFuncionario();

                } else if (opcao == 3) {
                    service.atualizarFuncionario();

                } else if (opcao == 4) {
                    service.removerFuncionario();

                } else if (opcao == 5) {
                    System.out.println("Saindo...");
                    break;
                } else {
                    System.out.println("Opção Inválida! Tente Novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: Entrada inválida! Digite um número.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
