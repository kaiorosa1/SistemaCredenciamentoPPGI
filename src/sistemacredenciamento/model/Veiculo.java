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
public class Veiculo {
    
    private String sigla;
    private String nome;
    private char tipo;
    private double fatorDeImpacto;
    private String ISSN;

    public Veiculo(String sigla, String nome, char tipo, double fatorDeImpacto, String ISSN) {
        this.sigla = sigla;
        this.nome = nome;
        this.tipo = tipo;
        this.fatorDeImpacto = fatorDeImpacto;
        this.ISSN = ISSN;
    }

    public Veiculo() {
        
    }
    
    
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public double getFatorDeImpacto() {
        return fatorDeImpacto;
    }

    public void setFatorDeImpacto(double fatorDeImpacto) {
        this.fatorDeImpacto = fatorDeImpacto;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "nome=" + nome + '}';
    }
    
    
    
}
