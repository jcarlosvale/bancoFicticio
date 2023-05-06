package entidades.conta;

import entidades.pessoa.PessoaFisica;

public class ContaInvestimentoPF extends ContaPoupanca {

    public ContaInvestimentoPF(PessoaFisica titular, int numeroConta) {
        super(titular, numeroConta, TipoDeConta.INVESTIMENTO);
    }
}
