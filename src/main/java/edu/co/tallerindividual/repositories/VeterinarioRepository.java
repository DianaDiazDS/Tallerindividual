package edu.co.tallerindividual.repositories;

import edu.co.tallerindividual.entities.Carnet;
import edu.co.tallerindividual.entities.Dueño;
import edu.co.tallerindividual.entities.Mascota;
import edu.co.tallerindividual.entities.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeterinarioRepository extends JpaRepository< Veterinario ,Integer> {

    List<Veterinario> findVeterinarioByMascotas(Mascota mascota);
}
