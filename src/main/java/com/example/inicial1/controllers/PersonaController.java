package com.example.inicial1.controllers;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/personas")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findAll());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, no pudimos encontrar el personal\"}");
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, no pudo ser encontrado el objeto solicitado\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Persona entity){

        System.out.println("Estos datos los tomo del cuerpo del Formulario");
        System.out.println("Nombre :" + entity.getNombre());
        System.out.println("Apellido :" + entity.getApellido());

        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaService.save(entity));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevamente\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Persona entity){
        System.out.println("EL ID LO TOMO DE LA URL");
        System.out.println("Nombre :" + entity.getId());
        System.out.println("Estos datos los tomo del cuerpo del Formulario");
        System.out.println("Nombre :" + entity.getNombre());
        System.out.println("Apellido :" + entity.getApellido());
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaService.update(id, entity));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, no se pudieron actualizar los datos\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personaService.delete(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, no pudo ser borrado correctamente\"}");
        }
    }
}