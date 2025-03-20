package br.com.fiap.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Noturno")
public class FuncionarioNoturno extends Funcionario {

    private static final double ADICIONAL_NOTURNO = 0.2;

    public FuncionarioNoturno() {
    }

    public FuncionarioNoturno(String nome, double horasTrabalhadas, double valorHora) {
        super(nome, horasTrabalhadas, valorHora);
    }

    @Override
    public double calcularSalario() {
        double adicional = horasTrabalhadas * valorHora * ADICIONAL_NOTURNO;
        return super.calcularSalario() + adicional;
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Adicional Noturno: R$ " + (horasTrabalhadas * valorHora * ADICIONAL_NOTURNO));
        System.out.println("Salário Final com Adicional: R$ " + calcularSalario());
    }
}
