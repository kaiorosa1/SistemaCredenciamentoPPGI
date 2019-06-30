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
    private Date dataNacimeto;
    private Date dataIngresso;
    private boolean isCordenador;

    public Docente(long codigo, String nome, Date dataNacimeto, Date dataIngresso, boolean isCordenador) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNacimeto = dataNacimeto;
        this.dataIngresso = dataIngresso;
        this.isCordenador = isCordenador;
    }

    public Docente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Date getDataNacimeto() {
        return dataNacimeto;
    }

    public void setDataNacimeto(Date dataNacimeto) {
        this.dataNacimeto = dataNacimeto;
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

    public boolean isIsCordenador() {
        return isCordenador;
    }

    public void setIsCordenador(boolean isCordenador) {
        this.isCordenador = isCordenador;
    }

    public List<Publicacao> getListaPublicacoesDocente(List<Publicacao> lp) {
        List<Publicacao> listaPublicacaoAutor = new ArrayList<>();
        for (Publicacao p : lp) {
            if (p.getListaAutores().contains(this)) {

                listaPublicacaoAutor.add(p);
            }
        }
        return listaPublicacaoAutor;
    }

    public double getPontuacaoDocente(List<Publicacao> publi, List<Qualificacao> lq, RegrasPontuacao r) {
        double pontosAutor = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(r.getDataInicio());
        int anoMinimo = calendar.get(Calendar.YEAR) - r.getQuantidadeDeAnosConsiderar();

        for (Publicacao p : publi) {

            for (Qualificacao q : lq) {
                if (p.getVeiculoPublicacao().getSigla().equals(q.getVeiculoQualificacao().getSigla()) && p.getAno() >= anoMinimo && p.getAno() < calendar.get(Calendar.YEAR) ) {
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
