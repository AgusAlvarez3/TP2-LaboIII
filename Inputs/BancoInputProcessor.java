package ar.edu.utn.frbb.tup.Inputs;

import ar.edu.utn.frbb.tup.utils.Banco;
import ar.edu.utn.frbb.tup.utils.Cliente;

import java.util.List;

public class BancoInputProcessor extends BaseInputProcessor {

    public void eliminarClientePorDNI(Banco banco) {
        System.out.println("Ingrese el DNI del cliente que desea eliminar:");
        long dni = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea
        
        List<Cliente> clientes = banco.getClientes();
        boolean encontrado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dni) {
                clientes.remove(cliente);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún cliente con ese DNI.");
        }
    }
    
        public void mostrarSaldoPesos(Banco banco) {
            System.out.println("Saldos en Pesos de todos los clientes:");
            List<Cliente> clientes = banco.getClientes();
            for (Cliente cliente : clientes) {
                System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido() +
                        ", Saldo en Pesos: " + cliente.getSaldoPesos());
            }
        }
    
        public void mostrarSaldoDolares(Banco banco) {
            System.out.println("Saldos en Dólares de todos los clientes:");
            List<Cliente> clientes = banco.getClientes();
            for (Cliente cliente : clientes) {
                System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido() +
                        ", Saldo en Dólares: " + cliente.getSaldoDolares());
            }
        }
    }
    
