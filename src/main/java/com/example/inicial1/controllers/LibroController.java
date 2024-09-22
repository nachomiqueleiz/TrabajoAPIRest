package com.example.inicial1.controllers;

import com.example.inicial1.entities.Libro;
import com.example.inicial1.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/libros")
public class LibroController {

    @Autowired
    LibroService libroService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(libroService.findAll());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, no pudimos encontrar el personal\"}");
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(libroService.findById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, no pudo ser encontrado el objeto solicitado\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Libro entity){

        System.out.println("Estos datos los tomo del cuerpo del Formulario");
        System.out.println("Título :" + entity.getTitulo());
        System.out.println("Fecha :" + entity.getFecha());
        System.out.println("Género :" + entity.getGenero());
        System.out.println("Páginas :" + entity.getPaginas());
        System.out.println("Autor :" + entity.getAutor());

        try{
            return ResponseEntity.status(HttpStatus.OK).body(libroService.save(entity));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevamente\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Libro entity){
        System.out.println("EL ID LO TOMO DE LA URL");
        System.out.println("Nombre :" + entity.getId());
        System.out.println("Estos datos los tomo del cuerpo del Formulario");
        System.out.println("Título :" + entity.getTitulo());
        System.out.println("Fecha :" + entity.getFecha());
        System.out.println("Género :" + entity.getGenero());
        System.out.println("Páginas :" + entity.getPaginas());
        System.out.println("Autor :" + entity.getAutor());
        try{
            return ResponseEntity.status(HttpStatus.OK).body(libroService.update(id, entity));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, no se pudieron actualizar los datos\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(libroService.delete(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, no pudo ser borrado correctamente\"}");
        }
    }
}
