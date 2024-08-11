package co.edu.konradlorenz.controller;

import co.edu.konradlorenz.view.Ventana;
import java.util.Scanner;

public class AplMain {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        Mesero mesero = new Mesero();
        Ventana ventana = new Ventana(scanner);
        ventana.setMesero(mesero);
        ventana.mostrarMenu(); 
    }
}