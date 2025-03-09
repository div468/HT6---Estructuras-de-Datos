import java.util.ArrayList;
import java.util.Scanner;

/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Julián Divas
 * Creación: 08/02/2025
 * última modificación: 08/02/2025
 * File Name: Main.java
 * Descripción: Programa principal con el que el usuario interactúa
 */

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Bienvenido a su colección de pokemones");
        System.out.println("Por favor, ingrese que tipo de Map quiere utilizar para manejar su coleccion");
        String mapsolicitado = scanner.nextLine();
        Pokedex <String, ArrayList<String>> Pokedex = new Pokedex<>(mapsolicitado);
        scanner.close();
    }
}