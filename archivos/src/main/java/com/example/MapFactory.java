package com.example;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Julián Divas
 * Creación: 08/02/2025
 * última modificación: 08/02/2025
 * File Name: MapFactory.java
 * Descripción: Patrón de Diseño Factory para decidir que implementación de Map será utilizada
 */

public class MapFactory<K, V> {
    /**
     * @param <K> Tipo de valor asociado a la llave del map
     * @param <V> Tipo de valor asociado al value del map
     * @param mapsolicitado El String que indica que implementación de MAP se utilizará
     * @return La implementación correspondiente de MAP según el argumento ingresado.
     */
    public static <K, V> Map<K, V> getMap(String mapsolicitado){
        if(mapsolicitado.equalsIgnoreCase("HashMap")){
            return new HashMap<K,V>();
        }
        else if(mapsolicitado.equalsIgnoreCase("TreeMap")){
            return new TreeMap<K, V>();
        }
        else {
            return new LinkedHashMap<K, V>();
        }
    }
}