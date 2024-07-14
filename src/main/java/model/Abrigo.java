package model;

public class Abrigo {

    private int id;
    private String nome;
    private String endereco;
    private String responsavel;
    private String telefone;
    private String email;
    private int capacidadeRoupa;
    private int capacidadeHigiene;
    private int capacidadeAlimento;

    public Abrigo(){
    }

    public Abrigo(int id, String nome, String endereco, String responsavel, String telefone, String email, int capacidade, int ocupacao) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.responsavel = responsavel;
        this.telefone = telefone;
        this.email = email;
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

    @Override
    public String toString() {
        return "Abrigo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", capacidadeRoupa=" + capacidadeRoupa +
                ", capacidadeHigiene=" + capacidadeHigiene +
                ", capacidadeAlimento=" + capacidadeAlimento +
                '}';
    }
}
