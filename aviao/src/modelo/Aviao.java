/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;
import java.time.LocalDate;
/**
 *
 * @author Administrador
 */
public class Aviao {
   private Double vol;
   private Integer cod;
   private String mol;
   private Integer capa;
   private LocalDate datacons;

    public Double getVol() {
        return vol;
    }

    public void setVol(Double vol) {
        this.vol = vol;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getMol() {
        return mol;
    }

    public void setMol(String mol) {
        this.mol = mol;
    }

    public Integer getCapa() {
        return capa;
    }

    public void setCapa(Integer capa) {
        this.capa = capa;
    }

    public LocalDate getDatacons() {
        return datacons;
    }

    public void setDatacons(LocalDate datacons) {
        this.datacons = datacons;
    }

    @Override
    public String toString() {
        return "Aviao{" + "capa=" + capa + '}';
    }
   
}
