package main;

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

    private String nome;

    private Set<Cliente> clientes;
    private Set<Conta> contas;
    private Map<Integer, Conta> mapaContas;

    public Banco(String nome) {
        this.nome = nome;
        this.clientes = new HashSet<>();
        this.contas = new HashSet<>();
        this.mapaContas = new HashMap<>();
    }

    public void cadastrarPessoaFisica(String nome, String cpf) {
        var pessoaFisica = new PessoaFisica(nome, cpf);
        this.clientes.add(pessoaFisica);
    }

    public void cadastrarPessoaJuridica(String razaoSocial, String cnpj) {
        var pessoaJuridica = new PessoaJuridica(razaoSocial, cnpj);
        this.clientes.add(pessoaJuridica);
    }

    public Conta abrirConta(Cliente cliente, TipoDeConta tipoDeConta) {
        //TODO: se quiser, nao permitir o mesmo cliente ter mais de 1 conta do mesmo tipo
        if (clientes.contains(cliente)) {
            Conta contaNova;
            if (cliente instanceof PessoaFisica) {
                contaNova = abrirContaPessoaFisica((PessoaFisica) cliente, tipoDeConta);
            } else {
                contaNova = abrirContaPessoaJuridica((PessoaJuridica) cliente, tipoDeConta);
            }
            contas.add(contaNova);
            mapaContas.put(contaNova.getNumeroConta(), contaNova);
            return contaNova;
        } else {
            throw new RuntimeException("Nao é possível abrir a conta: cliente nao cadastrada - " + cliente);
        }
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


    public String getNome() {
        return nome;
    }

    public double getSaldo(int numeroConta) {

        var conta = mapaContas.get(numeroConta);
        return conta.saldo();
    }

    public void creditar(int numeroConta, double valor) {
        var conta = mapaContas.get(numeroConta);
        conta.creditar(valor);
    }

    public void debitar(int numeroConta, double valor) {
        var conta = mapaContas.get(numeroConta);
        conta.debitar(valor);
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
        contaOrigem.debitar(valor);
        contaDestino.creditar(valor);
    }
}
