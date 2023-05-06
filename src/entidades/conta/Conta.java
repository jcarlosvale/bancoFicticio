package entidades.conta;

import entidades.pessoa.Cliente;

import java.time.LocalDate;

public abstract class Conta {

    private Cliente titular;
    private double saldo;
    private int numeroConta;
    private LocalDate dataAbertura;

    private TipoDeConta tipoDeConta;

    public Conta(Cliente titular, int numeroConta, TipoDeConta tipoDeConta) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.dataAbertura = LocalDate.now();
        this.tipoDeConta = tipoDeConta;
        this.saldo = 0;
    }


    public void creditar(double valor) {
        // TODO: validar valor positivo
        this.saldo += valor;
    }

    public void debitar(double valor) {
        // TODO: validar valor positivo
        this.saldo -= valor;
    }

    public void transferir(Conta conta, double valor) {
        //TODO: validar valor positivo
        this.debitar(valor);
        conta.creditar(valor);
    }

    public double saldo() {
        return this.saldo;
    }

    @Override
    public String toString() {
        return "Conta: " + numeroConta + " - " + tipoDeConta + "\n" +
                "Titular: " + titular + "\n" +
                "Data de Abertura: " + dataAbertura + "\n" +
                "Saldo: " + saldo;
    }
}
