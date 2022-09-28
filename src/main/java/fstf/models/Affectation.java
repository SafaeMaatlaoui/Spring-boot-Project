package fstf.models;


import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Affectation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "department",referencedColumnName = "name")
    Department department;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ressource",referencedColumnName = "code")
    Ressource ressource;

    @Transient
    boolean forAll;

    public boolean isForAll() {
        return forAll;
    }

    public void setForAll(boolean forAll) {
        this.forAll = forAll;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    @Override
    public String toString() {
        return "Affectation{" +
                "id=" + id +
                ", department=" + department +
                ", ressource=" + ressource +
                '}';
    }
}
