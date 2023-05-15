package main;

import java.util.Scanner;

public class AlternativaMenuComEnum {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MenuOpcao opcao1 = MenuOpcao.QUALQUER;
        MenuOpcao opcao2 = MenuOpcao.INVALIDA;

        System.out.println(opcao1.getDescricao());
        System.out.println(opcao2.getDescricao());




//        while (opcaoMenu != MenuOpcao.SAIR) {
//            menu();
//            System.out.println("Digite a opcao: ");
//            String opcaoDigitada = scanner.nextLine();
//            opcaoMenu = identificarOpcao(opcaoDigitada);
//            processar(opcaoMenu);
//        }

    }

    private static void processar(MenuOpcao opcaoMenu) {
        switch (opcaoMenu) {
            case INVALIDA:
            case CRIAR_CONTA_CORRENTE_PJ:
        }
    }

    private static MenuOpcao identificarOpcao(String opcaoDigitada) {
        switch (opcaoDigitada) {
            case "1":
                System.out.println("Implementar codigo da opcao 1...");
                scanner.nextLine();
                return MenuOpcao.CRIAR_CONTA_CORRENTE_PJ;
            case "2":
                System.out.println("Implementar codigo da opcao 2...");
                scanner.nextLine();
                return MenuOpcao.CRIAR_CONTA_CORRENTE_PF;
            case "9":
                System.out.println("Sair");
                scanner.nextLine();
                return MenuOpcao.SAIR;
            default:
                System.out.println("Opcao invalida. Pressione para continuar");
                scanner.nextLine();
                return MenuOpcao.INVALIDA;
        }
    }

    private static void menu() {
        System.out.println("MENU");
        System.out.println("1 - OP 1");
        System.out.println("2 - OP 2");
        System.out.println("3 - OP 3");
        System.out.println("4 - OP 4");
        System.out.println("5 - OP 5");
        System.out.println("6 - OP 6");
        System.out.println("7 - OP 7");
        System.out.println("8 - OP 8");
        System.out.println("9 - SAIR");
    }
}
