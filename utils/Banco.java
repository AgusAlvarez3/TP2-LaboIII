package ar.edu.utn.frbb.tup.utils;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public boolean eliminarClientePorDNI(long dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dni) {
                clientes.remove(cliente);
                return true; // Cliente eliminado 
            }
        }
        return false; // Cliente no encontrado
    }
}
