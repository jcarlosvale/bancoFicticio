package entidades.conta;

import entidades.pessoa.Cliente;
import entidades.pessoa.PessoaJuridica;

public class ContaCorrentePJ extends Conta {

    private static final double TAXA_SAQUE = 0.005;

    public ContaCorrentePJ(PessoaJuridica titular, int numeroConta) {
        super(titular, numeroConta, TipoDeConta.CORRENTE);
    }

    public ContaCorrentePJ(Cliente titular, int numeroConta, TipoDeConta tipoDeConta) {
        super(titular, numeroConta, tipoDeConta);
    }

    @Override
    public void debitar(double valor) {
        valor += TAXA_SAQUE * valor;
        super.debitar(valor);
    }

    @Override
    public void transferir(Conta conta, double valor) {
        //TODO: verificar valor eh positivo
        //TODO: retirar a taxa, mas TRANSFERIR valor original
        //TODO: validar se tem saldo
        valor -= TAXA_SAQUE * valor;
        super.transferir(conta, valor);
    }
}
