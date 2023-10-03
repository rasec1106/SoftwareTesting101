package pe.edu.cibertec.Tema2Sesion2b.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="distrito")
public class Distrito {
    @Id
    @GeneratedValue
    @Column(name = "distrito_id")
    private int id;
    @Column(name = "distrito_nombre")
    private String nombre;
}
