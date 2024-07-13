package model;

public class Abrigo {

    private int id;
    private String nome;
    private String endereco;
    private String responsavel;
    private String telefone;
    private String email;
    private int capacidade;
    private int ocupacao;

    public Abrigo(){
    }

    public Abrigo(String nome, String endereco, String responsavel, String telefone, String email, int capacidade, int ocupacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.responsavel = responsavel;
        this.telefone = telefone;
        this.email = email;
        this.capacidade = capacidade;
        this.ocupacao = ocupacao;
    }

    public Abrigo(String nome, String endereco, String responsavel, String telefone, String email) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(int ocupacao) {
        this.ocupacao = ocupacao;
    }

    @Override
    public String toString() {
        return "Abrigo{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", capacidade=" + capacidade +
                ", ocupacao=" + ocupacao +
                '}';
    }
}
