package br.com.fiap.entity;

public class FuncionarioEstagiario extends Funcionario {
    private double descontoBolsa = 0.1;

    public FuncionarioEstagiario(String nome, double horasTrabalhadas, double valorHora) {
        super(nome, horasTrabalhadas, valorHora);
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() * (1 - descontoBolsa);
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Desconto de Bolsa: 10%");
        System.out.println("Salário Final: R$ " + calcularSalario());
    }
}

