package Generics;

import java.util.Map;

public class HashMapGenerics<T,K> {

    private T value;
    private K key;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public HashMapGenerics(T Value, K key) {
        this.key=key;
        this.value=value;
    }




}
