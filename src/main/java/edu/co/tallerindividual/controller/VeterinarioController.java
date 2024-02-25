package edu.co.tallerindividual.controller;

import edu.co.tallerindividual.entities.Mascota;
import edu.co.tallerindividual.entities.Veterinario;
import edu.co.tallerindividual.services.VeterinarioServices;
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
@RequestMapping("/veterinario")
public class VeterinarioController {

    @Autowired
    private VeterinarioServices veterinarioServices;

    @GetMapping()
    public ResponseEntity<Object> findAll() {
        List<Veterinario> list = veterinarioServices.findAll();
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, list);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Integer id) {
        try {
            Veterinario veterinario = veterinarioServices.findById(id);
            if (veterinario != null) {
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, veterinario);
            } else {
                return ResponseHandler.generateResponse("Veterinario not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Veterinario Veterinario) {
        try {
            Veterinario savedVeterinario = veterinarioServices.save(Veterinario);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, savedVeterinario);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,veterinarioServices.delete(id));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Veterinario veterinario){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,veterinarioServices.update(id,veterinario));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

}
