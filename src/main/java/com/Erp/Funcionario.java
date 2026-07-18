package com.Erp;

public class Funcionario {

    private int matricula;
    private String nome;
    private int idade;
    private String funcao;
    private Double salario;

public Funcionario(int matricula, String nome,int idade,String funcao ,Double salario ){

      this.matricula = matricula;
      this.nome = nome;
      this.idade = idade;
      this.funcao = funcao;
      this.salario = salario;

}

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getFuncao() {
        return funcao;
    }

    public Double getSalario() {
        return salario;
    }
}
