package hse.projectx.petdonate_api.repository;

import hse.projectx.petdonate_api.model.Shelter;
import hse.projectx.petdonate_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter, String> {
    @Query(value = "SELECT shelter from Shelter shelter where shelter.id=?1")
    List<Shelter> GetShelterById(String shelterID);

    @Query("select p.id from #{#entityName} p")
    List<String> getAllIds();
}
