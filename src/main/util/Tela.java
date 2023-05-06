package main.util;

import java.util.Scanner;

public class Tela {

    private static Scanner scanner = new Scanner(System.in);

    public static Operacao menuPrincipal() {
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
        return operacaoEscolhidaMenuPrincipal(opcao);
    }

    private static Operacao operacaoEscolhidaMenuPrincipal(int opcao) {
        switch (opcao) {
            case 1: return menuAbrirConta();
            case 2: return Operacao.SACAR;
            case 3: return Operacao.DEPOSITAR;
            case 4: return Operacao.TRANSFERIR;
            case 5: return Operacao.SALDO;
            case 9: return Operacao.SAIR;
            default: return Operacao.NENHUMA;
        }
    }

    public static Operacao menuAbrirConta() {
        OpcaoDeTela opcaoDeTela = OpcaoDeTela.INVALIDA;
        while (opcaoDeTela == OpcaoDeTela.INVALIDA) {
            System.out.println("\n".repeat(5));
            System.out.println("######## ABRIR CONTA ######## ");
            System.out.println("1 - Pessoa Fisica");
            System.out.println("2 - Pessoa Juridica");
            System.out.println("9 - Voltar");
            System.out.print("Digite uma opcao: ");
            int opcaoDigitada = scanner.nextInt();
            opcaoDeTela = opcaoDeTelaEscolhidaMenuAbrirConta(opcaoDigitada);
        }
        return operacaoEscolhidaMenuAbrirConta(opcaoDeTela);
    }

    private static OpcaoDeTela opcaoDeTelaEscolhidaMenuAbrirConta(int opcao) {
        switch (opcao) {
            case 1: return OpcaoDeTela.ABRIR_CONTA_PESSOA_FISICA;
            case 2: return OpcaoDeTela.ABRIR_CONTA_PESSOA_JURIDICA;
            case 9: return OpcaoDeTela.VOLTAR;
            default: return OpcaoDeTela.INVALIDA;
        }
    }

    private static Operacao operacaoEscolhidaMenuAbrirConta(OpcaoDeTela opcaoDeTela) {
        switch (opcaoDeTela) {
            case ABRIR_CONTA_PESSOA_FISICA:
                return menuAbrirContaPessoaFisica();
            case ABRIR_CONTA_PESSOA_JURIDICA:
                return menuAbrirContaPessoaJuridica();
            default:
                return Operacao.NENHUMA;
        }
    }

    public static Operacao menuAbrirContaPessoaFisica() {
        OpcaoDeTela opcaoDeTela = OpcaoDeTela.INVALIDA;
        while (opcaoDeTela == OpcaoDeTela.INVALIDA) {
            System.out.println("\n".repeat(5));
            System.out.println("######## ABRIR CONTA PF ######## ");
            System.out.println("1 - Corrente");
            System.out.println("2 - Poupança");
            System.out.println("3 - Investimento");
            System.out.println("9 - Voltar");
            System.out.print("Digite uma opcao: ");
            int opcaoDigitada = scanner.nextInt();
            opcaoDeTela = opcaoDeTelaEscolhidaMenuAbrirContaPessoaFisica(opcaoDigitada);
        }
        return operacaoEscolhidaMenuAbrirContaPessoaFisica(opcaoDeTela);
    }

    private static Operacao operacaoEscolhidaMenuAbrirContaPessoaFisica(OpcaoDeTela opcaoDeTela) {
        switch (opcaoDeTela) {
            case ABRIR_CONTA_CORRENTE_PESSOA_FISICA:
                return Operacao.ABRIR_CONTA_CORRENTE_PESSOA_FISICA;
            case ABRIR_CONTA_POUPANCA_PESSOA_FISICA:
                return Operacao.ABRIR_CONTA_POUPANCA_PESSOA_FISICA;
            case ABRIR_CONTA_INVESTIMENTO_PESSOA_FISICA:
                return Operacao.ABRIR_CONTA_INVESTIMENTO_PESSOA_FISICA;
            default:
                return Operacao.NENHUMA;
        }
    }

    private static OpcaoDeTela opcaoDeTelaEscolhidaMenuAbrirContaPessoaFisica(int opcao) {
        switch (opcao) {
            case 1: return OpcaoDeTela.ABRIR_CONTA_CORRENTE_PESSOA_FISICA;
            case 2: return OpcaoDeTela.ABRIR_CONTA_POUPANCA_PESSOA_FISICA;
            case 3: return OpcaoDeTela.ABRIR_CONTA_INVESTIMENTO_PESSOA_FISICA;
            case 9: return OpcaoDeTela.VOLTAR;
            default: return OpcaoDeTela.INVALIDA;
        }
    }

    public static Operacao menuAbrirContaPessoaJuridica() {
        OpcaoDeTela opcaoDeTela = OpcaoDeTela.INVALIDA;
        while (opcaoDeTela == OpcaoDeTela.INVALIDA) {
            System.out.println("\n".repeat(5));
            System.out.println("######## ABRIR CONTA PJ ######## ");
            System.out.println("1 - Corrente");
            System.out.println("2 - Investimento");
            System.out.println("9 - Voltar");
            System.out.print("Digite uma opcao: ");
            int opcaoDigitada = scanner.nextInt();
            opcaoDeTela = opcaoDeTelaEscolhidaMenuAbrirContaPessoaJuridica(opcaoDigitada);
        }
        return operacaoEscolhidaMenuAbrirContaPessoaJuridica(opcaoDeTela);
    }

    private static Operacao operacaoEscolhidaMenuAbrirContaPessoaJuridica(OpcaoDeTela opcaoDeTela) {
        switch (opcaoDeTela) {
            case ABRIR_CONTA_CORRENTE_PESSOA_JURIDICA:
                return Operacao.ABRIR_CONTA_CORRENTE_PESSOA_JURIDICA;
            case ABRIR_CONTA_INVESTIMENTO_PESSOA_JURIDICA:
                return Operacao.ABRIR_CONTA_INVESTIMENTO_PESSOA_JURIDICA;
            default:
                return Operacao.NENHUMA;
        }
    }

    private static OpcaoDeTela opcaoDeTelaEscolhidaMenuAbrirContaPessoaJuridica(int opcao) {
        switch (opcao) {
            case 1: return OpcaoDeTela.ABRIR_CONTA_CORRENTE_PESSOA_JURIDICA;
            case 2: return OpcaoDeTela.ABRIR_CONTA_INVESTIMENTO_PESSOA_JURIDICA;
            case 9: return OpcaoDeTela.VOLTAR;
            default: return OpcaoDeTela.INVALIDA;
        }
    }
}
