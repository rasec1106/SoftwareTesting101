package pe.edu.cibertec.Tema2Sesion2b.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.Tema2Sesion2b.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer> {
}
