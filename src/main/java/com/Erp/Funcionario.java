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

    public void  setNome(String novoNome){
    if (novoNome == null|| novoNome.trim().isEmpty()){
        System.out.println("Erro, nome em branco.");

    } else if (novoNome.equals(this.nome)){
        System.out.println("Sem alterações no nome, nome digita é igual ao nome antigo.");
    } else {
        this.nome = novoNome ;
    }
    }
    public void setIdade (Integer novaIdade) {
        if (novaIdade < 18 || novaIdade == this.idade) {
            System.out.println("Erro, idade digitada é igual a antiga idade ou funcionario com idade menor de 18 anos.");
        } else {
            this.idade = novaIdade;
        }
    }
    public void setFuncao (String novoCargo) {
       if (novoCargo == null || novoCargo.trim().isEmpty()){
           System.out.println("Erro, novo cargo não pode estar vazio.");
       }
       else if (novoCargo.equals(this.funcao)) {
            System.out.println("Novo cargo é igual ao cargo anterior, não teve alterações");
        } else {

            this.funcao = novoCargo;
        }
    }
    public  void setSalario(Double novoSalario) {
        if (novoSalario <= 0 || novoSalario < this.salario) {
            System.out.println("Novo salario não pode ser menor ou igual ao salario antigo e nem menor que 0:");
        } else {
            this.salario = novoSalario;
        }
    }
}
