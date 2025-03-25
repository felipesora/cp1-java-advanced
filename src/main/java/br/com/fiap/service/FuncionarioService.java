package br.com.fiap.service;

import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.entity.*;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNaoEncontradoException;

import java.util.Scanner;

public class FuncionarioService {

    private FuncionarioDAO dao;
    private Scanner scanner;

    public FuncionarioService(FuncionarioDAO dao, Scanner scanner) {
        this.dao = dao;
        this.scanner = scanner;
    }

    public void cadastrarFuncionario() {
        int opcao;
        String nome;
        double horasTrabalhadas, valorHora;
        FuncionarioEstagiario estagiario;
        FuncionarioFreelancer freelancer;
        FuncionarioSenior senior;
        FuncionarioNoturno noturno;

        System.out.println("==============================");
        System.out.println("|   Cadastro de Funcionário  |");
        System.out.println("==============================");
        System.out.println("1. Funcionário Estágiario");
        System.out.println("2. Funcionário Freelancer");
        System.out.println("3. Funcionário Senior");
        System.out.println("4. Funcionário Noturno");
        System.out.println("==============================");
        System.out.println("Que tipo de funcionário deseja cadastrar?");
        try {
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1){
                System.out.println("Digite o nome do funcionário: ");
                nome = scanner.nextLine();
                System.out.println("Digite a carga horária do funcionário: ");
                String horasTrabalhadasStr = scanner.nextLine().replace(",", ".");
                horasTrabalhadas = Double.parseDouble(horasTrabalhadasStr);
                System.out.println("Digite o valor hora do funcionário: ");
                String valorHoraStr = scanner.nextLine().replace(",", ".");
                valorHora = Double.parseDouble(valorHoraStr);

                estagiario = new FuncionarioEstagiario(nome,horasTrabalhadas,valorHora);

                System.out.println("Cadastrando funcionário...");
                try {
                    dao.cadastrar(estagiario);
                    dao.commit();
                    System.out.println("Funcionário Cadastrado!");
                } catch (CommitException e) {
                    System.out.println("Erro ao cadastrar: " + e.getMessage());
                }

            } else if (opcao == 2){
                System.out.println("Digite o nome do funcionário: ");
                nome = scanner.nextLine();
                System.out.println("Digite a carga horária do funcionário: ");
                String horasTrabalhadasStr = scanner.nextLine().replace(",", ".");
                horasTrabalhadas = Double.parseDouble(horasTrabalhadasStr);
                System.out.println("Digite o valor hora do funcionário: ");
                String valorHoraStr = scanner.nextLine().replace(",", ".");
                valorHora = Double.parseDouble(valorHoraStr);

                freelancer = new FuncionarioFreelancer(nome,horasTrabalhadas,valorHora);

                System.out.println("Cadastrando funcionário...");
                try {
                    dao.cadastrar(freelancer);
                    dao.commit();
                    System.out.println("Funcionário Cadastrado!");
                } catch (CommitException e) {
                    System.out.println("Erro ao cadastrar: " + e.getMessage());
                }

            } else if (opcao == 3) {
                System.out.println("Digite o nome do funcionário: ");
                nome = scanner.nextLine();
                System.out.println("Digite a carga horária do funcionário: ");
                String horasTrabalhadasStr = scanner.nextLine().replace(",", ".");
                horasTrabalhadas = Double.parseDouble(horasTrabalhadasStr);
                System.out.println("Digite o valor hora do funcionário: ");
                String valorHoraStr = scanner.nextLine().replace(",", ".");
                valorHora = Double.parseDouble(valorHoraStr);

                senior = new FuncionarioSenior(nome,horasTrabalhadas,valorHora);

                System.out.println("Cadastrando funcionário...");
                try {
                    dao.cadastrar(senior);
                    dao.commit();
                    System.out.println("Funcionário Cadastrado!");
                } catch (CommitException e) {
                    System.out.println("Erro ao cadastrar: " + e.getMessage());
                }
            } else if (opcao == 4) {
                System.out.println("Digite o nome do funcionário: ");
                nome = scanner.nextLine();
                System.out.println("Digite a carga horária do funcionário: ");
                String horasTrabalhadasStr = scanner.nextLine().replace(",", ".");
                horasTrabalhadas = Double.parseDouble(horasTrabalhadasStr);
                System.out.println("Digite o valor hora do funcionário: ");
                String valorHoraStr = scanner.nextLine().replace(",", ".");
                valorHora = Double.parseDouble(valorHoraStr);

                noturno = new FuncionarioNoturno(nome,horasTrabalhadas,valorHora);

                System.out.println("Cadastrando funcionário...");
                try {
                    dao.cadastrar(noturno);
                    dao.commit();
                    System.out.println("Funcionário Cadastrado!");
                } catch (CommitException e) {
                    System.out.println("Erro ao cadastrar: " + e.getMessage());
                }
            } else {
                System.out.println("Opção Inválida! Tente Novamente.");
            }

        } catch (Exception e) {
            System.out.println("Erro: Entrada inválida! Digite um número.");
            scanner.nextLine();
        }

    }

    public void listarFuncionario() {
        int id;

        System.out.println("==============================");
        System.out.println("|   Exibição de Funcionário  |");
        System.out.println("==============================");
        System.out.println("Digite o id do funcionário: ");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Buscando funcionário...");

        try {
            Funcionario busca = dao.buscarPorId(id);
            System.out.println();
            busca.imprimirInformacao();

        } catch (IdNaoEncontradoException e) {
            System.out.println("Erro ao buscar funcionário: " + e.getMessage());
        }
    }

    public void atualizarFuncionario() {
        int id, opcao;
        String nome;
        double horasTrabalhadas, valorHora;
        Funcionario funcionario;

        System.out.println("=====================================");
        System.out.println("|   Alteração de dados Funcionário  |");
        System.out.println("=====================================");
        System.out.println("Digite o ID do funcionário: ");
        id = scanner.nextInt();
        scanner.nextLine();


        try {

            funcionario = dao.buscarPorId(id);

            if (funcionario == null) {
                System.out.println("Funcionário não encontrado.");
                return;
            }

            System.out.println("=====================================");
            System.out.println("1. Nome");
            System.out.println("2. Carga Horária");
            System.out.println("3. Valor Hora");
            System.out.println("4. Todas as opções anteriores");
            System.out.println("=====================================");
            System.out.println("Escolha uma opção para alterar: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("Digite o novo NOME: ");
                nome = scanner.nextLine();
                funcionario.setNome(nome);

                System.out.println("Editando nome do funcionário...");
                try {
                    dao.atualizar(funcionario);
                    dao.commit();
                    System.out.println("Nome do funcionário atualizado!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcao == 2) {
                System.out.println("Digite a nova carga horária: ");
                horasTrabalhadas = scanner.nextDouble();
                funcionario.setHorasTrabalhadas(horasTrabalhadas);

                System.out.println("Editando carga horária do funcionário...");
                try {
                    dao.atualizar(funcionario);
                    dao.commit();
                    System.out.println("Carga horária do funcionário atualizada!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcao == 3) {
                System.out.println("Digite o novo valor por hora: ");
                valorHora = scanner.nextDouble();
                funcionario.setValorHora(valorHora);

                System.out.println("Editando valor hora do funcionário...");
                try {
                    dao.atualizar(funcionario);
                    dao.commit();
                    System.out.println("Valor hora do funcionário atualizado!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcao == 4) {
                System.out.println("Digite o novo NOME: ");
                nome = scanner.nextLine();
                funcionario.setNome(nome);

                System.out.println("Digite a nova carga horária: ");
                horasTrabalhadas = scanner.nextDouble();
                funcionario.setHorasTrabalhadas(horasTrabalhadas);

                System.out.println("Digite o novo valor por hora: ");
                valorHora = scanner.nextDouble();
                funcionario.setValorHora(valorHora);

                System.out.println("Editando todos os dados do funcionário...");
                try {
                    dao.atualizar(funcionario);
                    dao.commit();
                    System.out.println("Todos os dados do funcionário foram atualizados!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Opção inválida.");
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar funcionário: " + e.getMessage());
        }
    }

    public void removerFuncionario() {
        int id;
        Funcionario funcionario;

        System.out.println("=============================");
        System.out.println("|   Remoção de Funcionário  |");
        System.out.println("=============================");
        System.out.println("Digite o ID do funcionário: ");
        id = scanner.nextInt();
        scanner.nextLine();

        try {
            funcionario = dao.buscarPorId(id);

            if (funcionario == null) {
                System.out.println("Funcionário não encontrado.");
                return;
            }

            System.out.println("ID: " + funcionario.getId() + " | Nome: " + funcionario.getNome());
            System.out.println("Tem certeza que deseja remover esse Funcionário? (SIM/NÃO)");
            String opcaoRemocao = scanner.nextLine();

            if (opcaoRemocao.equalsIgnoreCase("SIM")) {
                System.out.println("Removendo Funcionário...");
                dao.remover(id);
                dao.commit();
                System.out.println("Funcionário removido com sucesso!");
            } else {
                System.out.println("Remoção cancelada.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar remover o funcionário: " + e.getMessage());
        }
    }
}
