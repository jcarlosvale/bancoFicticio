package main;

import entidades.conta.Conta;
import entidades.conta.ContaCorrentePF;
import entidades.conta.ContaCorrentePJ;
import entidades.conta.ContaInvestimentoPF;
import entidades.conta.ContaInvestimentoPJ;
import entidades.conta.ContaPoupanca;
import entidades.conta.TipoDeConta;
import entidades.pessoa.Pessoa;
import entidades.pessoa.PessoaFisica;
import entidades.pessoa.PessoaJuridica;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Banco {

    private String nome;

    private Set<Pessoa> clientes;
    private Set<Conta> contas;
    private Map<Integer, Conta> mapaContas;

    public Banco(String nome) {
        this.nome = nome;
        this.clientes = new HashSet<>();
        this.contas = new HashSet<>();
        this.mapaContas = new HashMap<>();
    }

    public Pessoa cadastrarPessoaFisica(String nome, String cpf) {
        var pessoaFisica = new PessoaFisica(nome, cpf);
        this.clientes.add(pessoaFisica);
        return pessoaFisica;
    }

    public Pessoa cadastrarPessoaJuridica(String razaoSocial, String cnpj) {
        var pessoaJuridica = new PessoaJuridica(razaoSocial, cnpj);
        this.clientes.add(pessoaJuridica);
        return pessoaJuridica;
    }

    public Conta abrirConta(Pessoa pessoa, TipoDeConta tipoDeConta) {
        //TODO: se quiser, nao permitir o mesmo cliente ter mais de 1 conta do mesmo tipo
        if (clientes.contains(pessoa)) {
            Conta contaNova;
            if (pessoa instanceof PessoaFisica) {
                contaNova = abrirContaPessoaFisica((PessoaFisica) pessoa, tipoDeConta);
            } else {
                contaNova = abrirContaJuridica((PessoaJuridica) pessoa, tipoDeConta);
            }
            contas.add(contaNova);
            mapaContas.put(contaNova.getNumeroConta(), contaNova);
            return contaNova;
        } else {
            throw new RuntimeException("Nao é possível abrir a conta: pessoa nao cadastrada - " + pessoa);
        }
    }

    private Conta abrirContaJuridica(PessoaJuridica pessoa, TipoDeConta tipoDeConta) {
        var numeroConta = getNumeroConta();
        switch (tipoDeConta) {
            case CORRENTE: return new ContaCorrentePJ(pessoa, numeroConta);
            case INVESTIMENTO: return new ContaInvestimentoPJ(pessoa, numeroConta);
            default: throw new RuntimeException("Pessoa Juridica nao pode abrir conta: " + tipoDeConta);
        }
    }

    private Conta abrirContaPessoaFisica(PessoaFisica pessoa, TipoDeConta tipoDeConta) {
        var numeroConta = getNumeroConta();
        switch (tipoDeConta) {
            case CORRENTE: return new ContaCorrentePF(pessoa, numeroConta);
            case POUPANCA: return new ContaPoupanca(pessoa, numeroConta);
            case INVESTIMENTO: return new ContaInvestimentoPF(pessoa, numeroConta);
            default: throw new RuntimeException("Pessoa Fisica nao pode abrir conta: " + tipoDeConta);
        }
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
}
