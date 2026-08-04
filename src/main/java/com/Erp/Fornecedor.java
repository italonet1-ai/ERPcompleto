package com.Erp;

public class Fornecedor {

    private int codigoFornecedor;
    private String cnpj;
    private String nomeFornecedor;
    private String telefone;

    public Fornecedor(int codigoFornecedor, String cnpj,String nomeFornecedor, String telefone ){
        this.codigoFornecedor = codigoFornecedor;
        this.cnpj = cnpj;
        this.nomeFornecedor = nomeFornecedor;
        this.telefone = telefone;

    }

    public int getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(int codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
