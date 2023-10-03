package pe.edu.cibertec.CL1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name="cliente")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "cliente_id")
    private int id;

    @Column(name = "cliente_nombre")
    private String nombre;

    @Column(name = "cliente_apellidoPaterno")
    private String apellidoPaterno;

    @Column(name = "cliente_apellidoMaterno")
    private String apellidoMaterno;

    @Column(name = "cliente_direccion")
    private String direccion;

    @Column(name = "cliente_telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name="tipoCliente_id", nullable = false)
    private TipoCliente tipoCliente;
}
