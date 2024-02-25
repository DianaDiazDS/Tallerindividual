package edu.co.tallerindividual.repositories;

import edu.co.tallerindividual.entities.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Integer> {
}
