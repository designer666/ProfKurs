package lesson01;

/**
 * Created by IEvgen Boldyr on 31.05.17.
 */
public interface Map<K extends Comparable, V> {

    /*Пары ключ/значение (key(K)/value(V)*/

    boolean add(K key, V value);

    boolean find(K key);

    V set(K key, V value);

    V get(K key);

    V remove(K key);
}
