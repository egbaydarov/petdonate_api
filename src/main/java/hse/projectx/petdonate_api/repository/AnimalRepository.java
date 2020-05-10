package hse.projectx.petdonate_api.repository;

import hse.projectx.petdonate_api.model.Animal;
import hse.projectx.petdonate_api.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    @Query(value = "SELECT animal from Animal animal where animal.shelter_id=?1")
    List<Animal> GetAnimalByShelterId(Long animalID);

    @Query("select p from #{#entityName} p")
    List<Animal> getAllIds();
    
}
