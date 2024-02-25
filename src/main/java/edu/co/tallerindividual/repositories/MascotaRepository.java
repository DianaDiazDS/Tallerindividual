package edu.co.tallerindividual.repositories;

import edu.co.tallerindividual.entities.Mascota;
import edu.co.tallerindividual.entities.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Integer> {
    @Query("SELECT a FROM Mascota a WHERE a.raza LIKE CONCAT('%',:raza,'%')")
    public List<Mascota> findByRaza(String raza);

    List<Mascota> findMascotaByVeterinarios(Veterinario veterinario);

}
