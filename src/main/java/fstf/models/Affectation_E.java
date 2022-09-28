package fstf.models;


import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
public class Affectation_E extends Affectation{

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user",referencedColumnName = "user_id")
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Affectation_E{" +
                "id=" + id +
                ", department=" + department +
                ", user=" + user +
                '}';
    }
}
