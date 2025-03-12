package com.example;
import java.util.ArrayList;
import java.util.List;
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
 * Código implementado con la ayuda de DeepSeek (https://www.deepseek.com).
 */

public class Pokedex<K, V>{
    /**
     * @param coleccion la colección de pokemones leída del archivo CSV
     * @param privada la colección de pokemones personales que tiene el usuario
     */
    protected Map<K, V> coleccion;
    protected ArrayList<String> privada;

    /**
     * @param mapsolicitado el tipo de implementación de MAP a utilizar
     */
    public Pokedex(String mapsolicitado){
        this.coleccion = MapFactory.getMap(mapsolicitado);
        this.privada = new ArrayList<String>();
    }

    /**
     * @return la colección de pokemones generales proveniente del archivo CSV
     */
    public Map<K, V> getColeccion(){
        return coleccion;
    }

    /**
     * @return la colección de pokemones que posee el usuario
     */
    public ArrayList<String> getPrivada(){
        return privada;   
    }

    /**
     * @param nombrepokemon el nombre del pokemon buscado
     * @return verdadero si el pokemon se encuentra en los pokemones del archivo CSV, falso si no se encuentra.
     */
    public boolean verificarExistencia(String nombrepokemon){
        if (coleccion.containsKey(nombrepokemon)){
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Método encargado de ordenar la colección de pokemones personales del usuario (Bubble sort)
     * Además, muestra la lista ya ordenada
     */
    public void ordenarPrivadaPorTipo() {
        if (privada.isEmpty()) {
            System.out.println("No hay pokemones en tu colección.");
            return;
        }
        for (int i = 0; i < privada.size() - 1; i++) {
            for (int j = i + 1; j < privada.size(); j++) {
                List<String> atributosI = (List<String>) coleccion.get(privada.get(i));
                List<String> atributosJ = (List<String>) coleccion.get(privada.get(j));
                String tipoI = atributosI.get(2);
                String tipoJ = atributosJ.get(2);
                if (tipoI.compareTo(tipoJ) > 0) {
                    String temp = privada.get(i);
                    privada.set(i, privada.get(j));
                    privada.set(j, temp);
                }
            }
        }
        System.out.println("Pokemones ordenados por tipo:");
        for (String pokemon : privada) {
            List<String> atributos = (List<String>) coleccion.get(pokemon);
            String tipo = atributos.get(2);
            System.out.println(pokemon + " Tipo: " + tipo);
        }
    }
    
    /**
     * @param lista la lista donde se almacenarán los datos ordenados
     * Implementación del Merge Sort para ordenar Pokémon por tipo.
     * Código desarrollado con la ayuda de DeepSeek (https://www.deepseek.com).
     */
    public void mergeSort(List<Map.Entry<K, V>> lista) {
        if (lista.size() <= 1) return;
        int medio = lista.size() / 2;
        List<Map.Entry<K, V>> izquierda = new ArrayList<>(lista.subList(0, medio));
        List<Map.Entry<K, V>> derecha = new ArrayList<>(lista.subList(medio, lista.size()));
        mergeSort(izquierda);
        mergeSort(derecha);
        merge(lista, izquierda, derecha);
    }
    
    /**
     * @param lista //lista donde se almacenaráel resultado de unir las listas izquierda y derecha
     * @param izquierda Sublista de lado izquierdo ya ordenada a fusionarse
     * @param derecha Sublista de lado derecho ya ordenada a fusionarse
     * Código desarrollado con la ayuda de DeepSeek (https://www.deepseek.com).
     */
    private void merge(List<Map.Entry<K, V>> lista, List<Map.Entry<K, V>> izquierda, List<Map.Entry<K, V>> derecha) {
        int i = 0, j = 0, k = 0;
        while (i < izquierda.size() && j < derecha.size()) {
            String tipoIzq = ((ArrayList<String>) izquierda.get(i).getValue()).get(2);
            String tipoDer = ((ArrayList<String>) derecha.get(j).getValue()).get(2);
    
            if (tipoIzq.compareTo(tipoDer) <= 0) {
                lista.set(k++, izquierda.get(i++));
            } else {
                lista.set(k++, derecha.get(j++));
            }
        }
        while (i < izquierda.size()) lista.set(k++, izquierda.get(i++));
        while (j < derecha.size()) lista.set(k++, derecha.get(j++));
    }
    
    /**
     * Método que utiliza el MAP colección con los pokemones leidos en el CSV y los ordena utilizando el merge sort
     * después, los imprime en orden con un for each.
     */
    public void ordenarPorTipo1PorMergeSort() {
        List<Map.Entry<K, V>> lista = new ArrayList<>(coleccion.entrySet());
        mergeSort(lista);
        System.out.println("Pokemones ordenados por tipo: ");
        for (int i = 0; i < lista.size(); i++) {
            Map.Entry<K, V> entry = lista.get(i);
            ArrayList<String> atributos = (ArrayList<String>) entry.getValue();
            String tipo = atributos.get(2);
            System.out.println(entry.getKey() + " Tipo: " + tipo);
        }
    }

    /**
     * Método encargado de ordenar los pokemones leidos del CSV con las implementaciones MAP
     * obteniendo los pares valor-clave directamente con entry.
     */
    public void ordenarPorTipo1Map() {
        List<Map.Entry<K, V>> listaEntradas = new ArrayList<>(coleccion.entrySet());
        listaEntradas.sort((entry1, entry2) -> {
            List<String> atributos1 = (List<String>) entry1.getValue();
            List<String> atributos2 = (List<String>) entry2.getValue();
            String tipo1 = atributos1.get(2);
            String tipo2 = atributos2.get(2);
            return tipo1.compareTo(tipo2);
        });
    
        System.out.println("Pokémon ordenados por Tipo 1:");
        for (Map.Entry<K, V> entry : listaEntradas) {
            List<String> atributos = (List<String>) entry.getValue();
            String tipo1 = atributos.get(2);
            System.out.println(entry.getKey() + " Tipo: " + tipo1);
        }
        }

    /**
     * @param habilidadbuscada el nombre de la habilidad que se desea buscar en los pokemones
     * El método buscará en cada atributo de los pokemones, en el indice 6 donde están las habilidades, que el
     * argumento ingresado se encuentre ahí, si lo encuentra mostrará el pokemon.
     */
    public void pokemonesPorHabilidad(String habilidadbuscada) {
        System.out.println("Pokémon con " + habilidadbuscada + ":");
        boolean encontrado = false;
        for (K nombrePokemon : coleccion.keySet()) {
            ArrayList<String> atributos = (ArrayList<String>) coleccion.get(nombrePokemon);
            String habilidades = atributos.get(7);
            habilidades = habilidades.replace("\"", "").trim();
            String[] listaHabilidades = habilidades.split(", ");
            for (String habilidad : listaHabilidades) {
                if (habilidad.trim().equalsIgnoreCase(habilidadbuscada.trim())) {
                    System.out.println("- " + nombrePokemon);
                    encontrado = true;
                    break;
                }
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún Pokémon con la habilidad '" + habilidadbuscada + "'.");
        }
    }   
}