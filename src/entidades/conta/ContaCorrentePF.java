package entidades.conta;

import entidades.pessoa.PessoaFisica;

public class ContaCorrentePF extends Conta{

    public ContaCorrentePF(PessoaFisica titular, int numeroConta) {
        super(titular, numeroConta);
    }
}
