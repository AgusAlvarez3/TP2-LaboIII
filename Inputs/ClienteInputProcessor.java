package ar.edu.utn.frbb.tup.Inputs;

import ar.edu.utn.frbb.tup.utils.Cliente;
import ar.edu.utn.frbb.tup.utils.TipoPersona;

import java.time.LocalDate;

public class ClienteInputProcessor extends BaseInputProcessor {

    public Cliente ingresarCliente() {
        clearScreen();
        Cliente cliente = new Cliente();

        cliente.setNombre(obtenerNombre());
        cliente.setApellido(obtenerApellido());
        cliente.setTipoPersona(obtenerTipoPersona());
        cliente.setBanco(obtenerBanco());
        cliente.setFechaAlta(obtenerFechaAlta());

        clearScreen();
        return cliente;
    }

    private String obtenerNombre() {
        System.out.println("Ingrese el nombre del cliente:");
        return scanner.nextLine();
    }

    private String obtenerApellido() {
        System.out.println("Ingrese el apellido del cliente:");
        return scanner.nextLine();
    }

    private TipoPersona obtenerTipoPersona() {
        System.out.println("Ingrese el tipo de persona Física(F) o Jurídica(J):");
        String tipoPersonaStr = scanner.nextLine().toUpperCase();
        while (!tipoPersonaStr.equals("F") && !tipoPersonaStr.equals("J")) {
            System.out.println("Tipo de persona inválido. Ingrese F o J:");
            tipoPersonaStr = scanner.nextLine().toUpperCase();
        }
        return TipoPersona.fromString(tipoPersonaStr);
    }

    private String obtenerBanco() {
        System.out.println("Ingrese el banco del cliente:");
        return scanner.nextLine();
    }

    private LocalDate obtenerFechaAlta() {
        System.out.println("Ingrese la fecha de alta del cliente (Formato: YYYY-MM-DD):");
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Ingrese la fecha en formato YYYY-MM-DD:");
            }
        }
    }
}
