package ar.edu.utn.frbb.tup.Inputs;

import ar.edu.utn.frbb.tup.utils.TipoMovimiento;
import java.time.LocalDateTime;

public class MovimientoInputProcessor extends BaseInputProcessor {

    public TipoMovimiento ingresarMovimiento() {
        System.out.println("Ingrese el tipo de movimiento:");
        String tipo = scanner.nextLine();

        System.out.println("Ingrese el monto:");
        while (!scanner.hasNextDouble()) {
            System.out.println("Monto inválido. Ingrese un número:");
            scanner.next();
        }
        double monto = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        LocalDateTime fechaHora = LocalDateTime.now(); // La fecha y hora del movimiento

        return new TipoMovimiento(tipo, monto, fechaHora);
    }
}
