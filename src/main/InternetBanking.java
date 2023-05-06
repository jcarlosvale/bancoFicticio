package main;

import entidades.Banco;
import entidades.conta.Conta;
import entidades.conta.TipoDeConta;
import main.util.Operacao;
import main.util.Tela;

import java.util.Scanner;

public class InternetBanking {

    private static Banco banco = new Banco();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Operacao operacao = Operacao.NENHUMA;
        while (operacao != Operacao.SAIR) {
            operacao = Tela.menuPrincipal();
            processarOperacao(operacao);
        }
    }

    private static void processarOperacao(Operacao operacao) {
        switch (operacao) {
            case ABRIR_CONTA_CORRENTE_PESSOA_FISICA:
                abrirContaPessoaFisica(TipoDeConta.CORRENTE);
                break;
            case ABRIR_CONTA_POUPANCA_PESSOA_FISICA:
                abrirContaPessoaFisica(TipoDeConta.POUPANCA);
                break;
            case ABRIR_CONTA_INVESTIMENTO_PESSOA_FISICA:
                abrirContaPessoaFisica(TipoDeConta.INVESTIMENTO);
                break;
            case ABRIR_CONTA_CORRENTE_PESSOA_JURIDICA:
                abrirContaPessoaJuridica(TipoDeConta.CORRENTE);
                break;
            case ABRIR_CONTA_INVESTIMENTO_PESSOA_JURIDICA:
                abrirContaPessoaJuridica(TipoDeConta.INVESTIMENTO);
                break;
            case SACAR:
                sacar();
                break;
            case DEPOSITAR:
                depositar();
                break;
            case TRANSFERIR:
                transferir();
                break;
            case SALDO:
                saldo();
                break;
        }
    }

    private static void abrirContaPessoaFisica(TipoDeConta tipoDeConta) {

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu cpf: ");
        String cpf = scanner.nextLine();

        Conta conta = banco.abrirContaPessoaFisica(nome, cpf, tipoDeConta);

        System.out.println("CONTA PESSOA FISICA ABERTA");
        System.out.println(conta);
        continuar();
    }

    private static void saldo() {
        Conta conta = lerConta();
        if (conta == null) {
            System.out.println("CONTA NAO EXISTE!!!");
            scanner.nextLine();
        } else {
            System.out.println("CONTA");
            System.out.println(conta);
            System.out.println("Saldo da conta: " + conta.saldo());
            continuar();
        }
    }

    private static void transferir() {
        System.out.println("Conta Origem");
        Conta contaOrigem = lerConta();
        if (contaOrigem == null) {
            System.out.println("CONTA NAO EXISTE!!! Pressione qualquer tecla!");
            scanner.nextLine();
            return;
        }

        System.out.println("Conta Destino");
        Conta contaDestino = lerConta();
        if (contaDestino == null) {
            System.out.println("CONTA NAO EXISTE!!! Pressione qualquer tecla!");
            scanner.nextLine();
            return;
        }

        System.out.println("CONTA ORIGEM");
        System.out.println(contaOrigem);
        System.out.println("Saldo da conta: " + contaOrigem.saldo());

        System.out.print("Valor a transferir: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        banco.transferir(contaOrigem, contaDestino, valor);
        System.out.println("Novo saldo ORIGEM: " + contaOrigem.saldo());
        System.out.println("Novo saldo DESTINO: " + contaDestino.saldo());
        continuar();
    }

    private static void depositar() {
        Conta conta = lerConta();
        if (conta == null) {
            System.out.println("CONTA NAO EXISTE!!!");
            scanner.nextLine();
        } else {
            System.out.println("CONTA");
            System.out.println(conta);
            System.out.println("Saldo da conta: " + conta.saldo());
            System.out.print("Valor a depositar: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();
            banco.creditar(conta, valor);
            System.out.println("Novo saldo: " + conta.saldo());
            continuar();
        }
    }

    private static void sacar() {
        Conta conta = lerConta();
        if (conta == null) {
            System.out.println("CONTA NAO EXISTE!!!");
            continuar();
        } else {
            System.out.println("CONTA");
            System.out.println(conta);
            System.out.print("Valor a sacar: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();
            banco.debitar(conta, valor);
            System.out.println("Novo saldo: " + conta.saldo());
            continuar();
        }
    }

    private static Conta lerConta() {
        System.out.print("Digite o numero da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();
        return banco.getConta(numeroConta);
    }

    private static void continuar() {
        System.out.println("Pressione qualquer tecla para continuar!!!");
        scanner.nextLine();
    }

    private static void abrirContaPessoaJuridica(TipoDeConta tipoDeConta) {
        System.out.print("Digite a razao social: ");
        String razaoSocial = scanner.nextLine();

        System.out.print("Digite o cnpj: ");
        String cnpj = scanner.nextLine();

        Conta conta = banco.abrirContaPessoaJuridica(razaoSocial, cnpj, tipoDeConta);

        System.out.println("CONTA PESSOA JURIDICA ABERTA");
        System.out.println(conta);
        continuar();
    }
}
