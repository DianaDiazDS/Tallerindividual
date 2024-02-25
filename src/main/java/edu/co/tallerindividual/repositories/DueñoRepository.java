
package edu.co.tallerindividual.repositories;
import edu.co.tallerindividual.entities.Dueño;
import edu.co.tallerindividual.entities.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DueñoRepository  extends JpaRepository<Dueño,Integer > {
    @Query(value = "select * from dueño where nombre like concat('%',:nombre,'%')",nativeQuery = true)
    public List<Dueño> findByNombre(String nombre);


}
