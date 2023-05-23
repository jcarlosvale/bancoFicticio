package main;

import entidades.cliente.Cliente;
import service.BancoService;

public class TelaPrincipal {

    public static void main(String[] args) {

        BancoService bancoService = new BancoService();
        //teste PF
        Cliente clientePF = bancoService.abrirContaPF("Joao", "862.221.670-55");
        System.out.println(clientePF);

        //teste PJ
        Cliente clientePJ = bancoService.abrirContaPJ("Google", "99.521.060/0001-17");
        System.out.println(clientePJ);

        //teste Cliente Unico
        Cliente clienteCharlatao = bancoService.abrirContaPF("Maria", "862.221.670-55");
        System.out.println(clienteCharlatao);
        System.out.println(clienteCharlatao.equals(clientePF));  //true

        //CREDITAR

//        bancoService.creditar(12,120.00);







    }
}
