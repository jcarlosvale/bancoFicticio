package service;

import entidades.cliente.Cliente;
import entidades.conta.Conta;
import entidades.conta.TipoDeConta;
import entidades.pessoa.Pessoa;
import entidades.pessoa.PessoaFisica;
import entidades.pessoa.PessoaJuridica;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BancoService {

    final Set<Cliente> clientesDoBanco = new HashSet<>();

    final Map<Conta, Cliente> mapaContasCadastradas = new HashMap<>();
    final Map<Pessoa, Cliente> mapaPessoasCadastradas = new HashMap<>();

    private int numeroConta = 1;

    public Cliente abrirContaPF(final String nome, final String cpf) {

        final Pessoa pessoa = new PessoaFisica(nome, cpf);

        return abrirConta(pessoa);
    }

    public Cliente abrirContaPJ(final String razaoSocial, final String cnpj) {
        final Pessoa pessoa = new PessoaJuridica(razaoSocial, cnpj);

        return abrirConta(pessoa);
    }


    public void creditar(final Integer numeroConta, final BigDecimal valor) {

        if (numeroConta == null) {

        }

        if (valor == null) {

        }

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {

        }

    }




    private Cliente abrirConta(final Pessoa pessoa) {
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

    private Cliente cadastrarNovoCliente(final Pessoa pessoa) {

        final List<Conta> listaDeContas = new ArrayList<>();

        final Conta corrente = new Conta(pessoa, gerarNumeroConta(), TipoDeConta.CORRENTE);
        listaDeContas.add(corrente);

        final Conta investimento = new Conta(pessoa, gerarNumeroConta(),TipoDeConta.INVESTIMENTO);
        listaDeContas.add(investimento);

        if (pessoa instanceof PessoaFisica) {
            final Conta poupanca = new Conta(pessoa, gerarNumeroConta(),TipoDeConta.POUPANCA);
            listaDeContas.add(poupanca);
        }

        final Cliente cliente = new Cliente(pessoa, listaDeContas);
        clientesDoBanco.add(cliente);

        mapaPessoasCadastradas.put(pessoa, cliente);

        for(Conta conta : listaDeContas) {
            mapaContasCadastradas.put(conta, cliente);
        }

        return cliente;
    }

    private String gerarNumeroConta() {
        return Integer.toString(numeroConta++);
    }






    public static void main(String[] args) {
        //Wrapper Classes
        /*
        boolean <--> Boolean

        char <--> Character(*)

        byte <--> Byte
        short <--> Short
        int <--> Integer(*)
        long <--> Long

        float <--> Float
        double <--> Double
         */
        //Collection --> só armazena objetos!!! List, Map, Set




        // NPE = null pointer exception

        // TRY -> tente
        // CATCH -> capture
        // FINALLY -> finalmente
        // THROW(S) -> lançar


        String nome = null;

        try {

            System.out.println("BLOCO PROTEGIDO");
            System.out.println(nome.toUpperCase());
            System.out.println("FIM BLOCO PROTEGIDO");
        } catch (Exception e) {

            System.out.println("BLOCO DE ERRO");

        } finally {

            System.out.println("BLOCO FINALLY");

        }

        System.out.println("FIM DE PROGRAMA");

    }

}
