# Hoja de Trabajo 6 - Implementaciones de MAP
[https://github.com/div468/HT6---Estructuras-de-Datos.git](https://github.com/div468/HT6---Estructuras-de-Datos.git)
## ¿Por qué se seleccionó el ArrayList de las colecciones del Java Collection Framework?

## Complejidad para la operación 4

Para ordenar los Pokémon leídos de un CSV, adopté un enfoque basado en la implementación TreeMap, ya que esta estructura ordena automáticamente las claves (en este caso, los tipos de Pokémon o Type1). Esto permite una agrupación y ordenamiento más eficientes. 

Primero se realiza una copia deun MAP genérico (Map<K,V>) a un TreeMap<String,List<K>>, usando como clave el Tipo 1 de los Pokemones y el valor de la lista como nombres de pokemones. Dicha copia posee una complejidad de O(n), siendo n el número de pokemones. Posteriormente, al insertar los elementos al TreeMap cada inserción posee una complejidad de O(log(k)), donde k es el número de claves únicas, tipos unicos en nuestro caso.Ya que se deben recorrer e insertar n Pokemones y considerando que muchos comparten el mismo Tipo 1, al complejidad de inserción es de O(nlog(k)). Esto resulta eficiente debido a la agrupación automática y el ordenamiento que proporciona la implementación TreeMap. Esta implementación es especialmente útil porque aprovecha la repetición de tipos de Pokémon, lo que reduce el número de claves únicas k, mejorando así el rendimiento.

##¿Por qué se utilizó el ArrayList del resto de Colecciones del Java Collection Framwork?

Decidí utilizar ArrayList para guardar los pokemones del usuario debido a que proporciona un acceso sumamente rápido O(1) a la información a través de los índices.Ya que se conocen los índices de la información del ArrayList gracias a las columnas del CSV se explota la complejidad constante de la colección.
