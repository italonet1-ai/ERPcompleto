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
                case 2:
                    ListarProdutos();
                    break;
                case 3:
                    AlterarProduto();
                    break;
                case 4:
                    ExcluirProduto();
                    break;
                case 0:
                    return;
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

       private void ListarProdutos(){

           if (gerenciadorFornecedor.gerenciadorFornecedores.isEmpty()){
               System.out.println("Nenhum fornecedor cadastrado");
               return;
           }
           System.out.println("Escolha uma das opções abaixo");
           int opcao= -1;
           while (opcao!=0){
               System.out.println("1- Listar todos os produtos e seus respectivos fornecedores");
               System.out.println("2- Listar produtos de um fornecedor especifico");
               System.out.println("0- Sair da tela:");
               opcao = scanner.nextInt();
               scanner.nextLine();
               switch (opcao){
                   case 1:
                       if (gerenciarProduto.isEmpty()){

                           System.out.println("Nenhum Produto cadastrado");
                           return;
                       }
                       System.out.println("Segue todos os fornecedores e seus respectivos produtos");
                       for (Fornecedor f: gerenciadorFornecedor.gerenciadorFornecedores ){
                           System.out.println("Fornecedor| "+f.getNomeFornecedor());
                           for (Produtos p : gerenciarProduto){
                               if (f.getCodigoFornecedor()== p.getFornecedor().getCodigoFornecedor()){

                                   System.out.println("Codigo do produto| "+p.getCodigo()+ " |Descriçao do produto: "+p.getDescricaoProduto()+
                                   " |Unidade de medida do produto: "+p.getUnidadeMedida()+ " |preço do produto: "+p.getPreco());

                               }
                           }
                       }
                       break;

                   case 2:
                       boolean listarProdutos = false;
                       if (gerenciarProduto.isEmpty()){
                           System.out.println("Nenhum produto cadastrado cadastrado");
                           return;
                       }
                       for (Fornecedor f : gerenciadorFornecedor.gerenciadorFornecedores){
                           System.out.println("Codigo: " +f.getCodigoFornecedor()+ " fornececdor: "+f.getNomeFornecedor());

                       }
                       System.out.println("Digite o codigo do fornecedor que quer ver os produtos cadastrados");
                       int codigoProduto = scanner.nextInt();
                       scanner.nextLine();

                       for (Produtos p : gerenciarProduto){
                        if (codigoProduto == p.getFornecedor().getCodigoFornecedor()) {
                            if (!listarProdutos) {
                                System.out.println("Segue lista de produtos cadastrados para esse forneceodor");
                                listarProdutos = true;

                            }
                            System.out.println("Codigo produto: " + p.getCodigo() + " Descrição: " + p.getDescricaoProduto() + " Unidade medida: " +p.getUnidadeMedida()+ " Preço: " + p.getPreco());
                        }
                        }
                       if (!listarProdutos){
                           System.out.println("Esse fornecedor não tem nenhu material cadastrado.");
                       }

                       break;
                   case 3:
                       return;

               }


           }

       }

       private void AlterarProduto(){
           Produtos alerarProduto = null;
            System.out.println("Bem-vindo a tela de alteração de protudos:");
            System.out.println("Segue a lista de fornecedores e seus respectivos produtos: ");


                for (Produtos p : gerenciarProduto){
                    System.out.println("Fornecedor: "+p.getFornecedor().getNomeFornecedor()+" Codigo: "+p.getCodigo()+ " Descrição: "+ p.getDescricaoProduto() + " Unidade de medida: " +p.getUnidadeMedida() + " Preço: "+p.getPreco());
            }
            System.out.println("Digite o codigo do produto que você queira alterar");
            Util modificador = new Util();
            int codigo = modificador.modificador(scanner);
            for (Produtos p : gerenciarProduto) {
                if (codigo == p.getCodigo()) {
                    alerarProduto = p;
                    break;
                }
            }
            if (alerarProduto!=null){
            int opcao = -1;
                System.out.println("Escolha a opção que você deseja alterar");
                System.out.println("1- Descrição do produto");
                System.out.println("2- unidade de medida do produto");
                System.out.println("3- preço");
                System.out.println("0- para sair");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao){
                    case 1:
                        System.out.println("Digite a nova descrição do produto");
                        String novaDescricao = scanner.nextLine();
                        while (novaDescricao.trim().isEmpty()){
                            System.out.println("Nova descrição não pode ficar em branco, gentileza digitar novamente");
                            novaDescricao = scanner.nextLine();
                        }
                        alerarProduto.setDescricaoProduto(novaDescricao);
                        System.out.println("Descrição alterada com sucesso:");
                        break;
                    case 2:
                        System.out.println("Digite a nova unidade de medida do produto:");
                        String novaMedida = scanner.nextLine();
                        while (novaMedida.trim().isEmpty()){
                            System.out.println("Nova unidade de medida não pode ficar em branco,gentileza digitar novamente");
                            novaMedida = scanner.nextLine();

                        }
                        alerarProduto.setUnidadeMedida(novaMedida);
                        System.out.println("Unidade de medida alterada com sucesso!");
                        break;
                    case 3:
                        System.out.println("Digite o novo preço do produto");
                        Util modicador = new Util();
                        Double novoPreco = modicador.modificadorPreco(scanner);
                        alerarProduto.setPreco(novoPreco);
                        System.out.println("Preço alterado com sucesso!");
                        break;
                    case 0:
                        return;

                }
            }else {
                System.out.println("Codigo não encontrado");
                return;
            }
       }

       private void ExcluirProduto(){
        Produtos excluirproduto = null;
        Produtos codigoProduto = null;
        System.out.println("Bem-vindo a tela de exclução de produtos");
        System.out.println("Lista de fornecedores cadastrados no sistema:");
        for (Fornecedor f: gerenciadorFornecedor.gerenciadorFornecedores){
            System.out.println("Codigo: " + f.getCodigoFornecedor() + " Nome: " +f.getNomeFornecedor());
        }
        System.out.println("Digite o codigo do fornecedor que você queira excluir o item");
        Util modificador = new Util();
        int codigoFornecedor = modificador.modificador(scanner);
        for (Produtos f : gerenciarProduto){
            if (codigoFornecedor == f.getFornecedor().getCodigoFornecedor()) {
                excluirproduto = f;
            }
        }
        if (excluirproduto != null){
            System.out.println("Segue produtos cadastrados nesse fornecedor");
            for (Produtos f: gerenciarProduto) {
                if (codigoFornecedor == f.getFornecedor().getCodigoFornecedor()) {
                    System.out.println("Codigo: " + f.getCodigo() + " Descriçao: " + f.getDescricaoProduto() + " Unidade de medida: " + f.getUnidadeMedida() + " Preço: " + f.getPreco());

                }
            }
        }
           System.out.println("Digie o codigo referente ao produto que você deseja excluir: ");
            int codigoExcluir = modificador.modificador(scanner);
            for (Produtos p : gerenciarProduto){
                if (codigoExcluir == p.getCodigo()){
                    codigoProduto = p;
                    break;
                }
            }

            if (codigoProduto !=null){
                System.out.println("tem certeza que deseja escluir esse produto?");
                String confimacao = scanner.nextLine();
                if (confimacao.equalsIgnoreCase("Sim")){
                    gerenciarProduto.remove(codigoProduto);
                    System.out.println("Produto excluido com sucesso");
                }
            }else {
                System.out.println("Codigo errado.");
                System.out.println("Ação cancelada, produto não foi removido");
                return;
            }
       }
}
