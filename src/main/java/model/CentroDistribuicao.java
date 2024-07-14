package model;

public class CentroDistribuicao {

    private String nome;
    private String endereco;
    private int id;
    private int capacidadeRoupa;
    private int capacidadeHigiene;
    private int capacidadeAlimento;

    public CentroDistribuicao(int id,String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidadeRoupa() {
        return capacidadeRoupa;
    }

    public void setCapacidadeRoupa(int capacidadeRoupa) {
        this.capacidadeRoupa = capacidadeRoupa;
    }

    public int getCapacidadeHigiene() {
        return capacidadeHigiene;
    }

    public void setCapacidadeHigiene(int capacidadeHigiene) {
        this.capacidadeHigiene = capacidadeHigiene;
    }

    public int getCapacidadeAlimento() {
        return capacidadeAlimento;
    }

    public void setCapacidadeAlimento(int capacidadeAlimento) {
        this.capacidadeAlimento = capacidadeAlimento;
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

    @Override
    public String toString() {
        return "CentroDistribuicao{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", id=" + id +
                ", capacidadeRoupa=" + capacidadeRoupa +
                ", capacidadeHigiene=" + capacidadeHigiene +
                ", capacidadeAlimento=" + capacidadeAlimento +
                '}';
    }
}