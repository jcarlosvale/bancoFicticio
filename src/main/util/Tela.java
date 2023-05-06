package main.util;

import java.util.Scanner;

public class Tela {

    private static Scanner scanner = new Scanner(System.in);

    public static Opcao menuPrincipal() {
        System.out.println("\n".repeat(5));
        System.out.println("######## MENU PRINCIPAL ######## ");
        System.out.println("1 - Abrir Conta");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Transferir");
        System.out.println("5 - Saldo");
        System.out.println("9 - Sair");
        System.out.print("Digite uma opcao: ");
        int opcao = scanner.nextInt();
        return opcaoEscolhidaMenuPrincipal(opcao);
    }

    private static Opcao opcaoEscolhidaMenuPrincipal(int opcao) {
        switch (opcao) {
            case 1: return Opcao.ABRIR_CONTA;
            case 2: return Opcao.SACAR;
            case 3: return Opcao.DEPOSITAR;
            case 4: return Opcao.TRANSFERIR;
            case 5: return Opcao.SALDO;
            case 9: return Opcao.SAIR;
            default: return Opcao.INVALIDA;
        }
    }

    public static Opcao menuAbrirConta() {
        System.out.println("\n".repeat(5));
        System.out.println("######## ABRIR CONTA ######## ");
        System.out.println("1 - Cliente Fisica");
        System.out.println("2 - Cliente Juridica");
        System.out.println("9 - Voltar");
        System.out.print("Digite uma opcao: ");
        int opcao = scanner.nextInt();
        return opcaoEscolhidaMenuAbrirConta(opcao);
    }

    private static Opcao opcaoEscolhidaMenuAbrirConta(int opcao) {
        switch (opcao) {
            case 1: return Opcao.ABRIR_CONTA_PESSOA_FISICA;
            case 2: return Opcao.ABRIR_CONTA_PESSOA_JURIDICA;
            case 9: return Opcao.VOLTAR;
            default: return Opcao.INVALIDA;
        }
    }

    public static Opcao menuAbrirContaPessoaFisica() {
        System.out.println("\n".repeat(5));
        System.out.println("######## ABRIR CONTA PF ######## ");
        System.out.println("1 - Corrente");
        System.out.println("2 - Poupança");
        System.out.println("3 - Investimento");
        System.out.println("9 - Voltar");
        System.out.print("Digite uma opcao: ");
        int opcao = scanner.nextInt();
        return opcaoEscolhidaMenuAbrirContaPessoaFisica(opcao);
    }

    private static Opcao opcaoEscolhidaMenuAbrirContaPessoaFisica(int opcao) {
        switch (opcao) {
            case 1: return Opcao.ABRIR_CONTA_CORRENTE_PESSOA_FISICA;
            case 2: return Opcao.ABRIR_CONTA_POUPANCA_PESSOA_FISICA;
            case 3: return Opcao.ABRIR_CONTA_INVESTIMENTO_PESSOA_FISICA;
            case 9: return Opcao.VOLTAR;
            default: return Opcao.INVALIDA;
        }
    }

    public static Opcao menuAbrirContaPessoaJuridica() {
        System.out.println("\n".repeat(5));
        System.out.println("######## ABRIR CONTA PJ ######## ");
        System.out.println("1 - Corrente");
        System.out.println("2 - Investimento");
        System.out.println("9 - Voltar");
        System.out.print("Digite uma opcao: ");
        int opcao = scanner.nextInt();
        return opcaoEscolhidaMenuAbrirContaPessoaJuridica(opcao);
    }

    private static Opcao opcaoEscolhidaMenuAbrirContaPessoaJuridica(int opcao) {
        switch (opcao) {
            case 1: return Opcao.ABRIR_CONTA_CORRENTE_PESSOA_JURIDICA;
            case 2: return Opcao.ABRIR_CONTA_INVESTIMENTO_PESSOA_JURIDICA;
            case 9: return Opcao.VOLTAR;
            default: return Opcao.INVALIDA;
        }
    }
}
