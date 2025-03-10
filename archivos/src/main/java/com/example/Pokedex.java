package com.example;
import java.util.Map;
/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Julián Divas
 * Creación: 08/02/2025
 * última modificación: 08/02/2025
 * File Name: Pokedex.java
 * Descripción: Clase utilizada para almacenar la colección de pokemones
 */
public class Pokedex<K, V>{
    protected Map<K, V> coleccion;

    public Pokedex(String mapsolicitado){
        this.coleccion = MapFactory.getMap(mapsolicitado);
    }

    public Map<K, V> getColeccion(){
        return coleccion;
    }

    public boolean verificarExistencia(String nombrepokemon){
        if (coleccion.containsKey(nombrepokemon)){
            return false;
        }
        else {
            return true;
        }
    }
}
