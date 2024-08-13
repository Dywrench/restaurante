package co.edu.konradlorenz.view;

import co.edu.konradlorenz.controller.Mesero;
import co.edu.konradlorenz.model.Plato;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ventana {
    private Scanner leer;
    private Mesero mesero;

    public Ventana(Scanner leer) {
        this.leer = leer;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Seleccionar Plato");
            System.out.println("2. Mostrar Factura");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leer.nextInt();
            leer.nextLine(); 

            switch (opcion) {
                case 1:
                    seleccionarPlato();
                    break;
                case 2:
                    facturar();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 3);

                leer.close();
        System.out.println("Programa terminado.");
    }

    private void seleccionarPlato() {
        List<Plato> platosDisponibles = mesero.getPlatosDisponibles();
        System.out.println("Platos disponibles:");
        for (int i = 0; i < platosDisponibles.size(); i++) {
            Plato plato = platosDisponibles.get(i);
            System.out.println(i + ". " + plato.toString());
        }
        System.out.print("Seleccione el número del plato: ");
        int numPlato = leer.nextInt();
        System.out.print("Ingrese la cantidad: ");
        int cantidad = leer.nextInt();
        leer.nextLine(); 

        Plato platoSeleccionado = platosDisponibles.get(numPlato);

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Para el plato #" + (i + 1) + " (" + platoSeleccionado.getNombrePlato() + "), ¿desea adiciones? (sí/no) (2,000 por adición): ");
            String respuesta = leer.nextLine().trim().toLowerCase();
            if (respuesta.equals("sí") || respuesta.equals("si")) {
                List<String> adiciones = new ArrayList<>();
                System.out.print("Ingrese la cantidad de adiciones: ");
                int numAdiciones = leer.nextInt();
                leer.nextLine(); 
                for (int j = 0; j < numAdiciones; j++) {
                    System.out.print("Ingrese la adición #" + (j + 1) + ": ");
                    String adicion = leer.nextLine();
                    adiciones.add(adicion);
                }

                platoSeleccionado.setAdiciones(adiciones);
            }
        }
        mesero.agregarPlato(platoSeleccionado, cantidad);
    }

    public void facturar() {
        if (mesero != null && !mesero.getPlatosDisponibles().isEmpty()) {
            mesero.mostrarFactura();
        } else {
            System.out.println("No hay pedidos para facturar.");
        }
    }
}