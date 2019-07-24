/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacredenciamento.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Kaio Rosa
 */
public class Docente implements Comparable<Docente> {

    private long codigo;
    private String nome;
    private Date dataNascimeto;
    private Date dataIngresso;
    private boolean isCoordenador;

    public Docente() {

    }

    public Docente(long codigo, String nome, Date dataNacimeto, Date dataIngresso, boolean isCordenador) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimeto = dataNacimeto;
        this.dataIngresso = dataIngresso;
        this.isCoordenador = isCordenador;
    }

    public Date getDataNascimeto() {
        return dataNascimeto;
    }

    public void setDataNascimeto(Date dataNascimeto) {
        this.dataNascimeto = dataNascimeto;
    }

    public long getCodigo() {
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

    public boolean isIsCoordenador() {
        return isCoordenador;
    }

    public void setIsCoordenador(boolean isCoordenador) {
        this.isCoordenador = isCoordenador;
    }

    /* getListaPublicacoesDocente recebe lista publicacao geral e retoran a lista de publicacao de um determinado Docente*/
    public List<Publicacao> getListaPublicacoesDocente(List<Publicacao> lp) {
        List<Publicacao> listaPublicacaoAutor = new ArrayList<>();
        for (Publicacao p : lp) {
            if (p.getListaAutores().contains(this)) {

                listaPublicacaoAutor.add(p);
            }
        }
        return listaPublicacaoAutor;
    }

    /* getPontuacaoDocente calcula pontucao do docente de acordo com as regras e as publicacao do associdas */
    public double getPontuacaoDocente(List<Publicacao> publi, List<Qualificacao> lq, RegrasPontuacao r) {
        double pontosAutor = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(r.getDataInicio());
        int anoMinimo = calendar.get(Calendar.YEAR) - r.getQuantidadeDeAnosConsiderar();

        for (Publicacao p : publi) {

            for (Qualificacao q : lq) {
                if (p.getVeiculoPublicacao().getSigla().equals(q.getVeiculoQualificacao().getSigla()) && p.getAno() >= anoMinimo && p.getAno() < calendar.get(Calendar.YEAR)) {
                    if (p.getVeiculoPublicacao().getTipo() == 'P') {
                        pontosAutor += q.getQualis().getPontoQualis() * r.getMultiplicadorPeridicos();

                    } else {
                        pontosAutor += q.getQualis().getPontoQualis();
                    }

                }
            }

        }

        return pontosAutor;
    }

    @Override
    public int compareTo(Docente d) {
        return this.getNome().compareTo(d.getNome());
    }

}
