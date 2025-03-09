import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        Pokedex <String, ArrayList<String>> pokedex = new Pokedex<>(mapsolicitado);
        scanner.close();
        try (BufferedReader lector = new BufferedReader(new FileReader("pokemon_data_pokeapi.csv"))) {
        String linea;
        while ((linea = lector.readLine()) != null) {
            String[] informacion = linea.split(",");
            ArrayList<String> datos = new ArrayList<>(Arrays.asList(informacion));
            datos.remove(0);
            pokedex.getColeccion().put(informacion[0], datos);
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}