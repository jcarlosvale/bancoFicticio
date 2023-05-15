package main;

import java.util.Scanner;

public class AlternativaMenu {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            menu();
            System.out.println("Digite a opcao: ");
            String opcao = scanner.nextLine();
            int op = analisar(opcao);
            sair = (op == 9);
        }

    }

    private static int analisar(String opcao) {
        switch (opcao) {
            case "1":
                System.out.println("Implementar codigo da opcao 1...");
                scanner.nextLine();
                return 1;
            case "2":
                System.out.println("Implementar codigo da opcao 2...");
                scanner.nextLine();
                return 2;
            case "9":
                System.out.println("Sair");
                scanner.nextLine();
                return 9;
            default:
                System.out.println("Opcao invalida. Pressione para continuar");
                scanner.nextLine();
                return 100;
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
