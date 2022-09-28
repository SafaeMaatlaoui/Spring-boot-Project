package fstf.doa;

import fstf.models.Enseignant;
import fstf.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantDAO extends JpaRepository<Enseignant,String> {
//Enseignant findEnseignantByUser_id(String user_id);
}
