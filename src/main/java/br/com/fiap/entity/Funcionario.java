package br.com.fiap.entity;

public class Funcionario implements FuncionarioInterface {
    protected String nome;
    protected double horasTrabalhadas;
    protected double valorHora;

    public Funcionario(String nome, double horasTrabalhadas, double valorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        return horasTrabalhadas * valorHora;
    }

    @Override
    public void imprimirInformacao() {
        System.out.println("Funcionário: " + nome);
        System.out.println("Horas Trabalhadas: " + horasTrabalhadas);
        System.out.println("Valor por Hora: R$ " + valorHora);
        System.out.println("Salário: R$ " + calcularSalario());
    }
}

