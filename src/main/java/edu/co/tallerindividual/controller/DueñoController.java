package edu.co.tallerindividual.controller;

import edu.co.tallerindividual.entities.Dueño;
import edu.co.tallerindividual.response.ResponseHandler;
import edu.co.tallerindividual.services.DueñoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dueños")
public class DueñoController {

    @Autowired
    private DueñoServices dueñoServices;

    @GetMapping()
    public ResponseEntity<Object> findAll() {
        List<Dueño> list = dueñoServices.findAll();
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, list);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Integer id) {
        try {
            Dueño dueño = dueñoServices.findById(id);
            if (dueño != null) {
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, dueño);
            } else {
                return ResponseHandler.generateResponse("Dueño not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Dueño Dueño) {
        try {
            Dueño savedDueño = dueñoServices.save(Dueño);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, savedDueño);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable Integer id){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,dueñoServices.delete(id));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Dueño dueño){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK, dueñoServices.update(id,dueño));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e);
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Object> findByNombre(@PathVariable String nombre){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,dueñoServices.findByNombre(nombre));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e);
        }
    }

}
