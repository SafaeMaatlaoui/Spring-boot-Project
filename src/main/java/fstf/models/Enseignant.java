package fstf.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Enseignant extends User{

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "lab",referencedColumnName = "nom")
    Lab lab;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "department",referencedColumnName = "name")
    Department department;


    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Enseignant{" +
                "lab=" + lab +
                ", department=" + department +
                ", user_id='" + user_id + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", account=" + account +
                '}';
    }
}
