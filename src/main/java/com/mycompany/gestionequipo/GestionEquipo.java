package com.mycompany.gestionequipo;

import java.util.ArrayList;
import java.util.Scanner;

class Jugador {
    private String nombre;
    private int numeroCamiseta;
    private String posicion;

    public Jugador(String nombre, int numeroCamiseta, String posicion) {
        this.nombre = nombre;
        this.numeroCamiseta = numeroCamiseta;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public String getPosicion() {
        return posicion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Número de Camiseta: " + numeroCamiseta + ", Posición: " + posicion;
    }
}

public class GestionEquipo {
    private ArrayList<Jugador> jugadores;

    public GestionEquipo() {
        jugadores = new ArrayList<>();
    }

    public void agregarJugador(String nombre, int numeroCamiseta, String posicion) {
        Jugador nuevoJugador = new Jugador(nombre, numeroCamiseta, posicion);
        jugadores.add(nuevoJugador);
        System.out.println("Jugador agregado: " + nuevoJugador);
    }

    public void mostrarEquipo() {
        if (jugadores.isEmpty()) {
            System.out.println("El equipo está vacío.");
        } else {
            System.out.println("Lista de jugadores:");
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    }

    public void eliminarJugador(String nombre) {
        boolean encontrado = false;
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                jugadores.remove(jugador);
                System.out.println("Jugador eliminado: " + jugador);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Jugador no encontrado.");
        }
    }

    public static void main(String[] args) {
        GestionEquipo gestionEquipo = new GestionEquipo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar jugador");
            System.out.println("2. Mostrar equipo");
            System.out.println("3. Eliminar jugador");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del jugador: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el número de camiseta del jugador: ");
                    int numeroCamiseta = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea después del número
                    System.out.print("Ingrese la posición del jugador: ");
                    String posicion = scanner.nextLine();
                    gestionEquipo.agregarJugador(nombre, numeroCamiseta, posicion);
                    break;
                case 2:
                    gestionEquipo.mostrarEquipo();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del jugador a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    gestionEquipo.eliminarJugador(nombreEliminar);
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}