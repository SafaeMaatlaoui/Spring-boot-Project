package fstf.doa;

import fstf.models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountDAO extends CrudRepository<Account,String> {
}
