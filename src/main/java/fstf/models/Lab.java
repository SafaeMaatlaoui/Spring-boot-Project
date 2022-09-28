package fstf.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Lab {
    @Id
    String nom;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "department",referencedColumnName = "name")
    Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "nom='" + nom + '\'' +
                ", department=" + department +
                '}';
    }
}
