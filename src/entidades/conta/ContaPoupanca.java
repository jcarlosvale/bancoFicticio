package entidades.conta;

import entidades.pessoa.PessoaFisica;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(PessoaFisica titular, int numeroConta) {
        super(titular, numeroConta);
    }

    public void render(double taxaRendimento) {
        //TODO: validar rendimento positivo
        this.creditar(this.saldo() * taxaRendimento);
    }
}
