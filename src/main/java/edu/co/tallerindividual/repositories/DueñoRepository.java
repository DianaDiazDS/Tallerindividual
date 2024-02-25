
package edu.co.tallerindividual.repositories;
import edu.co.tallerindividual.entities.Dueño;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DueñoRepository  extends JpaRepository<Dueño,Integer > {
}
