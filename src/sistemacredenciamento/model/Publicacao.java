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

    public Publicacao(int ano, Veiculo veiculoPublicacao, String titulo, List<Docente> listaAutores, int numero) {
        this.ano = ano;
        this.veiculoPublicacao = veiculoPublicacao;
        this.titulo = titulo;
        this.listaAutores = listaAutores;
        this.numero = numero;

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

}
