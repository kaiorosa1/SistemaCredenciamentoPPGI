/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacredenciamento.model;

import java.util.Date;

/**
 *
 * @author Kaio Rosa
 */
public class Docente {
    private int codigo;
    private String nome;
    private Date dataIngresso;
    private boolean isCordenador;

    
    public Docente(int codigo, String nome, Date dataIngresso, boolean isCordenador) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataIngresso = dataIngresso;
        this.isCordenador = isCordenador;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public boolean isIsCordenador() {
        return isCordenador;
    }

    public void setIsCordenador(boolean isCordenador) {
        this.isCordenador = isCordenador;
    }
    
    
}
