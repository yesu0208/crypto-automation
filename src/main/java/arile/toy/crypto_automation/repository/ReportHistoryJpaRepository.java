package arile.toy.crypto_automation.repository;

import arile.toy.crypto_automation.entity.ReportHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportHistoryJpaRepository extends JpaRepository<ReportHistory, Integer> {
}
