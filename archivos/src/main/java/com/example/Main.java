package com.example;
import java.io.BufferedReader;
import java.io.File;
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
            boolean programa = true; 
            while (programa){
            Scanner scanner = new Scanner (System.in);
            System.out.println("Bienvenido a su colección de pokemones");
            boolean revisarhashmap = true;
            String map = "";
            while (revisarhashmap){
            System.out.println("Por favor, ingrese la opción del tipo de Map quiere utilizar para manejar su coleccion");
            System.out.println("1. HashMap");
            System.out.println("2. TreeMap");
            System.out.println("3. LinkedHashMap");
            int hashmap = scanner.nextInt();
            scanner.nextLine();
            switch (hashmap) {
                case 1:
                    map = "HashMap";
                    revisarhashmap = false;
                    break;
                case 2:
                    map = "TreeMap";
                    revisarhashmap = false;
                    break;
                case 3:
                    revisarhashmap = false;
                    map = "LinkedHashMap";
                default:
                    System.out.println("Ingrese una implementación válida");
                    break;
                }
                }
            Pokedex <String, ArrayList<String>> pokedex = new Pokedex<>(map);
            try (BufferedReader lector = new BufferedReader(new FileReader("HT6---Estructuras-de-Datos/archivos/src/pokemon_data_pokeapi.csv"
            ))) {
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
            System.out.println("Directorio actual: " + new File(".").getAbsolutePath());
            System.out.println(pokedex.getColeccion());
            System.out.println("Ingrese el número de la opción que quiere realizar: ");
            System.out.println("1. Agregar un pokemon a su colección");
            System.out.println("2. Mostrar los datos de un pokemon específico");
            System.out.println("3. Mostrar el nombre y tipo 1 de sus pokemones ordenados por tipo 1");
            System.out.println("4. Mostrar pokemones que posean una habilidad específica");
            int eleccion = scanner.nextInt();
            scanner.nextLine();

            switch (eleccion) {
                case 1:
                    System.out.println("Ingrese el nombre de su nuevo pokemon: ");
                    String nuevopokemon = scanner.nextLine();
                    if (pokedex.verificarExistencia(nuevopokemon)){
                        boolean verificartipo1 = true;
                        while (verificartipo1) {
                        System.out.println("Ingrese el número de opción correspondiente al tipo de pokemon: ");
                        System.out.println("1. Normal");
                        System.out.println("2. Fire");
                        System.out.println("3. Water");
                        System.out.println("4. Electric");
                        System.out.println("5. Grass");
                        System.out.println("6. Ice");
                        System.out.println("7. Fighting");
                        System.out.println("8. Poison");
                        System.out.println("9. Ground");
                        System.out.println("10. Flying");
                        System.out.println("11. Psychic");
                        System.out.println("12. Bug");
                        System.out.println("13. Rock");
                        System.out.println("14. Ghost");
                        System.out.println("15. Dragon");
                        System.out.println("16. Dark");
                        System.out.println("17. Steel");
                        System.out.println("18. Fairy");
                        int tipoNumero = scanner.nextInt();
                        scanner.nextLine();
                        String tipo1string;
                        switch (tipoNumero) {
                            case 1:
                                tipo1string = "Normal";
                                verificartipo1 = false;
                                break;
                            case 2:
                                tipo1string = "Fire";
                                verificartipo1 = false;
                                break;
                            case 3:
                                tipo1string = "Water";
                                verificartipo1 = false;
                                break;
                            case 4:
                                tipo1string = "Electric";
                                verificartipo1 = false;
                                break;
                            case 5:
                                tipo1string = "Grass";
                                verificartipo1 = false;
                                break;
                            case 6:
                                tipo1string = "Ice";
                                verificartipo1 = false;
                                break;
                            case 7:
                                tipo1string = "Fighting";
                                verificartipo1 = false;
                                break;
                            case 8:
                                tipo1string = "Poison";
                                verificartipo1 = false;
                                break;
                            case 9:
                                tipo1string = "Ground";
                                verificartipo1 = false;
                                break;
                            case 10:
                                tipo1string = "Flying";
                                verificartipo1 = false;
                                break;
                            case 11:
                                tipo1string = "Psychic";
                                verificartipo1 = false;
                                break;
                            case 12:
                                tipo1string = "Bug";
                                verificartipo1 = false;
                                break;
                            case 13:
                                tipo1string = "Rock";
                                verificartipo1 = false;
                                break;
                            case 14:
                                tipo1string = "Ghost";
                                verificartipo1 = false;
                                break;
                            case 15:
                                tipo1string = "Dragon";
                                verificartipo1 = false;
                                break;
                            case 16:
                                tipo1string = "Dark";
                                verificartipo1 = false;
                                break;
                            case 17:
                                tipo1string = "Steel";
                                verificartipo1 = false;
                                break;
                            case 18:
                                tipo1string = "Fairy";
                                verificartipo1 = false;
                                break;
                            default:
                                tipo1string = "Tipo no válido";
                                break;
                        }
                        }
                        boolean verificartipo2 = true;
                        while (verificartipo2){
                            System.out.println("Su pokemon también tiene un tipo 2?");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            int opciontipo2 = scanner.nextInt();
                            scanner.nextLine();
                            if (opciontipo2 == 1){
                                System.out.println("Ingrese el número de tipo 2 correspondiente a su pokemon: ");
                                System.out.println("Ingrese el número de opción correspondiente al tipo de pokemon: ");
                                System.out.println("1. Normal");
                                System.out.println("2. Fire");
                                System.out.println("3. Water");
                                System.out.println("4. Electric");
                                System.out.println("5. Grass");
                                System.out.println("6. Ice");
                                System.out.println("7. Fighting");
                                System.out.println("8. Poison");
                                System.out.println("9. Ground");
                                System.out.println("10. Flying");
                                System.out.println("11. Psychic");
                                System.out.println("12. Bug");
                                System.out.println("13. Rock");
                                System.out.println("14. Ghost");
                                System.out.println("15. Dragon");
                                System.out.println("16. Dark");
                                System.out.println("17. Steel");
                                System.out.println("18. Fairy");
                                int tipo2 = scanner.nextInt();
                                String tipo2string;
                                switch (tipo2) {
                                    case 1:
                                        tipo2string = "Normal";
                                        verificartipo2 = false;
                                        break;
                                    case 2:
                                        tipo2string = "Fire";
                                        verificartipo2 = false;
                                        break;
                                    case 3:
                                        tipo2string = "Water";
                                        verificartipo2 = false;
                                        break;
                                    case 4:
                                        tipo2string = "Electric";
                                        verificartipo2 = false;
                                        break;
                                    case 5:
                                        tipo2string = "Grass";
                                        verificartipo2 = false;
                                        break;
                                    case 6:
                                        tipo2string = "Ice";
                                        verificartipo2 = false;
                                        break;
                                    case 7:
                                        tipo2string = "Fighting";
                                        verificartipo2 = false;
                                        break;
                                    case 8:
                                        tipo2string = "Poison";
                                        verificartipo2 = false;
                                        break;
                                    case 9:
                                        tipo2string = "Ground";
                                        verificartipo2 = false;
                                        break;
                                    case 10:
                                        tipo2string = "Flying";
                                        verificartipo2 = false;
                                        break;
                                    case 11:
                                        tipo2string = "Psychic";
                                        verificartipo2 = false;
                                        break;
                                    case 12:
                                        tipo2string = "Bug";
                                        verificartipo2 = false;
                                        break;
                                    case 13:
                                        tipo2string = "Rock";
                                        verificartipo2 = false;
                                        break;
                                    case 14:
                                        tipo2string = "Ghost";
                                        verificartipo2 = false;
                                        break;
                                    case 15:
                                        tipo2string = "Dragon";
                                        verificartipo2 = false;
                                        break;
                                    case 16:
                                        tipo2string = "Dark";
                                        verificartipo2 = false;
                                        break;
                                    case 17:
                                        tipo2string = "Steel";
                                        verificartipo2 = false;
                                        break;
                                    case 18:
                                        tipo2string = "Fairy";
                                        verificartipo2 = false;
                                        break;
                                    default:
                                        tipo2string = "Tipo no válido";
                                        break;
                                }
                            }
                            else if (opciontipo2 == 2){
                                verificartipo2 = false;
                            }
                            else {
                                System.out.println("Ingrese una opción válida");
                            }
                        }
                        System.out.println("Ingrese la clasificación de su pokemon: ");
                        String clasificacion = scanner.nextLine();
                        boolean verificarAltura = true;
                        while (verificarAltura){
                            System.out.println("Ingrese la altura de su pokemon en metros");
                            float altura = scanner.nextFloat();
                            scanner.nextLine();
                            if (altura <= 0){
                                System.out.println("Ingrese una altura valida");
                            }
                            else  {
                                verificarAltura = false;
                            }
                        }

                        boolean verificarPeso = true;
                        while (verificarPeso){
                            System.out.println("Ingrese el peso de su pokemon en kilogramos");
                            float peso = scanner.nextFloat();
                            scanner.nextLine();
                            if(peso <= 0){
                                System.out.println("Ingrese un peso valido");
                            }
                            else {
                                verificarPeso = false;
                            }
                        }
                        

                        
                    }
                    else {
                        System.out.println("Ese pokemon ya está en la pokedex");
                    }

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4: 
                    break;
                default:
                    break;
            }
        }
    }
}