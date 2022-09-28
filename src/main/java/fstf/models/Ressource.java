package fstf.models;


import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Ressource {
    @Id
    String code;
    String date_liv;
    Integer duree_gar;
    String marque;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "nom_soc",referencedColumnName = "nom_soc")
    Fournisseur fr;

    @Transient
    String type;

    @Transient
    public boolean affected = false;

    @Transient
    public Affectation affectation;



    public List<String> toList(){
        List<String> l = new ArrayList<>();
        l.add(code);
        l.add(this instanceof Imprimente? "Imprimente":"Ordinateur");
        l.add(date_liv);
        l.add(duree_gar + "");
        l.add(marque);
        return l;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate_liv() {
        return date_liv;
    }

    public void setDate_liv(String date_liv) {
        this.date_liv = date_liv;
    }

    public Integer getDuree_gar() {
        return duree_gar;
    }

    public void setDuree_gar(Integer duree_gar) {
        this.duree_gar = duree_gar;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Fournisseur getFr() {
        return fr;
    }

    public void setFr(Fournisseur fr) {
        this.fr = fr;
    }

    public boolean isAffected() {
        return affected;
    }

    public void setAffected(boolean affected) {
        this.affected = affected;
    }

    public Affectation getAffectation() {
        return affectation;
    }

    public void setAffectation(Affectation affectation) {
        this.affectation = affectation;
    }

    @Override
    public String toString() {
        return "Ressource{" +
                "code='" + code + '\'' +
                ", date_liv='" + date_liv + '\'' +
                ", duree_gar=" + duree_gar +
                ", marque='" + marque + '\'' +
                ", type='" + type + '\'' +
                ", fr=" + fr +
                '}';
    }
}
