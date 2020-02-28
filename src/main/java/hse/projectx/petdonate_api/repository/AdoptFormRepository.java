package hse.projectx.petdonate_api.repository;

import hse.projectx.petdonate_api.model.AdoptForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptFormRepository extends JpaRepository<AdoptForm, Long> {
}
