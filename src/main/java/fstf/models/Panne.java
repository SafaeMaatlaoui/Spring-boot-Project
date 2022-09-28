package fstf.models;


import javax.persistence.*;

@Entity

public class Panne {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    String code;
    String date;
    String frequence;
    String ordre;
    String explication;
    Integer status =0;
    @OneToOne()
    @JoinColumn(name = "ressource",referencedColumnName = "code")
    Ressource ressource;

    public Panne() {

    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    public String getExplication() {
        return explication;
    }

    public void setExplication(String explication) {
        this.explication = explication;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Panne{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", date='" + date + '\'' +
                ", frequence='" + frequence + '\'' +
                ", ordre='" + ordre + '\'' +
                ", explication='" + explication + '\'' +
                ", status=" + status +
                ", ressource=" + ressource +
                '}';
    }
}
