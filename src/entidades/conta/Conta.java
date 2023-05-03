package entidades.conta;

import entidades.pessoa.Pessoa;

import java.time.LocalDate;

public abstract class Conta {

    private Pessoa titular;
    private double saldo;
    private int numeroConta;
    private LocalDate dataAbertura;

    public Conta(Pessoa titular, int numeroConta) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.dataAbertura = LocalDate.now();
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

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public int getNumeroConta() {
        return numeroConta;
    }
}
