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
public class Periodico extends Publicacao {
    private int volumePeriodico;

    public int getVolumePeriodico() {
        return volumePeriodico;
    }

    public void setVolumePeriodico(int volumePeriodico) {
        this.volumePeriodico = volumePeriodico;
    }
}
