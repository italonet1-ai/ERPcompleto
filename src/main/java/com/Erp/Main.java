package com.Erp;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorFornecedor menuFornecedor = new GerenciadorFornecedor();
        GerenciadorProduto menuProduto = new GerenciadorProduto(menuFornecedor);
        int opcao = -1;
        while (opcao!=0) {


            System.out.println("Escolha a opção que deseja acessar");
            System.out.println("1-Sessão de fornecedores");
            System.out.println("2- Sessão de produtos");
            System.out.println("0- Sair");
            opcao = scanner.nextInt();
                scanner.nextLine();
            switch (opcao){
                case 1:
                    menuFornecedor.Iniciarmenu();
                    break;
                case 2:
                    menuProduto.IniciarMenu();
                    break;

            }


        }
    }
}