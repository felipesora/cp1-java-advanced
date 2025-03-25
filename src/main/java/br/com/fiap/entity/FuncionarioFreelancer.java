package br.com.fiap.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Freelancer")
public class FuncionarioFreelancer extends Funcionario {
    private double taxaServico = 50.0;

    public FuncionarioFreelancer() {
    }

    public FuncionarioFreelancer(String nome, double horasTrabalhadas, double valorHora) {
        super(nome, horasTrabalhadas, valorHora);
    }

    @Override
    public double calcularSalario() {
        return (horasTrabalhadas * valorHora) + taxaServico;
    }

    @Override
    public void imprimirInformacao() {
        System.out.println("======================================");
        System.out.println("Funcionário Freelancer");
        System.out.println("Nome: " + nome);
        System.out.println("Horas Trabalhadas: " + horasTrabalhadas);
        System.out.println("Valor por Hora: R$ " + valorHora);
        System.out.println("Taxa de Serviço: R$ " + taxaServico);
        System.out.println("Salário Final: R$ " + calcularSalario());
        System.out.println("======================================");
    }
}

