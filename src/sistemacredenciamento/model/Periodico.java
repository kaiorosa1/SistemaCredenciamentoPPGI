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

    public Periodico(int volumePeriodico, int ano, Veiculo veiculoPublicacao, String titulo, List<Docente> listaAutores, int numero, int paginalInical, int paginaFinal) {
        super(ano, veiculoPublicacao, titulo, listaAutores, numero, paginalInical, paginaFinal);
        this.volumePeriodico = volumePeriodico;
    }

    
    public int getVolumePeriodico() {
        return volumePeriodico;
    }

    public void setVolumePeriodico(int volumePeriodico) {
        this.volumePeriodico = volumePeriodico;
    }
}
