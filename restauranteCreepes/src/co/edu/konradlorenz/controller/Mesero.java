package co.edu.konradlorenz.controller;
import co.edu.konradlorenz.model.Plato;
import java.util.ArrayList;
import java.util.List;

public class Mesero {
    private List<Plato> platosDisponibles;
    private List<Plato> platosSeleccionados;
    private List<Integer> cantidades;

    public Mesero() {
        platosDisponibles = new ArrayList<>();
        platosDisponibles.add(new Plato("Pizza", "Coca-Cola", new ArrayList<>(), 20000));
        platosDisponibles.add(new Plato("Hamburguesa", "Sprite", new ArrayList<>(), 15000));
        platosDisponibles.add(new Plato("Sushi", "Agua", new ArrayList<>(), 25000));

        platosSeleccionados = new ArrayList<>();
        cantidades = new ArrayList<>();
    }

    public List<Plato> getPlatosDisponibles() {
        return platosDisponibles;
    }

    public void agregarPlato(Plato plato, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            platosSeleccionados.add(plato);
            cantidades.add(1); 
        }
    }

    public void mostrarFactura() {
        int total = 0;
        System.out.println("Factura:");
        for (int i = 0; i < platosSeleccionados.size(); i++) {
            Plato plato = platosSeleccionados.get(i);
            int cantidad = cantidades.get(i);
            int subtotal = plato.getPrecioConAdiciones();
            total += subtotal;
            if (plato.getAdiciones().isEmpty()) {
                System.out.println(plato.getNombrePlato() + " x" + cantidad + " - $" + subtotal);
            } else {
                System.out.println(plato.getNombrePlato() + " x" + cantidad + " con adiciones: " + plato.getAdiciones() + " - $" + subtotal);
            }
        }
        System.out.println("Total a pagar: $" + total);
    }
}
