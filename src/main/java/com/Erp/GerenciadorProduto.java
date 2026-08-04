package com.Erp;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorProduto {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Produtos> gerenciarProduto = new ArrayList<>();

    private GerenciadorFornecedor gerenciadorFornecedor;

    public GerenciadorProduto(GerenciadorFornecedor gerenciadorFornecedor){
        this.gerenciadorFornecedor = gerenciadorFornecedor;
    }
    public void IniciarMenu() {

        int opcao = -1;

        System.out.println("Bem-vindo a tela de cadastro de produtos:");

        while (opcao!=0){
            System.out.println("Escolha a opção que deseja acessar:");
            System.out.println("1- Cadastrar novo Produto:");
            System.out.println("2- Consultar Produtos cadastrados:");
            System.out.println("3- Alterar cadastrdo do Produto: ");
            System.out.println("4- Remover Produto cadastrado: ");
            System.out.println("0- Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
                case 1:
                CadastrarProduto();
                    break;
            }
        }
    }
       private void CadastrarProduto(){

        Fornecedor codigoFornecedor = null;
        if (gerenciadorFornecedor.gerenciadorFornecedores.isEmpty()){
            System.out.println("Nenhum fornecedor cadastrado");
            return;
        }
           System.out.println("Segue lista de fornecedores cadastrados");
        for (Fornecedor f: gerenciadorFornecedor.gerenciadorFornecedores){
            System.out.println("Codigo Fornecedor: "+f.getCodigoFornecedor()+ " |Cnpj:  "+f.getCnpj()+ " |Nome do fornecedor:  "+f.getNomeFornecedor());

        }
        System.out.println("Digite o codigo do fornecedor para a qual você quer cadastrar o produto");
        Util modificador = new Util();
        int codigo = modificador.modificador(scanner);
        for (Fornecedor f: gerenciadorFornecedor.gerenciadorFornecedores){
            if (codigo == f.getCodigoFornecedor()){
                codigoFornecedor =f;
                break;
            }
        }
        if (codigoFornecedor !=null){
            System.out.println("Digite o codigo do produto");
            int codigoProduto = modificador.modificador(scanner);
            System.out.println("Digite a descrição do produto");
            String descricaoProduto = scanner.nextLine();
            while (descricaoProduto.trim().isEmpty()){
                System.out.println("Descrição obrigatoria, digite novamente");
                descricaoProduto = scanner.nextLine();
            }
            System.out.println("Digite a unidade de medida do produto");
            String unidadeMedida = scanner.nextLine();
            while (unidadeMedida.trim().isEmpty()){
                System.out.println("Unidade de medida obrigatoria, digite novamente");
                unidadeMedida = scanner.nextLine();
            }
            System.out.println("Digite o preço do produto");
            Double precoProduto = modificador.modificadorPreco(scanner);
            System.out.println("Deseja confirmar o cadastro do novo produto?");
            String confirmacao = scanner.nextLine();
            if (confirmacao.equalsIgnoreCase("Sim")){
                Produtos novoProduto = new Produtos(codigoProduto,descricaoProduto,unidadeMedida,precoProduto,codigoFornecedor);
                gerenciarProduto.add(novoProduto);
                System.out.println("Produto cadastrado com sucesso");
            }else {
                System.out.println("Produto não cadastrado");
                return;
            }
        }else {
            System.out.println("Codigo não encontrado no sistema:");
            return;
        }
       }
}
