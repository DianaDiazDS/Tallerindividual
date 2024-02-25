package edu.co.tallerindividual.services;


import edu.co.tallerindividual.entities.Carnet;
import edu.co.tallerindividual.entities.Mascota;
import edu.co.tallerindividual.repositories.CarnetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarnetServices {

    @Autowired
    CarnetRepository carnetRepository;

    public List<Carnet> findAll() {
        return carnetRepository.findAll();
    }


    public Carnet findById(Integer id) {
        return carnetRepository.findById(id).orElse(null);
    }

    public Carnet save(Carnet carnet, Mascota mascota){
        carnet.setMascota(mascota);
        return carnetRepository.save(carnet);
    }



    public Carnet update(Integer id, Carnet carnet) {
        Carnet carneteditar = findById(id);
        if (carneteditar != null) {
            carneteditar.setDescripcion(carnet.getDescripcion());
            carneteditar.setMascota(carnet.getMascota());

            carnetRepository.save(carneteditar);
        }
        return carneteditar;
    }

}
