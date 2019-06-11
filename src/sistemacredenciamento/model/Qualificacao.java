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
public class Qualificacao {
    private int ano;
    private String siglaVeiculo;
    private Qualis qualis;

    public Qualificacao(int ano, String siglaVeiculo, Qualis qualis) {
        this.ano = ano;
        this.siglaVeiculo = siglaVeiculo;
        this.qualis = qualis;
    }

    public Qualis getQualis() {
        return qualis;
    }

    public void setQualis(Qualis qualis) {
        this.qualis = qualis;
    }

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
    
}
