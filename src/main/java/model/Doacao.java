package model;

import Enums.Genero;
import Enums.Tamanho;
import Enums.Tipo;
import Enums.UnidadeMedida;

public class Doacao {

    public Object adicionarDoacao;
    private int idDoacao;
    private String descricao;
    private Tipo tipo;
    private Genero genero;
    private Tamanho tamanho;
    private int quantidade;
    private UnidadeMedida unidadeMedida;
    private String validade;
    private int centroDistribuicaoId;

    public Doacao(){
    }
    public Doacao(Tipo tipo,String descricao,Genero genero, Tamanho tamanho, UnidadeMedida unidadeMedida, int quantidade, String validade, int centroDistribuicaoId, int idDoacao) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.genero = genero;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
        this.validade = validade;
        this.centroDistribuicaoId = centroDistribuicaoId;
        this.idDoacao = idDoacao;
    }

    public int getIdDoacao() {
        return idDoacao;
    }

    public void setIdDoacao(int idDoacao) {
        this.idDoacao = idDoacao;
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

    public int getCentroDistribuicaoId() {
        return centroDistribuicaoId;
    }

    public void setCentroDistribuicaoId(int centroDistribuicaoId) {
        this.centroDistribuicaoId = centroDistribuicaoId;
    }

    @Override
    public String toString() {
        return "Doacao{" +
                "id=" + idDoacao +
                ", descricao='" + descricao + '\'' +
                ", tipo=" + tipo +
                ", genero=" + genero +
                ", tamanho=" + tamanho +
                ", quantidade=" + quantidade +
                ", unidadeMedida=" + unidadeMedida +
                ", validade=" + validade +
                ", centroDistribuicaoId=" + centroDistribuicaoId +
                '}';
    }


}
