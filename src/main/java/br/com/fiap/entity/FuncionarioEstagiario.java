package br.com.fiap.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Estagiario")
public class FuncionarioEstagiario extends Funcionario {
    private double descontoBolsa = 0.1;

    public FuncionarioEstagiario() {
    }

    public FuncionarioEstagiario(String nome, double horasTrabalhadas, double valorHora) {
        super(nome, horasTrabalhadas, valorHora);
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() * (1 - descontoBolsa);
    }

    @Override
    public void imprimirInformacao() {
        System.out.println("======================================");
        System.out.println("Funcionario Estágiário");
        super.imprimirInformacao();
        System.out.println("Desconto de Bolsa: 10%");
        System.out.println("Salário Final: R$ " + calcularSalario());
        System.out.println("======================================");
    }
}

