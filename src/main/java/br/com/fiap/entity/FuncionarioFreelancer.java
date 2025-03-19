package br.com.fiap.entity;

public class FuncionarioFreelancer implements FuncionarioInterface {
    private String nome;
    private double horasTrabalhadas;
    private double valorHora;
    private double taxaServico = 50.0;

    public FuncionarioFreelancer(String nome, double horasTrabalhadas, double valorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        return (horasTrabalhadas * valorHora) + taxaServico;
    }

    @Override
    public void imprimirInformacao() {
        System.out.println("Funcionário Freelancer: " + nome);
        System.out.println("Horas Trabalhadas: " + horasTrabalhadas);
        System.out.println("Valor por Hora: R$ " + valorHora);
        System.out.println("Taxa de Serviço: R$ " + taxaServico);
        System.out.println("Salário Final: R$ " + calcularSalario());
    }
}

