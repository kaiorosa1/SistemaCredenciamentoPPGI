/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacredenciamento.model;

import java.util.List;

/**
 *
 * @author Kaio Rosa
 */
public class Publicacao {
    private int ano;
    private Veiculo veiculoPublicacao;
    private String titulo;
    private List<Docente> listaAutores;
    private int numero;
    private int paginalInical;
    private int paginaFinal;

    public Publicacao(int ano, Veiculo veiculoPublicacao, String titulo, List<Docente> listaAutores, int numero, int paginalInical, int paginaFinal) {
        this.ano = ano;
        this.veiculoPublicacao = veiculoPublicacao;
        this.titulo = titulo;
        this.listaAutores = listaAutores;
        this.numero = numero;
        this.paginalInical = paginalInical;
        this.paginaFinal = paginaFinal;
    }

    
    
    
    public Veiculo getVeiculoPublicacao() {
        return veiculoPublicacao;
    }

    public void setVeiculoPubicacao(Veiculo veiculoPublicacao) {
        this.veiculoPublicacao = veiculoPublicacao;
    }

    public List<Docente> getListaAutores() {
        return listaAutores;
    }

    public void setListaAutores(List<Docente> listaAutores) {
        this.listaAutores = listaAutores;
    }

    
    
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    public int getPaginalInical() {
        return paginalInical;
    }

    public void setPaginalInical(int paginalInical) {
        this.paginalInical = paginalInical;
    }

    public int getPaginaFinal() {
        return paginaFinal;
    }

    public void setPaginaFinal(int paginaFinal) {
        this.paginaFinal = paginaFinal;
    }
    
    
}
