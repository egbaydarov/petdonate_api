package hse.projectx.petdonate_api.repository;

import hse.projectx.petdonate_api.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, String> {
    @Query(value = "SELECT pet  from Pet pet where pet.userId=?1")
    List<Pet> getPetById(String petId);
}