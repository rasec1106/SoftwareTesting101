package pe.edu.cibertec.Tema2Sesion2b.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.Tema2Sesion2b.model.Persona;
import pe.edu.cibertec.Tema2Sesion2b.repo.IPersonaRepo;
import pe.edu.cibertec.Tema2Sesion2b.service.IPersonaService;

import java.util.List;
@Service
@AllArgsConstructor
public class PersonaServiceImpl implements IPersonaService {
    @Autowired
    private IPersonaRepo personaRepo;
    @Override
    public List<Persona> listarPersonas() {
        return personaRepo.findAll();
    }

    @Override
    public Persona obtenerPersona(Integer id) {
        return personaRepo.findById(id).get();
    }

    @Override
    public Persona registrarPersona(Persona persona) {
        return personaRepo.save(persona);
    }

    @Override
    public Persona modificarPersona(Persona persona) {
        return personaRepo.save(persona);
    }

    @Override
    public String eliminarPersona(Integer id) {
        personaRepo.deleteById(id);
        return "Persona eliminada";
    }
}
