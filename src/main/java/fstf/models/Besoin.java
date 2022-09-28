package fstf.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Besoin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int besoin_id;
    String nom_ressource;
    int qte;
    int status;

    @Transient
    boolean deletable = true;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isDeletable() {
        return deletable;
    }

    public void setDeletable(boolean deletable) {
        this.deletable = deletable;
    }

    public Besoin(String nom_ressource, int qte) {
        super();
        this.nom_ressource = nom_ressource;
        this.qte = qte;
    }
    public Besoin() {
        super();
        status=0;

    }
    public int getBesoin_id() {
        return besoin_id;
    }

    public String getNom_ressource() {
        return nom_ressource;
    }
    public void setNom_ressource(String nom_ressource) {
        this.nom_ressource = nom_ressource;
    }
    public int getQte() {
        return qte;
    }
    public void setQte(int qte) {
        this.qte = qte;
    }

}
