package pe.edu.cibertec.Tema2Sesion2.service;

import pe.edu.cibertec.Tema2Sesion2.model.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> listarPersonas();
    public Persona obtenerPersona(Integer id);
    public Persona registrarPersona(Persona persona);
    public Persona modificarPersona(Persona persona);
    public String eliminarPersona(Integer id);
}