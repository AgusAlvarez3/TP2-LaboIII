package ar.edu.utn.frbb.tup.Inputs;

import ar.edu.utn.frbb.tup.utils.Cuenta;
import java.time.LocalDateTime;

public class CuentaInputProcessor extends BaseInputProcessor {

    public Cuenta ingresarCuenta() {
        System.out.println("Ingrese el nombre de la cuenta:");
        String nombreCuenta = scanner.nextLine();

        LocalDateTime fechaCreacion = LocalDateTime.now(); // La fecha de creación

        System.out.println("Ingrese el balance inicial:");
        while (!scanner.hasNextInt()) {
            System.out.println("Balance inicial inválido. Ingrese un número entero:");
            scanner.next();
        }
        int balanceInicial = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        return new Cuenta(nombreCuenta, fechaCreacion, balanceInicial);
    }
}
