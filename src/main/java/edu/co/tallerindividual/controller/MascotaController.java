package edu.co.tallerindividual.controller;


import edu.co.tallerindividual.entities.Dueño;
import edu.co.tallerindividual.entities.Mascota;
import edu.co.tallerindividual.services.DueñoServices;
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
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    private MascotaServices mascotaServices;
    @Autowired
    private DueñoServices dueñoServices;


    @GetMapping()
    public ResponseEntity<Object> findAll() {
        List<Mascota> list = mascotaServices.findAll();
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, list);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Integer id) {
        try {
            Mascota mascota = mascotaServices.findById(id);
            if (mascota != null) {
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, mascota);
            } else {
                return ResponseHandler.generateResponse("Mascota not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }
//dueño
    @PostMapping("/{idDueño}")
    public ResponseEntity<Object> save(@PathVariable("idDueño") Integer id,@RequestBody Mascota mascota){
        try {
            Dueño dueño = dueñoServices.findById(id);
            if (dueño != null){
                Mascota result = mascotaServices.save(mascota,dueño);
                return ResponseHandler.generateResponse("Success Author",HttpStatus.CREATED, result);
            }
            return ResponseHandler.generateResponse("Success Author",HttpStatus.NOT_FOUND,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,mascotaServices.delete(id));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Mascota mascota) {
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, mascotaServices.update(id, mascota));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

}
