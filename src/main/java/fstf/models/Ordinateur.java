package fstf.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Ordinateur extends Ressource {
    String cpu;
    String disque_dur;
    String ecran;
    String ram;

    public void copy(Ressource r){
        this.code = r.code;
        this.marque =r.marque;
        this.date_liv = r.date_liv;
        this.duree_gar = r.duree_gar;
        this.fr   = r.fr;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getDisque_dur() {
        return disque_dur;
    }

    public void setDisque_dur(String disque_dur) {
        this.disque_dur = disque_dur;
    }

    public String getEcran() {
        return ecran;
    }

    public void setEcran(String ecran) {
        this.ecran = ecran;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return  "cpu='" + cpu + '\'' +
                ", disque_dur='" + disque_dur + '\'' +
                ", ecran='" + ecran + '\'' +
                ", ram='" + ram + '\'';
    }
}
