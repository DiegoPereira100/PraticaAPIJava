import com.google.gson.annotations.SerializedName;

public class Endereco {
    @SerializedName("cep")
    private String cep;
    @SerializedName("logradouro")
    private String rua;
    @SerializedName("bairro")
    private String bairro;
    @SerializedName("localidade")
    private String cidade;
    @SerializedName("uf")
    private String estado;

    // Getters e Setters
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "CEP='" + cep + '\'' +
                ", Rua='" + rua + '\'' +
                ", Bairro='" + bairro + '\'' +
                ", Cidade='" + cidade + '\'' +
                ", Estado='" + estado + '\'' +
                '}';
    }
}