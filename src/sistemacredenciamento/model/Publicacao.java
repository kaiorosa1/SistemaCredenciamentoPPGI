/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacredenciamento.model;

/**
 *
 * @author Kaio Rosa
 */
public class Publicacao {
    private int ano;
    private String siglaVeiculo;
    private String titulo;
    //lista Autores -- lista de docentes
    private int numero;
    
   
    private int paginalInical;
    private int paginaFinal;

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getSiglaVeiculo() {
        return siglaVeiculo;
    }

    public void setSiglaVeiculo(String siglaVeiculo) {
        this.siglaVeiculo = siglaVeiculo;
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
