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
public class Periodico extends Publicacao {

    private int volumePeriodico;
    private int paginalInical;
    private int paginaFinal;

    public Periodico(int volumePeriodico, int paginalInical, int paginaFinal, int ano, Veiculo veiculoPublicacao, String titulo, List<Docente> listaAutores, int numero) {
        super(ano, veiculoPublicacao, titulo, listaAutores, numero);
        this.volumePeriodico = volumePeriodico;
        this.paginalInical = paginalInical;
        this.paginaFinal = paginaFinal;
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

    public int getVolumePeriodico() {
        return volumePeriodico;
    }

    public void setVolumePeriodico(int volumePeriodico) {
        this.volumePeriodico = volumePeriodico;
    }
}
