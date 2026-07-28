package com.Erp;

import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class Util {

    public int modificador(Scanner scanner) {

        int codigo = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                String input = scanner.nextLine();
                codigo = Integer.parseInt(input);
                if (codigo < 0) {
                    System.out.println("Codigo não pode ser um numero negativo, digite novamente:");
                } else {
                    entradaValida = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro, digite apenas numeros inteiros válidos por favor:");

            }
        }
        return codigo;
    }

    public double modificadorPreco(Scanner scanner){

        double preco = -1;
        boolean entradaValida = false;
       while (!entradaValida){
           try {
               String input = scanner.nextLine();
               preco = Double.parseDouble(input);
               if(preco<0){
                   System.out.println("Impossivel preço negativo, por favor digite novamente:");
               } else {
                   entradaValida = true;
               }
           }catch (NumberFormatException e){
               System.out.println("Erro, digite valores reais por favor");
           }
       }
        return preco;
    }

}

