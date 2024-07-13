package model;

import Enums.Genero;
import Enums.Tamanho;
import Enums.Tipo;
import Enums.UnidadeMedida;

public class Doacao {

    private int id;
    private String descricao;
    private Tipo tipo;
    private Genero genero;
    private Tamanho tamanho;
    private int quantidade;
    private UnidadeMedida unidadeMedida;
    private String validade;
    private CentroDistribuicao centroDistribuicao;

    public Doacao(){
    }

    public Doacao(String descricao, Tipo tipo, Genero genero, Tamanho tamanho, int quantidade, UnidadeMedida unidadeMedida, String validade, CentroDistribuicao centroDistribuicao) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.genero = genero;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
        this.validade = validade;
        this.centroDistribuicao = centroDistribuicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public CentroDistribuicao getCentroDistribuicao() {
        return centroDistribuicao;
    }

    public void setCentroDistribuicao(CentroDistribuicao centroDistribuicao) {
        this.centroDistribuicao = centroDistribuicao;
    }

    @Override
    public String toString() {
        return "Doacao{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", tipo=" + tipo +
                ", genero=" + genero +
                ", tamanho=" + tamanho +
                ", quantidade=" + quantidade +
                ", unidadeMedida=" + unidadeMedida +
                ", validade='" + validade + '\'' +
                ", centroDistribuicao=" + centroDistribuicao +
                '}';
    }
}
