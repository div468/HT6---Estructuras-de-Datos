import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

}
