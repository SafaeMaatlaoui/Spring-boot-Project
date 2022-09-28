package fstf.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Postulat {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    int id_offre;
    String nom_fournisseur;
    public Postulat() {
        super();
        // TODO Auto-generated constructor stub
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_offre() {
        return id_offre;
    }
    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }
    public String getNom_Fournisseur() {
        return nom_fournisseur;
    }
    public void setNom_Fournisseur(String nom_Fournisseur) {
        this.nom_fournisseur = nom_Fournisseur;
    }
    @Override
    public String toString() {
        return "Postulat [id=" + id + ", id_offre=" + id_offre + ", nom_fournisseur=" + nom_fournisseur + "]";
    }

}
