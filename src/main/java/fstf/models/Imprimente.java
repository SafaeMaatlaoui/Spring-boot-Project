package fstf.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Imprimente extends Ressource{
    String resolution;
    String speed;

    public void copy(Ressource r){
        this.code = r.code;
        this.date_liv = r.date_liv;
        this.duree_gar = r.duree_gar;
        this.marque = r.marque;
        this.fr   = r.fr;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return  "resolution='" + resolution + '\'' +
                ", speed='" + speed + '\'';
    }
}
