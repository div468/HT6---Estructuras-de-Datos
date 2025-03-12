package com.example;
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
 
 public class Main {
     public static void main(String[] args) {
         boolean programa = true;
         boolean revisarhashmap = true;
         String map = "";
         Scanner scanner = new Scanner(System.in);
 
         while (revisarhashmap) {
             System.out.println("Por favor, ingrese la opción del tipo de Map que quiere utilizar para manejar su colección:");
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
                     map = "LinkedHashMap";
                     revisarhashmap = false;
                     break;
                 default:
                     System.out.println("Ingrese una implementación válida.");
                     break;
             }
         }

         Pokedex<String, ArrayList<String>> pokedex = new Pokedex<>(map);
         try (BufferedReader lector = new BufferedReader(new FileReader("HT6---Estructuras-de-Datos/archivos/src/pokemon_data_pokeapi.csv"))) {
             String linea;
             boolean primeraLinea = true; 
             while ((linea = lector.readLine()) != null) {
                 if (primeraLinea) {
                     primeraLinea = false;
                     continue;
                 }
 
                 String[] campos = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
 
                 ArrayList<String> datos = new ArrayList<>(Arrays.asList(campos));
 
                 if (datos.size() > 6) {
                     datos.set(6, datos.get(6).replace("\"", ""));
                 }

                 pokedex.getColeccion().put(campos[0], datos);
             }
         } catch (IOException e) {
             e.printStackTrace();
         }

         while (programa) {
             System.out.println("Bienvenido a su colección de Pokémon");
             System.out.println("Ingrese el número de la opción que quiere realizar:");
             System.out.println("1. Agregar un Pokémon a su colección");
             System.out.println("2. Mostrar los datos de un Pokémon específico");
             System.out.println("3. Mostrar el nombre y tipo 1 de sus Pokémon ordenados por tipo 1");
             System.out.println("4. Mostrar todos los pokemones ordenados por tipo 1");
             System.out.println("5. Buscar pokemones que tengan una habilidad específica");
             System.out.println("6. Cerrar el programa");
             int eleccion = 0;
             try {
                eleccion = scanner.nextInt();
                scanner.nextLine();
             } catch (Exception e) {
                System.out.println("Error: Por favor ingrese un número válido");
                scanner.nextLine();
             }
 
             switch (eleccion) {
                 case 1:
                     System.out.println("Ingrese el nombre del Pokémon que desea añadir a su colección:");
                     String pokemonbuscado = scanner.nextLine();
                     if (pokedex.getColeccion().containsKey(pokemonbuscado)) {
                         if (!pokedex.getPrivada().contains(pokemonbuscado)) {
                             pokedex.getPrivada().add(pokemonbuscado);
                             System.out.println("Se añadió el Pokémon a su colección.");
                         } else {
                             System.out.println("Este Pokémon ya se encuentra en su colección.");
                         }
                     } else {
                         System.out.println("ERROR: No fue posible encontrar ese Pokémon.");
                     }
                     break;
                 case 2:
                     System.out.println("Ingrese el nombre del Pokémon del que desea información: ");
                     String pokemoninfo = scanner.nextLine();
                     if (pokedex.getColeccion().containsKey(pokemoninfo)) {
                         ArrayList<String> datos = pokedex.getColeccion().get(pokemoninfo);
                         System.out.println("Información:");
                         System.out.println("Número en la Pokédex: " + datos.get(1));
                         System.out.println("Tipo 1: " + datos.get(2));
                         System.out.println("Tipo 2: " + datos.get(3));
                         System.out.println("Clasificación: " + datos.get(4));
                         System.out.println("Altura (m): " + datos.get(5));
                         System.out.println("Peso (kg): " + datos.get(6));
                         System.out.println("Habilidades: " + datos.get(6));
                         System.out.println("Generación: " + datos.get(8));
                         System.out.println("¿Legendario?: " + datos.get(9));
                     } else {
                         System.out.println("ERROR: No fue posible encontrar ese Pokémon.");
                     }
                     break;
                 case 3:
                     pokedex.ordenarPrivadaPorTipo();
                     break;
                 case 4:
                     System.out.println("Estos son los pokemones ordenados por tipo 1");
                     pokedex.ordenarPorTipo1Map();
                     break;
                case 5:
                    System.out.println("Ingrese la habilidad que desea buscar en los Pokémon:");
                    String habilidadbuscada = scanner.nextLine();
                    pokedex.pokemonesPorHabilidad(habilidadbuscada);
                    break;
                 case 6:
                     programa = false;
                     System.out.println("Gracias por usar la Pokédex.");
                     break;
                 default:
                     System.out.println("Opción no válida. Intente de nuevo.");
                     break;
             }
         }
         scanner.close();
     }
 }