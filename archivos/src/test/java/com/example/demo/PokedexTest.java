/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Julián Divas
 * Creación: 08/02/2025
 * última modificación: 08/02/2025
 * File Name: PokedexTest.java
 * Descripción: Pruebas unitarias de métodos de la clase Pokedex
 */
package com.example.demo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.Pokedex;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class PokedexTest {

    private Pokedex<String, ArrayList<String>> pokedex;
    private Map<String, ArrayList<String>> coleccion;
    private ArrayList<String> privada;

    //Se inicializa el objeto Pokedex con las respectivas colecciones
    @BeforeEach
    void setUp() {
        coleccion = new HashMap<>();
        privada = new ArrayList<>();
        pokedex = new Pokedex<>("HashMap");

        ArrayList<String> pikachu = new ArrayList<>();
        pikachu.add("25");
        pikachu.add("Electric");
        pikachu.add("");
        pikachu.add("Mouse Pokémon");
        pikachu.add("0.4");
        pikachu.add("6");
        pikachu.add("Static, Lightning-rod");
        pikachu.add("1");
        pikachu.add("No");

        ArrayList<String> bulbasaur = new ArrayList<>();
        bulbasaur.add("1");
        bulbasaur.add("Grass");
        bulbasaur.add("Poison");
        bulbasaur.add("Seed Pokémon");
        bulbasaur.add("0.7");
        bulbasaur.add("6.9");
        bulbasaur.add("Overgrow, Chlorophyll");
        bulbasaur.add("1");
        bulbasaur.add("No");

        coleccion.put("Pikachu", pikachu);
        coleccion.put("Bulbasaur", bulbasaur);

        privada.add("Pikachu");
        privada.add("Bulbasaur");

        pokedex.getColeccion().putAll(coleccion);
        pokedex.getPrivada().addAll(privada);
    }

    //verifica que se busque correctamente un pokemon en la coleccion
    @Test
    void testVerificarExistencia() {
        assertTrue(pokedex.verificarExistencia("Pikachu"));
        assertFalse(pokedex.verificarExistencia("Charizard"));
    }

    //Verifica que se ordenen correctamente los pokemones de la colección del usuario
    @Test
    void testOrdenarPrivadaPorTipo() {
        pokedex.ordenarPrivadaPorTipo();

        ArrayList<String> privadaOrdenada = pokedex.getPrivada();
        assertEquals("Pikachu", privadaOrdenada.get(0));
        assertEquals("Bulbasaur", privadaOrdenada.get(1));
    }
}