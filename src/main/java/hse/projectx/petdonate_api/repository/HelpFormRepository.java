package hse.projectx.petdonate_api.repository;

import hse.projectx.petdonate_api.model.HelpForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpFormRepository extends JpaRepository<HelpForm, Long> {
}
