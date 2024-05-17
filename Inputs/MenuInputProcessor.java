package ar.edu.utn.frbb.tup.Inputs;

import ar.edu.utn.frbb.tup.utils.Banco;
import ar.edu.utn.frbb.tup.utils.Cliente;
import ar.edu.utn.frbb.tup.utils.Cuenta;
import ar.edu.utn.frbb.tup.utils.TipoMovimiento;


public class MenuInputProcessor extends BaseInputProcessor {
    ClienteInputProcessor clienteInputProcessor = new ClienteInputProcessor();
    CuentaInputProcessor cuentaInputProcessor = new CuentaInputProcessor();
    MovimientoInputProcessor movimientoInputProcessor = new MovimientoInputProcessor();
    boolean exit = false;

    public void renderMenu(Banco banco) {

        while (!exit) {
            System.out.println("Bienvenido a la aplicación de Banco!");
            System.out.println("1. Crear un nuevo Cliente");
            System.out.println("2. Crear una nueva Cuenta");
            System.out.println("3. Generar un movimiento");
            System.out.println("4. Mostrar saldo en Pesos");
            System.out.println("5. Mostrar saldo en Dólares");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    Cliente c = clienteInputProcessor.ingresarCliente();
                    banco.addCliente(c);
                    break;
                case 2:
                    Cuenta cuenta = cuentaInputProcessor.ingresarCuenta();
                    System.out.print("Ingrese el DNI del cliente al que quiere asociar la cuenta: ");
                    long dni = scanner.nextLong();
                    scanner.nextLine(); // Consume newline character
                    Cliente cliente = banco.getClientes().stream()
                            .filter(cli -> cli.getDni() == dni)
                            .findFirst()
                            .orElse(null);
                    if (cliente != null) {
                        cliente.addCuenta(cuenta);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 3:
                    TipoMovimiento movimiento = movimientoInputProcessor.ingresarMovimiento();
                    // Aquí se podría asociar el movimiento con una cuenta específica
                    System.out.print("Ingrese el DNI del cliente para el movimiento: ");
                    long dniMovimiento = scanner.nextLong();
                    scanner.nextLine(); // Consume newline character
                    Cliente clienteMovimiento = banco.getClientes().stream().filter(cli -> cli.getDni() == dniMovimiento).findFirst().orElse(null); // Esta linea fue creada con inteligencia artificial pero tambien comprendida. Al final del codigo la explicacion de lo q entendi.
                    if (clienteMovimiento != null) {
                        // El movimiento se aplica a la primera cuenta del cliente
                        if (!clienteMovimiento.getCuentas().isEmpty()) {
                            Cuenta cuentaMovimiento = clienteMovimiento.getCuentas().iterator().next();
                            // Lógica para aplicar el movimiento a la cuenta
                            cuentaMovimiento.setBalance(cuentaMovimiento.getBalance() + (int) movimiento.getMonto());
                            System.out.println("Movimiento aplicado correctamente."); //Se realizo el movimiento
                        } else {
                            System.out.println("El cliente no tiene cuentas asociadas."); //No se encotro la cuenta del cliente 
                        }
                    } else {
                        System.out.println("Cliente no encontrado."); // no se encontro el cliente
                    }
                    break;
                case 4:
                    BancoInputProcessor bancoInputProcessor = new BancoInputProcessor();
                    bancoInputProcessor.mostrarSaldoPesos(banco); //Muestra el saldo dela cuenta en oesos
                    break;
                case 5:
                    BancoInputProcessor bancoInputProcessor2 = new BancoInputProcessor();
                    bancoInputProcessor2.mostrarSaldoDolares(banco); // Muestra el saldo de la cuenta en dolares
                    break;
                case 6:
                    System.out.print("Ingrese el DNI del cliente que desea eliminar: ");
                    long dniEliminar = scanner.nextLong();
                    scanner.nextLine(); 
                    boolean clienteEliminado = banco.eliminarClientePorDNI(dniEliminar);
                    if (clienteEliminado) {
                        System.out.println("Cliente eliminado correctamente."); //Eliminado corrrectamente
                    } else {
                        System.out.println("Cliente no encontrado o no se pudo eliminar."); //Cliente No encontrado 
                    }
                    break;
            
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-6.");
            }
            clearScreen();
        }
    }
}


// Linea 56: Esta linea realiza un stream para operar de manera mas flexible entre la lista, luego filter premite que le apliquemos un filtro a la iteracion en donde le decimos que busque solo los clientes con el mismo dni que el ingresado. Con findFist devuelve el primer elemento que cumple con la condicion del filtio o null si no hubo ninguna coincidencia, esto ultimo lo hacemos con orElse.