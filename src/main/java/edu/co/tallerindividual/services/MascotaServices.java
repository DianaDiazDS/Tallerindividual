package edu.co.tallerindividual.services;

import edu.co.tallerindividual.entities.Dueño;
import edu.co.tallerindividual.entities.Mascota;
import edu.co.tallerindividual.entities.Veterinario;
import edu.co.tallerindividual.repositories.MascotaRepository;
import edu.co.tallerindividual.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaServices {
    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    VeterinarioRepository veterinarioRepository;

    public List<Mascota> findAll() {
        return mascotaRepository.findAll();
    }

    public Mascota findById(Integer id) {
        Optional<Mascota> optional = mascotaRepository.findById(id);
        return optional.orElse(null);
    }

    public Mascota save(Mascota mascota, Dueño dueño){
        mascota.setDueño(dueño);
        return mascotaRepository.save(mascota);
    }

    public boolean delete(Integer id){
        mascotaRepository.delete(findById(id));
        return true;
    }


        public Mascota update(Integer id, Mascota mascota) {
        Mascota mascotaeditar = findById(id);
        if (mascotaeditar != null) {
            mascotaeditar.setNombre(mascota.getNombre());
            mascotaeditar.setRaza(mascota.getRaza());
            mascotaeditar.setDueño(mascota.getDueño());
            mascotaeditar.setVeterinarios(mascota.getVeterinarios());
            mascotaeditar.setCarnet(mascota.getCarnet());

            mascotaRepository.save(mascotaeditar);
        }
        return mascotaeditar;
    }

    public List<Mascota> findByRaza(String raza){
        return mascotaRepository.findByRaza(raza);
    }

    public List<Veterinario> getVeterinarios(Mascota mascota) {
        return veterinarioRepository.findVeterinarioByMascotas(mascota);
    }
}
