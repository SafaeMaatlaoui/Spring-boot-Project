package fstf.doa;

import fstf.models.Ressource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface RessourceDAO extends CrudRepository<Ressource,String> {
    @Transactional
    @Query("FROM Ressource WHERE nom_soc=?1")
    public List<Ressource> findByFr(String nom_soc);
    public Ressource findRessourceByCode(String code);
}
