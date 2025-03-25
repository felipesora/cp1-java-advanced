package br.com.fiap.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Senior")
public class FuncionarioSenior extends Funcionario {
    private double bonusPor15Horas = 100.0;

    public FuncionarioSenior() {
    }

    public FuncionarioSenior(String nome, double horasTrabalhadas, double valorHora) {
        super(nome, horasTrabalhadas, valorHora);
    }

    @Override
    public double calcularSalario() {
        double bonus = (int)(horasTrabalhadas / 15) * bonusPor15Horas;
        return super.calcularSalario() + bonus;
    }

    @Override
    public void imprimirInformacao() {
        System.out.println("======================================");
        System.out.println("Funcionário Sênior");
        super.imprimirInformacao();
        System.out.println("Bônus recebido: R$ " + ((int)(horasTrabalhadas / 15) * bonusPor15Horas));
        System.out.println("Salário Final com Bônus: R$ " + calcularSalario());
        System.out.println("======================================");
    }
}

