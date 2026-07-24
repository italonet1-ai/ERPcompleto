package com.Erp;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorProdutos {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Produtos> gerenciadorProdutos = new ArrayList<>();
    public void iniciarMenu(){

        int opcao = -1;
        System.out.println("Bem-vindo ao menu de gerenciamento de Produtos: ");

        while (opcao !=0){


            System.out.println("Escolha uma das opções de menu abaixo: ");
            System.out.println("1- Cadastrar um novo produto. ");
            System.out.println("2- Listar produtos cadastrados na empresa: ");
            System.out.println("3- Remover produto cadastrado ");
            System.out.println("4- Alterar cadastro do produto ");
            System.out.println("0- Sair do sistema ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    removerProduto();
                    break;
                case 4:
                    alterarCadastro();
                    break;
            }


        }


    }

    private void cadastrar(){

        System.out.println("Digite o codigo do produto:");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        while (codigo<0){
            System.out.println("Codigo menor que zero não é possivel, digite novamente:");
            codigo = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Digite o nome do fornecedor que entrega o produto: ");
        String fornecedor = scanner.nextLine();
        while (fornecedor.trim().isEmpty()){
            System.out.println("Nome do fornecedor em branco, gentileza digitar novamente");
            fornecedor = scanner.nextLine();
        }
        System.out.println("Digite a descrição do produtodo:");
        String descricao = scanner.nextLine();
        while (descricao.trim().isEmpty()){
            System.out.println("Descrição em branco, gentileza digitar novamente:");
            descricao = scanner.nextLine();
        }
        System.out.println("Digite a unidade de medida do produto: ");
        String unidadeMedida = scanner.nextLine();
        while (unidadeMedida.trim().isEmpty()){
            System.out.println("Unidade de medida em branco, digite novamente:");
            unidadeMedida = scanner.nextLine();
        }
        System.out.println("Digite o valor do produto:");
        Double valor = scanner.nextDouble();
        scanner.nextLine();
        while (valor <0  ){
            System.out.println("Preço menor que 0, gentileza digitar novamente");
            valor = scanner.nextDouble();
            scanner.nextLine();
        }
        System.out.println("Deseja confirmar o cadastro do novo produto:");
        String confimacao = scanner.nextLine();
        if (confimacao.equalsIgnoreCase("Sim")) {
            Produtos novoProduto = new Produtos(codigo, fornecedor, descricao, unidadeMedida, valor);
            gerenciadorProdutos.add(novoProduto);
            System.out.println("Produto cadastrado com sucesso.");

        }else {
            return;
        }


    }

    private void listarProdutos() {
        if (gerenciadorProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado: ");
            return;
        }
        System.out.println("Segue lista de produtos cadastrados: ");
        for (Produtos f : gerenciadorProdutos) {

            System.out.println("|Codigo | " + f.getCodigo() + " |Fornecedor | " + f.getNomeFornecedor() + " |Descrição | " + f.getDescricaoProduto() +
                    " |unidade de medida | " + f.getUnidadeMedida() + " valor | " + f.getPreco());
        }
    }

    private void removerProduto(){

        Produtos produtoRemover = null;

        System.out.println("Digite o codigo do produto a ser removido");
        int codigoRemover = scanner.nextInt();
        scanner.nextLine();

        for (Produtos f : gerenciadorProdutos) {
            if (f.getCodigo() == codigoRemover) {
              produtoRemover = f;
                break;
            }
        }
        if (produtoRemover != null){
        System.out.println("produto a ser removido "+ produtoRemover.getDescricaoProduto());
               System.out.println("Tem certeza que deseja remover o produto?");
               String sim = scanner.nextLine();
               if (sim.equalsIgnoreCase("Sim")){
                   gerenciadorProdutos.remove(produtoRemover);
                   System.out.println("Produto removido com sucesso");
               }else {
                   return;
               }


        }


    }

    private void alterarCadastro(){

        Produtos produtoAlterar = null;

        System.out.println("Digite o codigo do produto a ser alterado:");
        int codigoAlterar = scanner.nextInt();
        scanner.nextLine();

        for (Produtos f : gerenciadorProdutos){
            if (f.getCodigo() == codigoAlterar){
                 produtoAlterar = f;
                break;
            }
        }
        if (produtoAlterar !=null){
            int opcao=-1;
            System.out.println("Escolha no menu o que deseja alterar");
            System.out.println("1- Alterar a descrição do produto");
            System.out.println("2- Alterar o Fornecedor do produto");
            System.out.println("3- Alterar a unidade de medida do produto");
            System.out.println("3- Alterar o preço do produto");
            opcao = scanner.nextInt();
            scanner.nextLine();


                switch (opcao){
                    case 1:
                        System.out.println("Digite a nova descrição do produto:");
                        String novaDescricao = scanner.nextLine();

                        while(novaDescricao.trim().isEmpty()){
                            System.out.println("Nova descrição não pode ser vazia, digite novamente");
                            novaDescricao = scanner.nextLine();
                        }
                        produtoAlterar.setDescricaoProduto(novaDescricao);
                        System.out.println("Descrição alterada alterada com sucesso:");
                        break;
                    case 2:
                        System.out.println("Digite o nome do fornecedor:");
                        String novoFornecedor = scanner.nextLine();

                        while (novoFornecedor.trim().isEmpty()){
                        System.out.println("Nome do fornecedor não pode ficar em branco");
                            novoFornecedor = scanner.nextLine();
                        }
                         produtoAlterar.setNomeFornecedor(novoFornecedor);
                        System.out.println("Fornecedor alterado com sucesso:");
                        break;
                    case 3:
                        System.out.println("Digite a nova unidade de medida:");
                        String novaUnidade = scanner.nextLine();
                        while (novaUnidade.trim().isEmpty()){
                            System.out.println("Unidade de medida não pode ficar em branco, digite novamente:");
                            novaUnidade = scanner.nextLine();
                        }
                        produtoAlterar.setUnidadeMedida(novaUnidade);
                        break;

                }
            }
        }




    }






