package entidades;

import entidades.conta.Conta;
import entidades.conta.ContaCorrentePF;
import entidades.conta.ContaCorrentePJ;
import entidades.conta.ContaInvestimentoPF;
import entidades.conta.ContaInvestimentoPJ;
import entidades.conta.ContaPoupanca;
import entidades.conta.TipoDeConta;
import entidades.pessoa.Cliente;
import entidades.pessoa.PessoaFisica;
import entidades.pessoa.PessoaJuridica;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Banco {

    private Set<Cliente> clientes;
    private Set<Conta> contas;
    private Map<Integer, Conta> mapaContas;

    public Banco() {
        this.clientes = new HashSet<>();
        this.contas = new HashSet<>();
        this.mapaContas = new HashMap<>();
    }

    private Conta abrirContaPessoaJuridica(PessoaJuridica pessoa, TipoDeConta tipoDeConta) {
        var numeroConta = getNumeroConta();
        Conta contaNova = null;
        switch (tipoDeConta) {
            case CORRENTE:
                contaNova = new ContaCorrentePJ(pessoa, numeroConta);
                break;
            case INVESTIMENTO:
                contaNova = new ContaInvestimentoPJ(pessoa, numeroConta);
                break;
        }
        mapaContas.put(numeroConta, contaNova);
        return contaNova;
    }

    private Conta abrirContaPessoaFisica(PessoaFisica pessoa, TipoDeConta tipoDeConta) {
        var numeroConta = getNumeroConta();
        Conta contaNova = null;
        switch (tipoDeConta) {
            case CORRENTE:
                contaNova = new ContaCorrentePF(pessoa, numeroConta);
                break;
            case POUPANCA:
                contaNova = new ContaPoupanca(pessoa, numeroConta);
                break;
            case INVESTIMENTO:
                contaNova = new ContaInvestimentoPF(pessoa, numeroConta);
                break;
        }
        mapaContas.put(numeroConta, contaNova);
        return contaNova;
    }

    private int getNumeroConta() {
        return contas.size() + 1;
    }


    public Conta abrirContaPessoaFisica(String nome, String cpf, TipoDeConta tipoDeConta) {
        PessoaFisica cliente = new PessoaFisica(nome, cpf);
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
        return abrirContaPessoaFisica(cliente, tipoDeConta);
    }

    public Conta abrirContaPessoaJuridica(String razaoSocial, String cnpj, TipoDeConta tipoDeConta) {
        PessoaJuridica cliente = new PessoaJuridica(razaoSocial, cnpj);
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
        return abrirContaPessoaJuridica(cliente, tipoDeConta);
    }

    public void debitar(Conta conta, double valor) {
        conta.debitar(valor);
    }

    public Conta getConta(int numeroConta) {
        return mapaContas.get(numeroConta);
    }

    public void creditar(Conta conta, double valor) {
        conta.creditar(valor);
    }

    public void transferir(Conta contaOrigem, Conta contaDestino, double valor) {
        contaOrigem.transferir(contaDestino, valor);
    }
}
