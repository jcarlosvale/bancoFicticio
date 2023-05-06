package entidades.conta;

import entidades.pessoa.Cliente;
import entidades.pessoa.PessoaFisica;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(PessoaFisica titular, int numeroConta) {
        super(titular, numeroConta, TipoDeConta.POUPANCA);
    }

    public ContaPoupanca(Cliente titular, int numeroConta, TipoDeConta tipoDeConta) {
        super(titular, numeroConta, tipoDeConta);
    }

    public void render(double taxaRendimento) {
        //TODO: validar rendimento positivo
        this.creditar(this.saldo() * taxaRendimento);
    }
}
