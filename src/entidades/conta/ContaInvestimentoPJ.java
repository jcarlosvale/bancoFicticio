package entidades.conta;

import entidades.pessoa.PessoaJuridica;

public class ContaInvestimentoPJ extends ContaCorrentePJ{

    private static final double TAXA_INVESTIMENTO = 0.02;

    public ContaInvestimentoPJ(PessoaJuridica titular, int numeroConta) {
        super(titular, numeroConta);
    }

    public void creditar(double valor) {
        //TODO validar valor
        valor += valor * TAXA_INVESTIMENTO;
        super.creditar(valor);
    }


}
