package com.Erp;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorFornecedor {

    Scanner scanner = new Scanner(System.in);
    public  ArrayList<Fornecedor> gerenciadorFornecedores = new ArrayList<>();

    public void Iniciarmenu(){
        int opcao = -1;
        System.out.println("Bem-vindo a tela de gerenciamento de fornecedores: ");

        while (opcao !=0){
            System.out.println("Escolha a opção que deseja acessar:");
            System.out.println("1- Cadastrar novo fornecedor:");
            System.out.println("2- Consultar fornecedores cadastrados:");
            System.out.println("3- Alterar cadastrdo do fornecedor: ");
            System.out.println("4- Remover cadastrdo do fornecedor: ");
            System.out.println("0- Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
                case 1:
                    Cadastrar();
                    break;
                case 2:
                ListarFornecedor();
                    break;
                case 3:
                    AlterarFornecedor();
                    break;
                case 4:
                    ExcluirFornecedor();
                    break;
                case 0:
                    return;
            }

        }


    }




    private void Cadastrar(){

        System.out.println("Bem-vindo a tela de cadastro:");
        System.out.println("Digite o Codigo do forncedor ");
        Util modifcar = new Util();
        int codigoFornecedor = modifcar.modificador(scanner);
        for (Fornecedor f: gerenciadorFornecedores){
            if (f.getCodigoFornecedor() == codigoFornecedor){
                System.out.println("Codigo já cadastrado no sistema");
                return;
            }
        }
        System.out.println("Digite o cnpj do fornecedor:");
        String cnpj = scanner.nextLine();
        while (cnpj.trim().isEmpty()){
            System.out.println("Cnpj do fornecedor não pode ficar em branco, gentileza digitar novamente.");
            cnpj = scanner.nextLine();
        }
        for (Fornecedor f:gerenciadorFornecedores){
            if (f.getCnpj().equals(cnpj)){
                System.out.println("Cnpj já está cadastrado no sistema:");
                return;
            }
        }

        System.out.println("Digite o nome do fornecedor:");
        String nomeFornecdor = scanner.nextLine();
        while (nomeFornecdor.trim().isEmpty()){
            System.out.println("Nome do fornecedor não pode ficar em branco, digite novamente");
            nomeFornecdor = scanner.nextLine();
        }
        for (Fornecedor f : gerenciadorFornecedores){
            if (f.getNomeFornecedor().equals(nomeFornecdor)){
                System.out.println("Fornecedor já está cadastrado no sistema:");
                return;
            }
        }
        System.out.println("Digite o telefone de contato do fornecedor:");
        String telefone = scanner.nextLine();
        while (telefone.trim().isEmpty()){
            System.out.println("Telefone de contato obrigatorio, gentileza digitar novamente:");
            telefone = scanner.nextLine();
        }
        System.out.println("Deseja confirmar o cadastro do novo fornecedor?");
        String confimacao = scanner.nextLine();
        if (confimacao.equalsIgnoreCase("Sim")){
            Fornecedor novoFornecedor = new Fornecedor(codigoFornecedor,cnpj,nomeFornecdor,telefone);
            gerenciadorFornecedores.add(novoFornecedor);
            System.out.println("Fornecedor cadastrado com sucesso:");
        }else {
            System.out.println("Cadastro cancelado:");
            return;
        }
    }
    private void ListarFornecedor(){

        if (gerenciadorFornecedores.isEmpty()){
            System.out.println("Nenhum fornecedor cadastrado no sistema:");
            return;
        }
        System.out.println("Segue lista de fornecedores cadastrados no sistema:");
        for (Fornecedor f : gerenciadorFornecedores){
            System.out.println("Codigo Fornecedor: "+f.getCodigoFornecedor()+ " |Cnpj:  "+f.getCnpj()+ " |Nome do fornecedor:  "+f.getNomeFornecedor()+
                    " |Telefone do fornecedor: " + f.getTelefone());
        }

    }

    private void AlterarFornecedor(){

        Fornecedor fornecedorAlterar = null;
        System.out.println("Digite o codigo do fornecedor a ser alterado:");
        Util modifcar = new Util();
        int codigo = modifcar.modificador(scanner);
        for (Fornecedor f: gerenciadorFornecedores){
            if (codigo == f.getCodigoFornecedor()){
                 fornecedorAlterar = f;
                break;
            }
        }
        if (fornecedorAlterar !=null){
            int opcao = -1;
            System.out.println("Escolha a opção que você deseja alterar");
            System.out.println("1- Cnpj do fornecedor");
            System.out.println("2- nome do fornecedor");
            System.out.println("3- telefone do fornecedor");
            System.out.println("0- para sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
                case 1:
                    System.out.println("Digite o novo cnpj do fornecedor");
                    String novoCpnj = scanner.nextLine();
                    while (novoCpnj.trim().isEmpty()){
                        System.out.println("Cpnj em branco, gentileza digitar novamente");
                        novoCpnj = scanner.nextLine();
                    }
                    fornecedorAlterar.setCnpj(novoCpnj);
                    System.out.println("Cpnj alterado com sucesso.");
                    break;
                case 2:
                    System.out.println("Digite o nome do fornecedor:");
                    String novoNome = scanner.nextLine();
                    while (novoNome.trim().isEmpty()){
                        System.out.println("Nome não deve ficar em branco,gentileza digitar novamente");
                        novoNome = scanner.nextLine();
                    }
                   fornecedorAlterar.setNomeFornecedor(novoNome);
                    System.out.println("Nome alterado com sucesso");
                    break;
                case 3:
                    System.out.println("Digite o novo telefone do fornecedor ");
                    String novoNumero = scanner.nextLine();
                    while (novoNumero.trim().isEmpty()){
                        System.out.println("Novo numero de telefone não pode ficar em branco, gentileza digitar novamente");
                        novoNumero = scanner.nextLine();
                    }
                    fornecedorAlterar.setTelefone(novoNumero);
                    System.out.println("Telefone alterado com sucesso.");
                break;

                case 0:
                    Iniciarmenu();
            }



        }else {
            System.out.println("Codigo do fornecedor não encontrado:");
            return;
        }


    }
    private void ExcluirFornecedor(){

        Fornecedor fornecedorExcluir = null;
        System.out.println("Digite o codigo do fornecedor a ser excluido:");
        Util modifcar = new Util();
        int codigo = modifcar.modificador(scanner);
        for(Fornecedor f : gerenciadorFornecedores){
            if (codigo == f.getCodigoFornecedor()){
                fornecedorExcluir = f;
                break;
            }


        }if (fornecedorExcluir != null){
            System.out.println("Segue dados do fornecedor a ser excluido do sistema:");
            System.out.println("Codigo do fornecedor: "+fornecedorExcluir.getCodigoFornecedor());
            System.out.println("Nome do fornecedor: "+fornecedorExcluir.getNomeFornecedor());
            System.out.println("Telefone de contata do fornecedor: "+fornecedorExcluir.getTelefone());
            System.out.println("Tem certeza que deseja excluir esse fornecedor?");
            String confirmacao = scanner.nextLine();
            if (confirmacao.equalsIgnoreCase("Sim")){
                gerenciadorFornecedores.remove(fornecedorExcluir);
                System.out.println("Fornecedor excluido com sucesso:");
            }else {
                System.out.println("Exclusão cancelada.");
            }
        }else {
            System.out.println("Fornecedor não encontrado");
            return;
        }


    }
}
