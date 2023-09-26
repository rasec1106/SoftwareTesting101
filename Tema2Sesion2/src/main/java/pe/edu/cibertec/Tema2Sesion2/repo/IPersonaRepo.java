package pe.edu.cibertec.Tema2Sesion2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.Tema2Sesion2.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer> {
}
