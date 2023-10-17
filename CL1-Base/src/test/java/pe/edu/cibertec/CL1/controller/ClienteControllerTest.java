package pe.edu.cibertec.CL1.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pe.edu.cibertec.CL1.model.Cliente;
import pe.edu.cibertec.CL1.model.TipoCliente;
import pe.edu.cibertec.CL1.service.impl.ClienteServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@WebMvcTest(ClienteControllerTest.class)
class ClienteControllerTest {
    @InjectMocks
    ClienteController clienteController;
    @Mock
    ClienteServiceImpl clienteServiceImpl;
    @BeforeEach
    void setUp() {
        clienteController = new ClienteController(clienteServiceImpl);
    }
    @AfterEach
    void tearDown() { }
    @Test
    void listarClientes() {
        List<Cliente> clientes = generarListaClientes();
        when(clienteServiceImpl.listarClientes()).thenReturn(clientes);
        ResponseEntity<?> responseEntity = clienteController.listarClientes();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<Cliente> clientesResponse = (List<Cliente>) responseEntity.getBody();
        assertEquals(2, clientesResponse.size());
    }
    @Test
    void obtenerCliente() {
        Cliente cliente = generarCliente();
        when(clienteServiceImpl.obtenerCliente(anyInt())).thenReturn(cliente);
        ResponseEntity<?> responseEntity = clienteController.obtenerCliente(1);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Cliente clienteResponse = (Cliente) responseEntity.getBody();
        assertEquals(1, clienteResponse.getId());
    }
    @Test
    void registrarCliente() {
        Cliente cliente = generarCliente();
        when(clienteServiceImpl.registrarCliente(any(Cliente.class))).thenReturn(cliente);
        ResponseEntity<?> responseEntity = clienteController.registrarCliente(cliente);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Cliente clienteResponse = (Cliente) responseEntity.getBody();
        assertEquals(1, clienteResponse.getId());
    }
    @Test
    void modificarCliente() {
        Cliente cliente = generarCliente();
        when(clienteServiceImpl.modificarCliente(any(Cliente.class))).thenReturn(cliente);
        ResponseEntity<?> responseEntity = clienteController.modificarCliente(cliente);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Cliente clienteResponse = (Cliente) responseEntity.getBody();
        assertEquals(1, clienteResponse.getId());
    }
    @Test
    void eliminarCliente() {
        when(clienteServiceImpl.eliminarCliente(anyInt())).thenReturn("Cliente eliminado");
        clienteController.eliminarCliente(1);
        verify(clienteServiceImpl,times(1)).eliminarCliente(anyInt());
    }
    List generarListaClientes(){
        TipoCliente tipoCliente = new TipoCliente();
        tipoCliente.setId(1);
        tipoCliente.setNombre("Tiempo Completo");
        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNombre("Cesar");
        cliente1.setApellidoPaterno("Herrera");
        cliente1.setApellidoMaterno("Villacorta");
        cliente1.setDireccion("Jiron Piura 206");
        cliente1.setTelefono("987654321");
        cliente1.setTipoCliente(tipoCliente);
        Cliente cliente2 = new Cliente();
        cliente2.setId(1);
        cliente2.setNombre("Vanessa");
        cliente2.setApellidoPaterno("Vargas");
        cliente2.setApellidoMaterno("Solano");
        cliente2.setDireccion("Av. Callao 987");
        cliente2.setTelefono("963852741");
        cliente2.setTipoCliente(tipoCliente);
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        return clientes;
    }
    Cliente generarCliente(){
        TipoCliente tipoCliente = new TipoCliente();
        tipoCliente.setId(1);
        tipoCliente.setNombre("CAS");
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNombre("Cesar");
        cliente.setApellidoPaterno("Herrera");
        cliente.setApellidoMaterno("Villacorta");
        cliente.setDireccion("Jiron Piura 206");
        cliente.setTelefono("987654321");
        cliente.setTipoCliente(tipoCliente);
        return cliente;
    }
}