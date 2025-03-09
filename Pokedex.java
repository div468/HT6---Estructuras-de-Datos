import java.util.Map;
public class Pokedex<K, V>{
    protected Map<K, V> coleccion;

    public Pokedex(String mapsolicitado){
        this.coleccion = MapFactory.getMap(mapsolicitado);
    }
}
