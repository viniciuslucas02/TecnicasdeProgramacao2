package br.edu.fatecpg.consomeapi.model;

import com.google.gson.annotations.SerializedName;

public class Endereco {
    private String cep;
    @SerializedName("logradouro")
    private String rua;
    private String bairro;
    private String localidade;
    private String estado;
    private Boolean erro;

    public Endereco(String cep, String rua, String bairro, String localidade, String estado) {
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.localidade = localidade;
        this.estado = estado;
    }

    public Boolean getErro() {
        return erro;
    }

    public void setErro(Boolean erro) {
        this.erro = erro;
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        if (Boolean.TRUE.equals(erro)) {
            return "CEP inválido!";
        }
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", estado='" + estado + '\'' +
                '}'+"\n";
    }
}
