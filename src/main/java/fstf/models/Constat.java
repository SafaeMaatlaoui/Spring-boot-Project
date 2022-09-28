package fstf.models;

import javax.persistence.*;

@Entity
public class Constat {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    String objet;
    String email;
    @OneToOne()
    @JoinColumn(name = "panne",referencedColumnName = "id")
    Panne panne;

    public Constat() {

    }

    public Panne getPanne() {
        return panne;
    }

    public void setPanne(Panne panne) {
        this.panne = panne;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Constat{" +
                "id=" + id +
                ", objet='" + objet + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
