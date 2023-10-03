package pe.edu.cibertec.Tema2Sesion2b.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.Tema2Sesion2b.model.Persona;
import pe.edu.cibertec.Tema2Sesion2b.service.IPersonaService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/persona")
public class PersonaController {
    @Autowired
    private IPersonaService personaService;
    @GetMapping
    public ResponseEntity<?> listarPersonas() {
        List<Persona> personas = personaService.listarPersonas();
        return new ResponseEntity<>(personas, personas.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> obtenerPersona(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(personaService.obtenerPersona(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> registrarPersona(@RequestBody Persona persona) {
        Persona newPersona = personaService.registrarPersona(persona);
        return new ResponseEntity<Persona>(newPersona, HttpStatus.OK);
    }
    @PutMapping public ResponseEntity<?> modificarPersona(@RequestBody Persona persona) {
        Persona newPersona = personaService.modificarPersona(persona);
        return new ResponseEntity<Persona>(newPersona, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(personaService.eliminarPersona(id), HttpStatus.OK);
    }
}
