package pe.edu.cibertec.Tema2Sesion2.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.Tema2Sesion2.model.Persona;
import pe.edu.cibertec.Tema2Sesion2.repo.IPersonaRepo;
import pe.edu.cibertec.Tema2Sesion2.service.IPersonaService;
import java.util.List;
@Service
@AllArgsConstructor
public class PersonaServiceImpl implements IPersonaService {
    @Autowired
    private IPersonaRepo personaRepo;
    public List<Persona> listarPersonas() {
        return personaRepo.findAll();
    }
    public Persona obtenerPersona(Integer id) {
        return personaRepo.findById(id).get();
    }
    public Persona registrarPersona(Persona persona) {
        return personaRepo.save(persona);
    }
    public Persona modificarPersona(Persona persona) {
        return personaRepo.save(persona);
    }
    public String eliminarPersona(Integer id) {
        personaRepo.deleteById(id);
        return "Persona eliminada";
    }
}
