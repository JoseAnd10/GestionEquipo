package com.mycompany.gestionequipo;

import java.util.ArrayList;
import java.util.Iterator;
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
        for (Jugador jugador : jugadores) {
            if (jugador.getNumeroCamiseta() == numeroCamiseta) {
                System.out.println("Error: Ya existe un jugador con este número de camiseta.");
                return;
            }
            if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Error: Ya existe un jugador con este nombre.");
                return;
            }
        }

        if (nombre.trim().isEmpty() || posicion.trim().isEmpty()) {
            System.out.println("Error: Nombre y posición no pueden estar vacíos.");
            return;
        }

        if (numeroCamiseta <= 0) {
            System.out.println("Error: El número de camiseta debe ser mayor a cero.");
            return;
        }

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
        Iterator<Jugador> iterator = jugadores.iterator();
        boolean encontrado = false;
        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();
            if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                iterator.remove();
                System.out.println("Jugador eliminado: " + jugador);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Jugador no encontrado.");
        }
    }

    public static void mostrarMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Agregar jugador");
        System.out.println("2. Mostrar equipo");
        System.out.println("3. Eliminar jugador");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void procesarOpcion(int opcion, GestionEquipo gestionEquipo, Scanner scanner) {
        switch (opcion) {
            case 1:
                agregarJugadorInteractivo(gestionEquipo, scanner);
                break;
            case 2:
                gestionEquipo.mostrarEquipo();
                break;
            case 3:
                eliminarJugadorInteractivo(gestionEquipo, scanner);
                break;
            case 4:
                System.out.println("Saliendo del programa.");
                System.exit(0);
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }

    public static void agregarJugadorInteractivo(GestionEquipo gestionEquipo, Scanner scanner) {
        try {
            System.out.print("Ingrese el nombre del jugador: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el número de camiseta del jugador: ");
            int numeroCamiseta = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número
            System.out.print("Ingrese la posición del jugador: ");
            String posicion = scanner.nextLine();

            gestionEquipo.agregarJugador(nombre, numeroCamiseta, posicion);
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Intente de nuevo.");
            scanner.nextLine(); // Consumir entrada inválida
        }
    }

    public static void eliminarJugadorInteractivo(GestionEquipo gestionEquipo, Scanner scanner) {
        System.out.print("Ingrese el nombre del jugador a eliminar: ");
        String nombre = scanner.nextLine();
        gestionEquipo.eliminarJugador(nombre);
    }

    public static void main(String[] args) {
        GestionEquipo gestionEquipo = new GestionEquipo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea después del número
                procesarOpcion(opcion, gestionEquipo, scanner);
            } catch (Exception e) {
                System.out.println("Error: Entrada inválida. Intente de nuevo.");
                scanner.nextLine(); // Consumir entrada inválida
            }
        }
    }
}
