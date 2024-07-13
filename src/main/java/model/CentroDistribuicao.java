package model;

public class CentroDistribuicao {

    private int id;
    private String nome;
    private String endereco;
    private int capacidade;
    private double ocupacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(double ocupacao) {
        this.ocupacao = ocupacao;
    }

    @Override
    public String toString() {
        return "CentroDistribuicao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", capacidade=" + capacidade +
                ", ocupacao=" + ocupacao +
                '}';
    }
}
