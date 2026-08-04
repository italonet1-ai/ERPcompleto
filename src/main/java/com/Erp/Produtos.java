package com.Erp;

public class Produtos {

    private int codigo;
    private Fornecedor fornecedor;
    private String descricaoProduto;
    private String unidadeMedida;
    private Double preco;


   public Produtos(int codigo,String descricaoProduto,String unidadeMedida,Double preco,Fornecedor fornecedor ){
       this.codigo = codigo;
       this.fornecedor = fornecedor;
       this. descricaoProduto =  descricaoProduto;
       this.unidadeMedida = unidadeMedida;
       this.preco = preco;

   }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
