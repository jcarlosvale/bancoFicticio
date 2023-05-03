package main;

import entidades.conta.TipoDeConta;
import entidades.pessoa.Pessoa;
import entidades.pessoa.PessoaFisica;
import entidades.pessoa.PessoaJuridica;

public class InternetBanking {

    public static void main(String[] args) {
        Banco banco = new Banco("Santander");

        //TODO fazer menu


        //1 - cadastrar cliente
        Pessoa joao = new PessoaFisica("Joao", "333");
        Pessoa ivan = new PessoaJuridica("Ivan", "123");

        banco.cadastrarPessoaJuridica("Ivan", "123");
        banco.abrirConta(ivan, TipoDeConta.INVESTIMENTO);

        //System.out.println(banco.getSaldo(1));
        banco.creditar(1, 100.00);
        banco.creditar(1, 200.00);
        banco.creditar(1, 300.00);
        System.out.println("ANTES" + banco.getSaldo(1));
        banco.debitar(1, 50);
        System.out.println("DEPOIS" + banco.getSaldo(1));

    }

}
