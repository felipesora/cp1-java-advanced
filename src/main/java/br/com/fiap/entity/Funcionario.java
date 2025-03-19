package br.com.fiap.entity;

public class Funcionario implements FuncionarioInterface{
    protected String nome;

    public Funcionario(String nome, double horasTrabalhadas, double valorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    protected double horasTrabalhadas;
    protected double valorHora;

    @Override
    public double calcularSalario() {
        return horasTrabalhadas * valorHora;
    }

    @Override
    public void imprimirInformacao() {
        System.out.println("Horas trabalhadas: "+ horasTrabalhadas
                +"\nSalário do funcionário por hora: "+ valorHora +"\nSalário do Funcionário: "+ calcularSalario());
    }
}
