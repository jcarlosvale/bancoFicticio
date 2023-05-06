package main;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

enum Sexo {
    MASCULINO, FEMININO, BISSEXUAL;
}

public class Teoria {

    public static void main(String[] args) {

        Sexo sexo = Sexo.FEMININO;


        Set<Integer> numeros = new HashSet<>();

        numeros.add(3);
        numeros.add(2);
        numeros.add(1);
        numeros.add(3);

//        for(int i : numeros) {
//            System.out.println(i);
//        }

//        //pesquisar
        var indice = numeros.contains(5);
        System.out.println(indice);



    }

}
