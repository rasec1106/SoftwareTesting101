package pe.edu.cibertec.Tema2Sesion2.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import pe.edu.cibertec.Tema2Sesion2.model.Distrito;
import pe.edu.cibertec.Tema2Sesion2.model.Persona;
import pe.edu.cibertec.Tema2Sesion2.repo.IPersonaRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@WebMvcTest(PersonaServiceImplTest.class)
class PersonaServiceImplTest {
    @InjectMocks
    PersonaServiceImpl personaServiceImpl;
    @Mock
    IPersonaRepo personaRepo;
    @BeforeEach
    void setUp() {
        personaServiceImpl = new PersonaServiceImpl(personaRepo);
    }
    @AfterEach
    void tearDown() { }

    @Test
    void listarPersonas() {
        List<Persona> personas = generarListaPersonas();
        when(personaRepo.findAll()).thenReturn(personas);
        List<Persona> personasResponse = personaServiceImpl.listarPersonas();
        assertEquals(2, personasResponse.size());
    }

    @Test
    void obtenerPersona() {
        Persona persona = generarPersona();
        when(personaRepo.findById(anyInt())).thenReturn(Optional.ofNullable(persona));
        Persona personaResponse = personaServiceImpl.obtenerPersona(1);
        assertEquals(1, personaResponse.getId());
    }

    @Test
    void registrarPersona() {
        Persona persona = generarPersona();
        when(personaRepo.save(any(Persona.class))).thenReturn(persona);
        Persona personaResponse = personaServiceImpl.registrarPersona(persona);
        assertEquals(1, personaResponse.getId());
    }

    @Test
    void modificarPersona() {
        Persona persona = generarPersona();
        when(personaRepo.save(any(Persona.class))).thenReturn(persona);
        Persona personaResponse = personaServiceImpl.modificarPersona(persona);
        assertEquals(1, personaResponse.getId());
    }

    @Test
    void eliminarPersona() {
        doNothing().when(personaRepo).deleteById(anyInt());
        String personaResponse = personaServiceImpl.eliminarPersona(1);
        assertEquals("Persona eliminada", personaResponse);
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
        persona2.setId(1);
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