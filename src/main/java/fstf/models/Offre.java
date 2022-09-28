package fstf.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
@Entity
public class Offre {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int offre_id;
    int qte_imprimante;
    int qte_ordinateur;
    int status;
    String etat;

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    String fournisseur;

    @Transient
    boolean deletable = true;

    public boolean isDeletable() {
        return deletable;
    }
    public Offre() {
        super();
        // TODO Auto-generated constructor stub
        status=0;
        etat="Pas Encore Affecter";
    }
    public int getOffre_id() {
        return offre_id;
    }

    public int getQte_imprimante() {
        return qte_imprimante;
    }
    public void setQte_imprimante(int qte_imprimante) {
        this.qte_imprimante = qte_imprimante;
    }
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    public int getQte_ordinateur() {
        return qte_ordinateur;
    }
    public void setQte_ordinateur(int qte_ordinateur) {
        this.qte_ordinateur = qte_ordinateur;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

}
