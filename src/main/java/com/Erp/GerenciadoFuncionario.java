package com.Erp;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

    public class GerenciadoFuncionario {


        Scanner scanner = new Scanner(System.in);

        ArrayList<Funcionario> gerenciadorFuncionario = new ArrayList<>();

      public  GerenciadoFuncionario(){
          CarregarDados();
      }
        public void iniciarMenu() {

            int opcao = -1;
            System.out.println("Bem-vindo ao menu de gerenciamento de funcionarios: ");
            while (opcao != 0) {


                System.out.println("Escolha uma das opções de menu abaixo: ");
                System.out.println("1- Admitir um novo funcionario. ");
                System.out.println("2- Listar funcionarios da empresa: ");
                System.out.println("3- Promover funcionario ");
                System.out.println("4- Demitir funcionario ");
                System.out.println("5- Alterar cadastro do funcionario:");
                System.out.println("0- Sair do sistema ");

                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        Cadastrar();
                        break;

                    case 2:
                        Buscar();
                        break;
                    case 3:
                        Promover();
                        break;
                    case 4:
                        Demitir();
                        break;
                    case 5:
                        AlteracaoCadastro();
                        break;
                    case 0:
                        System.out.println("Sistema finalizado com sucesso! Dados salvos");
                        Gravar();
                        break;
                }


            }

        }   //metodo para fazer a Admissão do novo funcionario.

        private void Cadastrar() {

            System.out.println("Digite a matricula do funcionario:");
            int matricula = scanner.nextInt();
            scanner.nextLine();
            while (matricula < 0 ) {
                System.out.println("Matricula não pode ser um numero negativo, gentileza digitar novamente: ");
                matricula = scanner.nextInt();

            }
            for (Funcionario f : gerenciadorFuncionario){
                if (f.getMatricula() == matricula){
                    System.out.println("Já existe um funcionario com essa matricula, ");
                    return;
                }
            }
            System.out.println("Digite o nome do novo funcionario: ");
            String nome = scanner.nextLine();

            while (nome.trim().isEmpty()) {
                System.out.println("Nome em branco não é possivel, gentileza digitar novamente:");
                nome = scanner.nextLine();
            }
            System.out.println("Digite a idade do funcionario:");
            int idade = scanner.nextInt();
            scanner.nextLine();
            while (idade < 18) {
                System.out.println("Funcionario menor de idade não pode ser contratado, gentileza digitar de novo:");
                idade = scanner.nextInt();
                scanner.nextLine();
            }
            System.out.println("Digite o cargo do funcionario: ");
            String funcao = scanner.nextLine();
            while (funcao.trim().isEmpty()) {
                System.out.println("Função digitada está em branco, gentileza digitar novamente");
                funcao = scanner.nextLine();
            }
            System.out.println("Digite o salario do funcionario:");
            Double salario = scanner.nextDouble();
            scanner.nextLine();
            while (salario <= 0) {
                System.out.println("Salario igual ou menor que 0 não é permitido, gentileza digitar novamente:");
                salario = scanner.nextDouble();
                scanner.nextLine();
            }
            System.out.println("Tem certeza que deseja confirmar a contratação do novo funcionario? ");
            String confirmacao = scanner.nextLine();
            if (confirmacao.equalsIgnoreCase("Sim")) {
                Funcionario novoFuncionario = new Funcionario(matricula, nome, idade, funcao, salario);
                gerenciadorFuncionario.add(novoFuncionario);
                System.out.println("Funcionario admitido com sucesso!");
            } else {
                return;
            }
        }

        private void Buscar() {

            if (gerenciadorFuncionario.isEmpty()) {
                System.out.println("Nenhum funcionario admitido na empresa ainda:");
            } else {
                System.out.println("Segue lista de funcinarios admitidos na empresa:");
                for (Funcionario f : gerenciadorFuncionario) {

                    System.out.println("matricula: | " + f.getMatricula() + " | Nome: | " + f.getNome() + " | idade: | " + f.getIdade() +
                            " | Cargo: | " + f.getFuncao() + " | salario: | " + f.getSalario());
                }
            }

        }

        private void Demitir() {

            Funcionario funcionarioDemitir = null;

            System.out.println("Digite a matricula do funcionario");
            int matriculaDemitir = scanner.nextInt();
            scanner.nextLine();

            for (Funcionario f : gerenciadorFuncionario) {
                if (f.getMatricula() == matriculaDemitir) {
                    funcionarioDemitir = f;
                    break;
                }
            }
            if (funcionarioDemitir != null) {
                System.out.println("Funcionario " + funcionarioDemitir.getNome() + " cargo: " + funcionarioDemitir.getFuncao());
                System.out.println("Tem certeza que quer demitir esse funcinario? ");
                String confimacao = scanner.nextLine();
                if (confimacao.equalsIgnoreCase("Sim")) {
                    gerenciadorFuncionario.remove(funcionarioDemitir);
                    System.out.println("Funcionario demitido com sucesso:");
                } else {
                    return;
                }
            }

        }

        private void Promover() {

            Funcionario funcinarioPromover = null;
            System.out.println("Digite a matricula do funcionario a ser promovido:");
            int matriculaPromover = scanner.nextInt();
            scanner.nextLine();
            for (Funcionario f : gerenciadorFuncionario) {
                if (f.getMatricula() == matriculaPromover) {
                    funcinarioPromover = f;
                    break;
                }
            }
            if (funcinarioPromover != null) {
                System.out.println("Digite o novo cargo do funcinario:");
                String novoCargo = scanner.nextLine();
                System.out.println("Digite o novo salario fo funcionario");
                double novoSalario = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Tem certeza que deseja promover esse funcinario: ");
                String confimacao = scanner.nextLine();
                if (confimacao.equalsIgnoreCase("Sim")) {
                    funcinarioPromover.setFuncao(novoCargo);
                    funcinarioPromover.setSalario(novoSalario);
                    System.out.println("Funcionario : " + funcinarioPromover.getNome() + " Promovido com sucesso! ");
                } else {
                    System.out.println("Promoção cancelada!");
                }

            } else {
                System.out.println("Matricula não encontrada.");
            }

        }

        private void AlteracaoCadastro() {
            Funcionario funcionarioAlterar = null;
            System.out.println("Digite a matricula do funcionario que deseja alterar o cadastro:");
            int matriculaAlterar = scanner.nextInt();
            scanner.nextLine();
            for (Funcionario f : gerenciadorFuncionario) {
                if (f.getMatricula() == matriculaAlterar) {
                    funcionarioAlterar = f;
                    break;
                }
            }
            if (funcionarioAlterar != null) {
                int opcao = -1;
                System.out.println("O que você deseja alterar no cadastro do funcionario.");
                System.out.println("1- Nome do funcionario:");
                System.out.println("2- Idade do funcionario");
                System.out.println("3- Cargo do funcionario .");
                System.out.println("4- Salario do funcionario .");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o nome correto do funcionario:");
                        String nomeCorreto = scanner.nextLine();
                        while (nomeCorreto.trim().isEmpty()) {
                            System.out.println("Não é permitido nome em branco, gentileza digitar novamente");
                            nomeCorreto = scanner.nextLine();
                        }
                        System.out.println("Nome alterado com sucesso:");
                        funcionarioAlterar.setNome(nomeCorreto);
                        break;
                    case 2:
                        System.out.println("Digite a idade correta do funcinario");
                        int idadeCorreta = scanner.nextInt();
                        scanner.nextLine();
                        while (idadeCorreta < 18) {
                            System.out.println("Funcionario menor de idade, não é possivel digite novamente");
                            idadeCorreta = scanner.nextInt();
                            scanner.nextLine();
                        }
                        System.out.println("Idade alterado com sucesso:");
                        funcionarioAlterar.setIdade(idadeCorreta);

                        break;
                    case 3:
                        System.out.println("Digite o cargo correto do funcionario");
                        String cargoCorreto = scanner.nextLine();
                        while (cargoCorreto.trim().isEmpty()) {
                            System.out.println("Não é possivel ter cargo em branco, gentileza digitar novamente");
                            cargoCorreto = scanner.nextLine();
                            System.out.println("Cargo alterado com sucesso:");
                        }
                        funcionarioAlterar.setFuncao(cargoCorreto);
                        System.out.println("Cargo alterado com sucesso:");
                        break;
                    case 4:
                        System.out.println("Digite o salario correto do funcionario:");
                        double salarioCorreto = scanner.nextDouble();
                        while (salarioCorreto == funcionarioAlterar.getSalario()) {
                            System.out.println("Salario novo igual ao salario já cadastrodo, gentileza digitar novamente");
                            salarioCorreto = scanner.nextDouble();
                            scanner.nextLine();
                        }
                        funcionarioAlterar.setSalario(salarioCorreto);
                        System.out.println("Salario alterado com sucesso:");

                        break;
                }
            }
        }

        private void Gravar() {
            String nomeAquivo = "Funcionarios.txt";
            try (PrintWriter writer = new PrintWriter(new FileWriter(nomeAquivo))) {
                for (Funcionario f : gerenciadorFuncionario) {
                    writer.println(f.getMatricula() + "," + f.getNome() + "," + f.getIdade() + "," + f.getFuncao() + "," + f.getSalario());
                }
                System.out.println("Dados salvos com sucesso!");
            } catch (IOException e) {
                System.out.println("Erro ao salvar arquivo " + e.getMessage());
            }

        }

        private void CarregarDados() {
            File arquivo = new File("Funcionarios.txt");
            if (!arquivo.exists()) {
                return;
            }
            try (Scanner leitorArquivo = new Scanner(arquivo)) {
                while (leitorArquivo.hasNextLine()) {
                    String linha = leitorArquivo.nextLine();
                    String[] partes = linha.split(",");
                    if (partes.length == 5) {
                        int matricula = Integer.parseInt(partes[0]);
                        String nome = partes[1];
                        int idade = Integer.parseInt(partes[2]);
                        String funcao = partes[3];
                        double salario = Double.parseDouble(partes[4]);

                        // Recria o funcionário e adiciona na lista
                        Funcionario f = new Funcionario(matricula, nome, idade, funcao, salario);
                        gerenciadorFuncionario.add(f);
                    }
                }
                System.out.println("Dados carregados com sucesso!");
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado.");
            }
        }

    }