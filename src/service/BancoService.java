package service;

import entidades.cliente.Cliente;
import entidades.conta.Conta;
import entidades.conta.TipoDeConta;
import entidades.pessoa.Pessoa;
import entidades.pessoa.PessoaFisica;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class BancoService {

    final Set<Cliente> clientesDoBanco = new HashSet<>();

    final Map<Conta, Cliente> mapaContasCadastradas = new HashMap<>();
    final Map<Pessoa, Cliente> mapaPessoasCadastradas = new HashMap<>();

    private int numeroConta = 1;

    private String gerarNumeroConta() {
        return Integer.toString(numeroConta++);
    }

    public Cliente abrirContaPF(final String nome, final String cpf) {

        final Pessoa pessoa = new PessoaFisica(nome, cpf);

        if(!ehCliente(pessoa)) {
            return cadastrarNovoCliente(pessoa);
        } else {
            return getInformacaoDeCliente(pessoa);
        }

    }

    private Cliente getInformacaoDeCliente(Pessoa pessoa) {
        return mapaPessoasCadastradas.get(pessoa);
    }

    private boolean ehCliente(Pessoa pessoa) {
        return mapaPessoasCadastradas.containsKey(pessoa);
    }

    private Cliente cadastrarNovoCliente(Pessoa pessoa) {
        final Conta corrente = new Conta(pessoa, gerarNumeroConta(), TipoDeConta.CORRENTE);
        final Conta poupanca = new Conta(pessoa, gerarNumeroConta(),TipoDeConta.POUPANCA);
        final Conta investimento = new Conta(pessoa, gerarNumeroConta(),TipoDeConta.INVESTIMENTO);

        final Cliente cliente = new Cliente(pessoa, List.of(corrente, poupanca, investimento));

        clientesDoBanco.add(cliente);

        mapaContasCadastradas.put(corrente, cliente);
        mapaContasCadastradas.put(poupanca, cliente);
        mapaContasCadastradas.put(investimento, cliente);

        mapaPessoasCadastradas.put(pessoa, cliente);

        return cliente;
    }

//    public Conta abrirContaPJ(final String razaoSocial, final String cnpj) {
//
//    }


    public static void main(String[] args) {

//        Map<Conta, Cliente> mapaContasCadastradas = new HashMap<>();
//
//        Pessoa pessoaA = new PessoaFisica("Joao", "1");
//        Conta contaA = new Conta(pessoaA, "1", TipoDeConta.POUPANCA);
//        Cliente clienteA = new Cliente(pessoaA, List.of(contaA));
//        mapaContasCadastradas.put(contaA, clienteA);
//
//        Pessoa pessoaB = new PessoaFisica("Maria", "2");
//        Conta contaB = new Conta(pessoaB, "2", TipoDeConta.CORRENTE);
//        Cliente clienteB = new Cliente(pessoaB, List.of(contaB));
//        mapaContasCadastradas.put(contaB, clienteB);
//
//
//        Pessoa pessoaC = new PessoaFisica("Jose", "3");
//        Conta contaC = new Conta(pessoaC, "3", TipoDeConta.INVESTIMENTO);
//        Cliente clienteC = new Cliente(pessoaC, List.of(contaC));
//        mapaContasCadastradas.put(contaC, clienteC);
//
//        Set<Cliente> clientesDoBanco = Set.of(clienteA, clienteB, clienteC);
//
//        System.out.println(clientesDoBanco);

        Map<Integer, String> pessoaMap = new HashMap<>();
        pessoaMap.put(33, "Flavia");
        pessoaMap.put(7, "Patricia");
        pessoaMap.put(10, "Joao");
        pessoaMap.put(10, "Janaina");

//        System.out.println(pessoaMap.get(7));
//        System.out.println(pessoaMap.get(10));

        System.out.println(pessoaMap.keySet());
        System.out.println(pessoaMap.values());
        System.out.println(pessoaMap.containsKey(66));
        System.out.println(pessoaMap.containsValue("Flavia"));


    }



}
