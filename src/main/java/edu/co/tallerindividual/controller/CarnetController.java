package edu.co.tallerindividual.controller;

import edu.co.tallerindividual.entities.Carnet;
import edu.co.tallerindividual.entities.Mascota;
import edu.co.tallerindividual.services.CarnetServices;
import edu.co.tallerindividual.services.MascotaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.co.tallerindividual.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/carnets")
public class CarnetController {
    @Autowired
    private CarnetServices carnetServices;
    @Autowired
    private MascotaServices mascotaServices;


    @GetMapping()
    public ResponseEntity<Object> findAll() {
        List<Carnet> list = carnetServices.findAll();
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, list);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Integer  id) {
        try {
            Carnet carnet = carnetServices.findById(id);
            if (carnet != null) {
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, carnet);
            } else {
                return ResponseHandler.generateResponse("Carnet not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }


    @PostMapping("/{idMascota}")
    public ResponseEntity<Object> save(@PathVariable Integer idMascota,@RequestBody Carnet carnet){
        try {
            Mascota mascota = mascotaServices.findById(idMascota);
            if (mascota != null){
                carnet.setIdCarnet(idMascota);
                Carnet result = carnetServices.save(carnet,mascota);
                return ResponseHandler.generateResponse("Success",HttpStatus.CREATED,carnet);
            }
            return ResponseHandler.generateResponse("No found Client",HttpStatus.NOT_FOUND,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Carnet carnet) {
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK,carnetServices.update(id, carnet));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

}
