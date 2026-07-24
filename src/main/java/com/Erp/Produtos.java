package com.Erp;

public class Produtos {

    private int codigo;
    private String nomeFornecedor;
    private String descricaoProduto;
    private String unidadeMedida;
    private Double preco;

   public Produtos(int codigo,String nomeFornecedor,String descricaoProduto,String unidadeMedida,Double preco ){
       this.codigo = codigo;
       this.nomeFornecedor = nomeFornecedor;
       this. descricaoProduto =  descricaoProduto;
       this.unidadeMedida = unidadeMedida;
       this.preco = preco;
   }
    public int getCodigo(){

       return codigo;
    }
    public String getNomeFornecedor(){

       return nomeFornecedor;
    }
    public String getDescricaoProduto(){
       return  descricaoProduto;
    }
    public String getUnidadeMedida(){

       return unidadeMedida;
    }
    public Double getPreco(){

       return preco;
    }

    public void setNomeFornecedor(String novoNomeFornecedor) {
        this.nomeFornecedor = novoNomeFornecedor;
    }

    public void setDescricaoProduto(String novaDescricaoProduto) {
        this.descricaoProduto = novaDescricaoProduto;
    }

    public void setPreco(Double novoPreco) {
        this.preco = novoPreco;
    }

    public void setUnidadeMedida(String novauUidadeMedida) {
        this.unidadeMedida = novauUidadeMedida;
    }
}
