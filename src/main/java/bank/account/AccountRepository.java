package bank.account;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUid(String uid);

    Optional<Account> findByUidAndPersonId(String uid, Long person_id);

    List<Account> findAllByPersonId(Long personId, Pageable pageable);
}
