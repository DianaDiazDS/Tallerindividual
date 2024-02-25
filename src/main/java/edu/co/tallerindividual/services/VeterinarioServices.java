package edu.co.tallerindividual.services;


import edu.co.tallerindividual.entities.Veterinario;
import edu.co.tallerindividual.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class VeterinarioServices {
    @Autowired
    VeterinarioRepository veterinarioRepository;

    public List<Veterinario> findAll() {
        return veterinarioRepository.findAll();
    }

    public Veterinario findById(Integer id) {
        Optional<Veterinario> optional = veterinarioRepository.findById(id);
        return optional.orElse(null);
    }
    public Veterinario save(Veterinario Veterinario) {
        return veterinarioRepository.save(Veterinario);
    }
    public boolean delete(Integer id){
        veterinarioRepository.delete(findById(id));
        return true;
    }

    public boolean update(Integer id,Veterinario veterinario){
        Veterinario veterinarioeditar = findById(id);
        if (veterinarioeditar != null){
            veterinarioeditar.setNombre(veterinario.getNombre());
            veterinarioeditar.setTelefono(veterinario.getTelefono());
            veterinarioRepository.save(veterinarioeditar);
            return true;
        }else {
            return false;
        }
    }
    
}
