package pe.edu.cibertec.Tema2Sesion2.model;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
@Entity
@Data
@Table(name="persona")
public class Persona implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "persona_id")
    private int id;
    @Column(name = "persona_nombre")
    private String nombre;
    @Column(name = "persona_apellido")
    private String apellido;
    @Column(name = "persona_direccion")
    private String direccion;
    @Column(name = "persona_telefono")
    private String telefono;
    @ManyToOne
    @JoinColumn(name="distrito_id", nullable = false)
    private Distrito distrito;
}
