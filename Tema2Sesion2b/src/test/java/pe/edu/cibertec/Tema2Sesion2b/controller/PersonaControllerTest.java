package pe.edu.cibertec.Tema2Sesion2b.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pe.edu.cibertec.Tema2Sesion2b.model.Distrito;
import pe.edu.cibertec.Tema2Sesion2b.model.Persona;
import pe.edu.cibertec.Tema2Sesion2b.service.impl.PersonaServiceImpl;
import java.util.ArrayList; import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@WebMvcTest(PersonaControllerTest.class)
class PersonaControllerTest {

    @InjectMocks
    PersonaController personaController;
    @Mock
    PersonaServiceImpl personaServiceImpl;
    @BeforeEach
    void setUp() {
        personaController = new PersonaController(personaServiceImpl);
    }
    @AfterEach
    void tearDown() { }
    @Test
    void listarPersonas() {
        List<Persona> personas = generarListaPersonas();
        when(personaServiceImpl.listarPersonas()).thenReturn(personas);
        ResponseEntity<?> responseEntity = personaController.listarPersonas();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<Persona> personasResponse = (List<Persona>) responseEntity.getBody();
        assertEquals(2, personasResponse.size());
    }
    @Test
    void obtenerPersona() {
        Persona persona = generarPersona();
        when(personaServiceImpl.obtenerPersona(anyInt())).thenReturn(persona);
        ResponseEntity<?> responseEntity = personaController.obtenerPersona(1);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Persona personaResponse = (Persona) responseEntity.getBody();
        assertEquals(1, personaResponse.getId());
    }
    @Test
    void registrarPersona() {
        Persona persona = generarPersona();
        when(personaServiceImpl.registrarPersona(any(Persona.class))).thenReturn(persona);
        ResponseEntity<?> responseEntity = personaController.registrarPersona(persona);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Persona personaResponse = (Persona) responseEntity.getBody();
        assertEquals(1, personaResponse.getId());
    }
    @Test
    void modificarPersona() {
        Persona persona = generarPersona();
        when(personaServiceImpl.modificarPersona(any(Persona.class))).thenReturn(persona);
        ResponseEntity<?> responseEntity = personaController.modificarPersona(persona);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Persona personaResponse = (Persona) responseEntity.getBody();
        assertEquals(1, personaResponse.getId());
    }
    @Test
    void eliminarPersona() {
        when(personaServiceImpl.eliminarPersona(anyInt())).thenReturn("Persona eliminada");
        personaController.eliminarPersona(1);
        verify(personaServiceImpl,times(1)).eliminarPersona(anyInt());
    }
    List generarListaPersonas(){
        Distrito distrito = new Distrito();
        distrito.setId(1);
        distrito.setNombre("Lima");
        Persona persona1 = new Persona();
        persona1.setId(1);
        persona1.setNombre("mynombre1");
        persona1.setApellido("myApellido1");
        persona1.setDireccion("myDireccion1");
        persona1.setTelefono("987654321");
        persona1.setDistrito(distrito);
        Persona persona2 = new Persona();
        persona2.setId(2);
        persona2.setNombre("mynombre2");
        persona2.setApellido("myApellido2");
        persona2.setDireccion("myDireccion2");
        persona2.setTelefono("963852741");
        persona2.setDistrito(distrito);
        List<Persona> personas = new ArrayList<>();
        personas.add(persona1);
        personas.add(persona2);
        return personas;
    }
    Persona generarPersona(){
        Distrito distrito = new Distrito();
        distrito.setId(1);
        distrito.setNombre("Lima");
        Persona persona = new Persona();
        persona.setId(1);
        persona.setNombre("mynombre1");
        persona.setApellido("myApellido1");
        persona.setDireccion("myDireccion1");
        persona.setTelefono("987654321");
        persona.setDistrito(distrito);
        return persona;
    }

}