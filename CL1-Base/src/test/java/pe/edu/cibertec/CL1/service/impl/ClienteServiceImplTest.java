package pe.edu.cibertec.CL1.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import pe.edu.cibertec.CL1.model.Cliente;
import pe.edu.cibertec.CL1.model.TipoCliente;
import pe.edu.cibertec.CL1.repo.IClienteRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@WebMvcTest(ClienteServiceImplTest.class)
class ClienteServiceImplTest {

    @InjectMocks
    ClienteServiceImpl clienteServiceImpl;
    @Mock
    IClienteRepo clienteRepo;
    @BeforeEach
    void setUp() {
        clienteServiceImpl = new ClienteServiceImpl(clienteRepo);
    }
    @AfterEach
    void tearDown() { }
    @Test
    void listarClientes() {
        List<Cliente> clientes = generarListaClientes();
        when(clienteRepo.findAll()).thenReturn(clientes);
        List<Cliente> clientesResponse = clienteServiceImpl.listarClientes();
        assertEquals(2, clientesResponse.size());
    }
    @Test
    void obtenerCliente() {
        Cliente cliente = generarCliente();
        when(clienteRepo.findById(anyInt())).thenReturn(Optional.ofNullable(cliente));
        Cliente clienteResponse = clienteServiceImpl.obtenerCliente(1);
        assertEquals(1, clienteResponse.getId());
        /*
         * Not sure if the following code is neccesary for every test
         */
//        assertEquals("Cesar", clienteResponse.getNombre());
//        assertEquals("Herrera",clienteResponse.getApellidoPaterno());
//        assertEquals("Villacorta",clienteResponse.getApellidoMaterno());
//        assertEquals("Jiron Piura 206",clienteResponse.getDireccion());
//        assertEquals("987654321",clienteResponse.getTelefono());
//        assertEquals(1, clienteResponse.getTipoCliente().getId());
//        assertEquals("CAS", clienteResponse.getTipoCliente().getNombre());
    }
    @Test
    void registrarCliente() {
        Cliente cliente = generarCliente();
        when(clienteRepo.save(any(Cliente.class))).thenReturn(cliente);
        Cliente clienteResponse = clienteServiceImpl.registrarCliente(cliente);
        assertEquals(1, clienteResponse.getId());
    }
    @Test
    void modificarCliente() {
        Cliente cliente = generarCliente();
        when(clienteRepo.save(any(Cliente.class))).thenReturn(cliente);
        Cliente clienteResponse = clienteServiceImpl.modificarCliente(cliente);
        assertEquals(1, clienteResponse.getId());
    }
    @Test
    void eliminarCliente() {
        doNothing().when(clienteRepo).deleteById(anyInt());
        String clienteResponse = clienteServiceImpl.eliminarCliente(1);
        assertEquals("Cliente eliminado", clienteResponse);
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