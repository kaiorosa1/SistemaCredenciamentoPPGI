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
public class Qualificacao implements Comparable<Qualificacao>{
    private int ano;
    private Veiculo veiculoQualificacao;
    private Qualis qualis;

    public Qualificacao(int ano, Veiculo veiculoQualificacao, Qualis qualis) {
        this.ano = ano;
        this.veiculoQualificacao = veiculoQualificacao;
        this.qualis = qualis;
    }
    
     
    public Veiculo getVeiculoQualificacao() {
        return veiculoQualificacao;
    }

    public void setVeiculoQualificacao(Veiculo veiculoQualificacao) {
        this.veiculoQualificacao = veiculoQualificacao;
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

    @Override
    public int compareTo(Qualificacao q) {
        return q.getQualis().getSiglaQualis().compareTo(this.getQualis().getSiglaQualis());
    }

   
}
