package edu.co.tallerindividual.repositories;

import edu.co.tallerindividual.entities.Carnet;
import edu.co.tallerindividual.entities.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarioRepository extends JpaRepository< Veterinario ,Integer> {
}
