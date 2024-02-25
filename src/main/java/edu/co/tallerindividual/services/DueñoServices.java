package edu.co.tallerindividual.services;


import edu.co.tallerindividual.entities.Dueño;
import edu.co.tallerindividual.entities.Mascota;
import edu.co.tallerindividual.repositories.DueñoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DueñoServices {

    @Autowired
    DueñoRepository dueñoRepository;

    public List<Dueño> findAll() {
        return dueñoRepository.findAll();
    }

    public Dueño findById(Integer id) {
        return dueñoRepository.findById(id).orElse(null);
    }

    public Dueño save(Dueño Dueño) {
        return dueñoRepository.save(Dueño);
    }
    public boolean delete(Integer id){
        dueñoRepository.delete(findById(id));
        return true;
    }


    public boolean update(Integer id,Dueño dueño){
        Dueño dueñoeditar = findById(id);
        if (dueñoeditar != null){
            dueñoeditar.setNombre(dueño.getNombre());
            dueñoeditar.setTelefono(dueño.getTelefono());
            dueñoeditar.setDirecccion(dueño.getDirecccion());
            dueñoRepository.save(dueñoeditar);
            return true;
        }else {
            return false;
        }
    }

    public List<Dueño> findByNombre(String nombre){
        return dueñoRepository.findByNombre(nombre);
    }

}
