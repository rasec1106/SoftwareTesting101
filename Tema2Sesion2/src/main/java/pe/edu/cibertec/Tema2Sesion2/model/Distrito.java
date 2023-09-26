package pe.edu.cibertec.Tema2Sesion2.model;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
@Data
@Entity
@Table(name="distrito")
public class Distrito implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "distrito_id")
    private int id;
    @Column(name = "distrito_nombre")
    private String nombre;
}
